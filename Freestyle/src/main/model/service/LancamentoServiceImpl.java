package src.main.model.service;

import src.main.model.lancamento.Lancamento;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Implementação do serviço de lançamentos financeiros.
 * Esta classe fornece as operações para adicionar, listar e consultar saldos de lançamentos financeiros.
 */
public class LancamentoServiceImpl implements LancamentoService {
    private final List<Lancamento> lancamentos;

    /**
     * Construtor que inicializa a lista de lançamentos.
     */
    public LancamentoServiceImpl() {
        this.lancamentos = new ArrayList<>();
    }

    /**
     * Adiciona um novo lançamento financeiro ao sistema.
     *
     * @param lancamento o lançamento a ser adicionado.
     */
    @Override
    public void adicionarLancamento(Lancamento lancamento) {
        lancamentos.add(lancamento);
    }

    /**
     * Lista todos os lançamentos financeiros registrados, ordenados por data.
     *
     * @return uma lista de lançamentos financeiros, ordenados por data.
     */
    @Override
    public List<Lancamento> listarLancamentos() {
        lancamentos.sort(Comparator.comparing(Lancamento::getData));
        return lancamentos;
    }

    /**
     * Consulta o saldo total de receitas e despesas até uma data específica.
     * O saldo é calculado somando todos os valores de lançamentos até a data fornecida.
     *
     * @param data a data até a qual o saldo será calculado.
     * @return o saldo até a data especificada.
     */
    @Override
    public double consultarSaldoAte(Date data) {
        return lancamentos.stream()
                .filter(l -> !l.getData().after(data)) // filtra os lançamentos até a data
                .mapToDouble(Lancamento::getValor)   // mapeia os valores dos lançamentos
                .sum();                              // soma os valores
    }

    /**
     * Consulta o saldo total de receitas e despesas, considerando todos os lançamentos.
     *
     * @return o saldo total de todos os lançamentos.
     */
    @Override
    public double consultarSaldoTotal() {
        return lancamentos.stream()
                .mapToDouble(Lancamento::getValor) // mapeia os valores dos lançamentos
                .sum();                           // soma os valores
    }
}