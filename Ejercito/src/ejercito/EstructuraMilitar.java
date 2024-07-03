/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ejercito;
/**
 * Interfaz que define los métodos básicos para las estructuras militares.
 */
public interface EstructuraMilitar {

    /**
     * Muestra la información básica de la estructura militar.
     */
    public void mostrarInformacion();
    /**
     * Verifica si el código de la estructura militar coincide con el código proporcionado.
     * 
     * @param codigo Código a comparar.
     * @return true si los códigos coinciden, false en caso contrario.
     */
    public boolean coincideCodigo(String codigo);
}
