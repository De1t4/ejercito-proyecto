package ejercito;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase que representa una compañía dentro de la estructura militar. Implementa
 * las interfaces Serializable y EstructuraMilitar.
 */
public class Compania implements Serializable, EstructuraMilitar {

    private String codigo;
    private String actividad;
    private ArrayList<Soldado> soldados;
    private ArrayList<Cuartel> cuarteles;

    /**
     * Constructor por defecto que inicializa las listas de soldados y
     * cuarteles.
     */
    public Compania() {
        soldados = new ArrayList<>();
        cuarteles = new ArrayList<>();
    }

    /**
     * Constructor que inicializa una compañía con código y actividad
     * específicos.
     *
     * @param codigo Código único de la compañía.
     * @param actividad Descripción de la actividad de la compañía.
     */
    public Compania(String codigo, String actividad) {
        this.codigo = codigo;
        this.actividad = actividad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public ArrayList<Soldado> getSoldados() {
        return soldados;
    }

    public void setSoldados(ArrayList<Soldado> soldados) {
        this.soldados = soldados;
    }

    public ArrayList<Cuartel> getCuarteles() {
        return cuarteles;
    }

    public void setCuarteles(ArrayList<Cuartel> cuarteles) {
        this.cuarteles = cuarteles;
    }
   /**
     * Muestra la información básica de la compañía por medio de la salida estándar.
     * Imprime el código y la actividad de la compañía.
     */
    
    @Override
    public void mostrarInformacion() {
        EntradaSalida.mostrarString("Compania codigo: " + codigo);
        EntradaSalida.mostrarString("Actividad: " + actividad);
    }
    
    /**
     * Verifica si el código de la compañía coincide con el código proporcionado.
     * 
     * @param codigoCompañia Código a comparar.
     * @return true si los códigos coinciden, false en caso contrario.
     */
    @Override
    public boolean coincideCodigo(String codigoCompañia) {
        return codigo.equals(codigo);
    }
}
