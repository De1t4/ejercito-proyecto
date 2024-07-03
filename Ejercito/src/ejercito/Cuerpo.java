/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercito;

import java.io.Serializable;
import java.util.ArrayList;

public class Cuerpo implements Serializable, EstructuraMilitar {

    private String codigo;
    private String denominacion;
    private ArrayList<Soldado> soldados;

    /**
     * Constructor que inicializa un cuerpo con código y denominacion
     * específicos.
     * @param codigo Código único del cuartel.
     * @param denominacion Denominacion del cuartel.
     */
    public Cuerpo(String codigo, String denominacion) {
        this.codigo = codigo;
        this.denominacion = denominacion;
    }

    /**
     * Constructor por defecto que inicializa las listas de soldados.
     */
    public Cuerpo() {
        soldados = new ArrayList<>();
    }

    public ArrayList<Soldado> getSoldados() {
        return soldados;
    }

    public void setSoldados(ArrayList<Soldado> soldados) {
        this.soldados = soldados;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    @Override
    public void mostrarInformacion() {
        EntradaSalida.mostrarString("Codigo: " + codigo + " Denominacion: " + denominacion);
    }

    @Override
    public boolean coincideCodigo(String codigoCuerpo) {
        return codigoCuerpo.equals(codigo);
    }
}
