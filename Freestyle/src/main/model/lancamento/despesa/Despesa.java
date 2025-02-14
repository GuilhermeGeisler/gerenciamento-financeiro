package src.main.model.lancamento.despesa;

import src.main.model.lancamento.Lancamento;

/**
 * Representa uma despesa, que é um tipo específico de lançamento financeiro.
 * Cada despesa está associada a uma categoria específica ({@link CategoriaDespesa}) e possui um valor
 * sempre negativo para representar o débito.
 */
public class Despesa extends Lancamento<CategoriaDespesa> {

    /**
     * Define o valor da despesa.
     * Caso o valor informado seja positivo, ele é convertido para negativo
     * para representar corretamente o débito.
     *
     * @param valor o valor da despesa.
     */
    @Override
    public void setValor(double valor) {
        if (valor > 0) valor *= -1;
        super.setValor(valor);
    }
}