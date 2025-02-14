package src.main.model.service;

import src.main.model.lancamento.Lancamento;

import java.util.Date;
import java.util.List;

/**
 * Interface que define os serviços relacionados aos lançamentos financeiros.
 * Inclui operações para adicionar, listar e consultar saldos de lançamentos.
 */
public interface LancamentoService {

    /**
     * Adiciona um lançamento financeiro ao sistema.
     *
     * @param lancamento o lançamento a ser adicionado.
     */
    void adicionarLancamento(Lancamento lancamento);

    /**
     * Lista todos os lançamentos financeiros registrados no sistema.
     *
     * @return uma lista de lançamentos financeiros.
     */
    List<Lancamento> listarLancamentos();

    /**
     * Consulta o saldo total até uma data específica, considerando receitas e despesas.
     *
     * @param data a data até a qual o saldo será calculado.
     * @return o saldo até a data especificada.
     */
    double consultarSaldoAte(Date data);

    /**
     * Consulta o saldo total, considerando todas as receitas e despesas.
     *
     * @return o saldo total.
     */
    double consultarSaldoTotal();
}