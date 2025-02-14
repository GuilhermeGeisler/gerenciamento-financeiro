package src.main.model.lancamento.despesa;

/**
 * Enumeração que representa as categorias de despesas.
 * Cada categoria possui um rótulo descritivo associado.
 */
public enum CategoriaDespesa {
    ALIMENTACAO("Alimentação"),
    TRANSPORTE("Transporte"),
    RESIDENCIA("Residência"),
    SAUDE("Saúde"),
    EDUCACAO("Educação"),
    ENTRETERIMENTO("Entretenimento"),
    OUTRAS_RECEITAS("Outras Receitas");

    /**
     * Rótulo descritivo da categoria de despesa.
     */
    private final String label;

    /**
     * Construtor para inicializar a enumeração com o rótulo associado.
     *
     * @param label o rótulo descritivo da categoria de despesa.
     */
    CategoriaDespesa(String label) {
        this.label = label;
    }

    /**
     * Obtém o rótulo descritivo da categoria de despesa.
     *
     * @return o rótulo da categoria.
     */
    public String getLabel() {
        return label;
    }

    /**
     * Retorna o rótulo descritivo da categoria de despesa.
     *
     * @return o rótulo da categoria como uma string.
     */
    @Override
    public String toString() {
        return getLabel();
    }
}