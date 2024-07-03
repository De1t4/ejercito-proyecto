/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercito;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase genérica de validación que implementa la interfaz Serializable.
 *
 * @param <T> El tipo de elementos en los arrays que se validan.
 */
public class Validacion<T> implements Serializable {

    /**
     * Valida si un ArrayList está vacío.
     *
     * @param array El ArrayList a validar.
     * @return true si el array está vacío, false en caso contrario.
     */
    public boolean validarArray(ArrayList<T> array) {
        return array.isEmpty();
    }

    /**
     * Valida si una cadena de texto está vacía.
     *
     * @param t La cadena de texto a validar.
     * @return true si la cadena está vacía, false en caso contrario.
     */
    public boolean validarString(String t) {
        return t.equals("");
    }

    /**
     * Valida si un elemento está contenido en un ArrayList de cadenas de texto.
     *
     * @param array El ArrayList de cadenas de texto.
     * @param validar La cadena de texto a buscar en el ArrayList.
     * @return true si el ArrayList contiene la cadena de texto, false en caso
     * contrario.
     */
    public boolean validarContenido(ArrayList<String> array, String validar) {
        return array.contains(validar);
    }


}
