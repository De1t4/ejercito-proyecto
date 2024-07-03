/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercito;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase que representa los servicios de los soldados en el sistema del
 * ejército. Implementa la interfaz Serializable.
 */
public class Servicio implements Serializable, EstructuraMilitar {

    private String codigo;
    private String descripcion;
    private ArrayList<Soldado> soldados;
    private LocalDate finalizacion;

    public Servicio(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    /**
     * Muestra la información del servicio en la salida estándar.
     */
    @Override
    public void mostrarInformacion() {
        String finalizacionStr = finalizacion != null ? " Finalizado: " + finalizacion : "";
        System.out.println(codigo + " - " + descripcion + finalizacionStr);
    }

    /**
     * Verifica si el código del servicio coincide con el código
     * proporcionado.
     * @param codigoServicio Código a comparar.
     * @return true si los códigos coinciden, false en caso contrario.
     */
    @Override
    public boolean coincideCodigo(String codigoServicio) {
        return codigoServicio.equals(codigo);
    }

    public String getCodigo() {
        return codigo;
    }

    public ArrayList<Soldado> getSoldados() {
        return soldados;
    }

    public void setSoldados(ArrayList<Soldado> soldados) {
        this.soldados = soldados;
    }

    public LocalDate getFinalizacion() {
        return finalizacion;
    }

    public void setFinalizacion(LocalDate finalizacion) {
        this.finalizacion = finalizacion;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
