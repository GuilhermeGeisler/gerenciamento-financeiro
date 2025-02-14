package src.main.model.lancamento;

import src.main.model.lancamento.despesa.CategoriaDespesa;
import src.main.model.lancamento.receita.CategoriaReceita;

import java.util.Date;

/**
 * Classe abstrata que representa um lançamento financeiro.
 * Um lançamento possui uma data, um valor e está associado a uma categoria.
 * As subclasses devem implementar a associação a categorias específicas.
 */
public abstract class Lancamento<E extends Enum<E>> {
    // Data do lançamento
    private Date data;

    // Valor do lançamento
    private double valor;

    // Categoria da despesa
    private E categoria;

    /**
     * Define a categoria da despesa.
     *
     * @param categoria a categoria da despesa.
     */
    public void setCategoria(E categoria) {
        this.categoria = categoria;
    }

    /**
     * Define a data do lançamento.
     *
     * @param data a data do lançamento.
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * Define o valor do lançamento.
     *
     * @param valor o valor do lançamento.
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * Obtém a data do lançamento.
     *
     * @return a data do lançamento.
     */
    public Date getData() {
        return data;
    }

    /**
     * Obtém o valor do lançamento.
     *
     * @return o valor do lançamento.
     */
    public double getValor() {
        return valor;
    }

    /**
     * Obtém a categoria associada ao lançamento.
     * A categoria específica é definida na implementação através de generics.
     *
     * @return a categoria do lançamento como uma enumeração.
     */
    public E getCategoria() {
        return categoria;
    }
}