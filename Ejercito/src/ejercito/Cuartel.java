/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercito;

import java.io.Serializable;
import java.util.ArrayList;

public class Cuartel implements Serializable, EstructuraMilitar {

    private String codigo;
    private String nombre;
    private String ubicacion;
    private ArrayList<Compania> companias;
    private ArrayList<Soldado> soldados;
    /**
     * Constructor por defecto que inicializa las listas de compañías y soldados.
     */
    public Cuartel() {
        companias = new ArrayList<>();
        soldados = new ArrayList<>();
    }
   /**
     * Constructor que inicializa un cuartel con código, nombre y ubicación específicos.
     * @param codigo Código único del cuartel.
     * @param nombre Nombre del cuartel.
     * @param ubicacion Ubicación del cuartel.
     */
    public Cuartel(String codigo, String nombre, String ubicacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public ArrayList<Compania> getCompanias() {
        return companias;
    }

    public void setCompanias(ArrayList<Compania> companias) {
        this.companias = companias;
    }

    public ArrayList<Soldado> getSoldados() {
        return soldados;
    }

    public void setSoldados(ArrayList<Soldado> soldados) {
        this.soldados = soldados;
    }

    @Override
    public void mostrarInformacion() {
        EntradaSalida.mostrarString("Cuartel: " + nombre);
        EntradaSalida.mostrarString("Ubicacion: " + ubicacion + " - Codigo: " + codigo);
    }

    @Override
    public boolean coincideCodigo(String codigoCuartel) {
        return codigoCuartel.equals(codigo);
    }

}
