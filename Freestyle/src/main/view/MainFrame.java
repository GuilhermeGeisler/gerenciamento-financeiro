package src.main.view;

import src.main.model.lancamento.Lancamento;
import src.main.model.lancamento.despesa.CategoriaDespesa;
import src.main.model.lancamento.despesa.Despesa;
import src.main.model.lancamento.receita.CategoriaReceita;
import src.main.model.lancamento.receita.Receita;
import src.main.model.repository.LancamentoRepository;
import src.main.model.repository.LancamentoRepositoryImpl;
import src.main.model.service.LancamentoService;
import src.main.model.service.LancamentoServiceImpl;
import src.main.model.util.DateUtils;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.List;

public class MainFrame extends JFrame {

    private final DateUtils dateUtils = new DateUtils();
    private final LancamentoService lancamentoService = new LancamentoServiceImpl();
    private final LancamentoRepository lancamentoRepository = new LancamentoRepositoryImpl();

    public MainFrame() {
        // Carregar dados salvos
        List<Lancamento> lancamentos = lancamentoRepository.carregar();
        lancamentos.forEach(lancamentoService::adicionarLancamento);

        setTitle("Controle de Receitas e Despesas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));


        JButton btnAddReceita = new JButton("Adicionar Receita");
        panel.add(btnAddReceita);
        btnAddReceita.addActionListener(e -> adicionarReceita());

        JButton btnAddDespesa = new JButton("Adicionar Despesa");
        panel.add(btnAddDespesa);
        btnAddDespesa.addActionListener(e -> adicionarDespesa());

        JButton btnSaldoAtual = new JButton("Consultar Saldo Atual");
        panel.add(btnSaldoAtual);
        btnSaldoAtual.addActionListener(e -> consultarSaldoAtual());

        JButton btnSaldoTotal = new JButton("Consultar Saldo Total");
        panel.add(btnSaldoTotal);
        btnSaldoTotal.addActionListener(e -> consultarSaldoTotal());

        JButton btnListarLancamentos = new JButton("Listar Lançamentos");
        panel.add(btnListarLancamentos);
        btnListarLancamentos.addActionListener(e -> listarLancamentos());

        add(panel, BorderLayout.CENTER);
    }

    private void adicionarReceita() {
        adicionarLancamento(CategoriaReceita.class, Receita.class);
    }

    private void adicionarDespesa() {
        adicionarLancamento(CategoriaDespesa.class, Despesa.class);
    }

    private <E extends Enum<E>, T extends Lancamento<E>> void adicionarLancamento(Class<E> categoriaClass, Class<T> lancamentoClass) {
        try {
            // Solicitar a data
            String dataStr = JOptionPane.showInputDialog(this, "Data (DD/MM/YYYY):");
            Date data = dateUtils.stringToDate(dataStr);

            // Solicitar o valor
            double valor = Double.parseDouble(JOptionPane.showInputDialog(this, "Valor:"));

            // Obter categorias disponíveis
            E[] categorias = categoriaClass.getEnumConstants();
            String[] categoriaLabels = new String[categorias.length];
            for (int i = 0; i < categorias.length; i++) {
                categoriaLabels[i] = categorias[i].toString();  // Assuming toString returns the label
            }

            // Escolher a categoria
            String categoriaLabel = (String) JOptionPane.showInputDialog(
                    this,
                    "Escolha uma categoria:",
                    "Categoria",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    categoriaLabels,
                    categoriaLabels[0]
            );

            // Identificar a categoria escolhida
            E categoria = categorias[java.util.Arrays.asList(categoriaLabels).indexOf(categoriaLabel)];

            // Criar o lançamento (Receita ou Despesa)
            T lancamento = lancamentoClass.getDeclaredConstructor().newInstance();
            lancamento.setData(data);
            lancamento.setValor(valor);
            lancamento.setCategoria(categoria);

            // Adicionar o lançamento
            lancamentoService.adicionarLancamento(lancamento);

            // Exibir mensagem de sucesso
            String tipo = lancamentoClass.getSimpleName();
            JOptionPane.showMessageDialog(this, tipo + " adicionada com sucesso!");
        } catch (Exception ex) {
            // Exibir mensagem de erro
            JOptionPane.showMessageDialog(this, "Erro ao adicionar lançamento: " + ex.getMessage());
        }

        // Salvar os dados (CSV)
        salvarDados();
    }

    private void consultarSaldoAtual() {
        Date hoje = new Date();
        double saldo = lancamentoService.consultarSaldoAte(hoje);
        JOptionPane.showMessageDialog(this, "Saldo disponível até hoje: R$ " + String.format("%.2f", saldo));
    }

    private void consultarSaldoTotal() {
        double saldo = lancamentoService.consultarSaldoTotal();
        JOptionPane.showMessageDialog(this, "Saldo total disponível: R$ " + String.format("%.2f", saldo));
    }

    private void listarLancamentos() {
        List<Lancamento> lancamentos = lancamentoService.listarLancamentos();
        String[] columnNames = {"Data", "Valor", "Categoria", "Saldo"};
        Object[][] data = new Object[lancamentos.size()][4];

        double saldo = 0;
        for (int i = 0; i < lancamentos.size(); i++) {
            Lancamento lancamento = lancamentos.get(i);
            saldo += lancamento.getValor();
            data[i][0] = dateUtils.dateToString(lancamento.getData());
            data[i][1] = String.format("%.2f", lancamento.getValor());
            data[i][2] = lancamento.getCategoria().toString();
            data[i][3] = String.format("%.2f", saldo);
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        JOptionPane.showMessageDialog(this, scrollPane, "Lançamentos", JOptionPane.INFORMATION_MESSAGE);
    }


    private void salvarDados() {
        List<Lancamento> lancamentos = lancamentoService.listarLancamentos();
        lancamentoRepository.salvar(lancamentos);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}