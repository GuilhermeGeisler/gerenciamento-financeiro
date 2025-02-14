package src.main.model.lancamento.receita;

/**
 * Enumeração que representa as categorias de receitas.
 * Cada categoria possui um rótulo descritivo associado.
 */
public enum CategoriaReceita {
    SALARIO("Salário"),
    DECIMO_TERCEIRO("Décimo Terceiro"),
    FERIAS("Férias"),
    OUTRAS_RECEITAS("Outras Receitas");

    /**
     * Rótulo descritivo da categoria de receita.
     */
    private final String label;

    /**
     * Construtor para inicializar a enumeração com o rótulo associado.
     *
     * @param label o rótulo descritivo da categoria de receita.
     */
    CategoriaReceita(String label) {
        this.label = label;
    }

    /**
     * Obtém o rótulo descritivo da categoria de receita.
     *
     * @return o rótulo da categoria.
     */
    public String getLabel() {
        return label;
    }

    /**
     * Retorna o rótulo descritivo da categoria de receita.
     *
     * @return o rótulo da categoria como uma string.
     */
    @Override
    public String toString() {
        return getLabel();
    }
}