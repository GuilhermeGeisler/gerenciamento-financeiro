package src.main.model.repository;

import src.main.model.lancamento.Lancamento;

import java.util.List;

/**
 * Interface que define as operações de repositório para gerenciar lançamentos financeiros.
 * Permite salvar e carregar uma lista de lançamentos.
 */
public interface LancamentoRepository {

    /**
     * Salva uma lista de lançamentos no repositório.
     *
     * @param lancamentos a lista de lançamentos a ser salva.
     */
    void salvar(List<Lancamento> lancamentos);

    /**
     * Carrega todos os lançamentos armazenados no repositório.
     *
     * @return uma lista de lançamentos carregados.
     */
    List<Lancamento> carregar();
}