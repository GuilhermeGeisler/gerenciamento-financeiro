package src.main.model.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utilitário para manipulação de datas.
 * Esta classe fornece métodos para converter strings em objetos {@link Date} e vice-versa, utilizando um formato padrão de data.
 */
public class DateUtils {

    // Formato padrão para data
    private static final String DATE_FORMAT = "dd/MM/yyyy";

    /**
     * Converte uma string representando uma data para um objeto {@link Date}.
     * O formato esperado da data é "dd/MM/yyyy".
     *
     * @param dateString a string representando a data a ser convertida.
     * @return o objeto {@link Date} correspondente à string fornecida.
     * @throws IllegalArgumentException se a string fornecida não puder ser convertida para uma data válida.
     */
    public Date stringToDate(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        formatter.setLenient(false); // Impede o parse de datas inválidas
        try {
            return formatter.parse(dateString);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Data inválida: " + dateString, e);
        }
    }

    /**
     * Converte um objeto {@link Date} para uma string, utilizando o formato "dd/MM/yyyy".
     *
     * @param date o objeto {@link Date} a ser convertido para string.
     * @return a string representando a data no formato "dd/MM/yyyy".
     * @throws IllegalArgumentException se o objeto {@link Date} fornecido for nulo.
     */
    public String dateToString(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("A data não pode ser nula.");
        }
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        return formatter.format(date);
    }
}