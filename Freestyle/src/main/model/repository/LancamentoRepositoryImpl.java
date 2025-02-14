package src.main.model.repository;

import src.main.model.lancamento.Lancamento;
import src.main.model.lancamento.despesa.CategoriaDespesa;
import src.main.model.lancamento.despesa.Despesa;
import src.main.model.lancamento.receita.CategoriaReceita;
import src.main.model.lancamento.receita.Receita;

import java.io.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementação da interface {@link LancamentoRepository} para persistência de lançamentos financeiros.
 * Esta classe realiza a leitura e escrita de lançamentos em um arquivo CSV.
 */
public class LancamentoRepositoryImpl implements LancamentoRepository {

    // Caminho do arquivo onde os lançamentos são armazenados
    private static final String FILE_PATH = "lancamentos.csv";

    /**
     * Salva uma lista de lançamentos no arquivo CSV.
     * Cada lançamento é gravado com sua data, valor, tipo (Receita ou Despesa) e categoria.
     *
     * @param lancamentos a lista de lançamentos a ser salva no arquivo.
     */
    @Override
    public void salvar(List<Lancamento> lancamentos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Lancamento lancamento : lancamentos) {
                String tipo = (lancamento instanceof Receita) ? "Receita" : "Despesa";
                String categoria = (lancamento instanceof Receita)
                        ? ((Receita) lancamento).getCategoria().name()
                        : ((Despesa) lancamento).getCategoria().name();

                writer.write(String.format("%s,%s,%s,%s%n",
                        lancamento.getData().getTime(),
                        lancamento.getValor(),
                        tipo,
                        categoria
                ));
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    /**
     * Carrega os lançamentos financeiros armazenados no arquivo CSV.
     * Para cada linha do arquivo, um lançamento do tipo correspondente (Receita ou Despesa)
     * é criado e adicionado à lista retornada.
     *
     * @return uma lista de lançamentos carregados do arquivo.
     */
    @Override
    public List<Lancamento> carregar() {
        List<Lancamento> lancamentos = new ArrayList<>();
        try {
            File arquivo = new File(FILE_PATH);

            // Cria o arquivo se ele não existir
            if (!arquivo.exists()) arquivo.createNewFile();

            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");

                // Extrai os campos
                Date data = new Date(Long.parseLong(partes[0].trim()));
                double valor = Double.parseDouble(partes[1].trim());
                String tipo = partes[2].trim(); // Receita ou Despesa
                String categoriaStr = partes[3].trim();

                // Cria o lançamento conforme o tipo
                if ("Receita".equalsIgnoreCase(tipo)) {
                    Receita receita = new Receita();
                    receita.setData(data);
                    receita.setValor(valor);
                    receita.setCategoria(CategoriaReceita.valueOf(categoriaStr));
                    lancamentos.add(receita);
                } else if ("Despesa".equalsIgnoreCase(tipo)) {
                    Despesa despesa = new Despesa();
                    despesa.setData(data);
                    despesa.setValor(valor);
                    despesa.setCategoria(CategoriaDespesa.valueOf(categoriaStr));
                    lancamentos.add(despesa);
                }
            }
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Erro ao carregar dados: " + e.getMessage());
        }
        return lancamentos;
    }
}