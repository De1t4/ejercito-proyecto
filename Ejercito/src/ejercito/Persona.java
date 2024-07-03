/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ejercito;

import java.io.Serializable;

/**
 * Clase abstracta que representa una persona en el sistema del ejército.
 */
public abstract class Persona implements Serializable {

    private String usuario;
    private String password;
    private String nombre;
    private String apellido;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Método abstracto que define el procedimiento que la persona debe seguir
     * en el sistema del ejército.
     *
     * @param sistemaEjercito Instancia del sistema del ejército.
     * @return true si el procedimiento se completó correctamente, false en caso
     * contrario.
     */
    public abstract boolean proceder(SistemaEjercito sistemaEjercito);

    /**
     * Método abstracto para mostrar información de la persona.
     */
    public abstract void mostrar();

    /**
     * Método abstracto para ver información específica de la persona en el
     * sistema del ejército.
     * @param sistemaEjercito Instancia del sistema del ejército.
     */
    public abstract void verInfomacion(SistemaEjercito sistemaEjercito);

    /**
     * Método abstracto que muestra el menú específico para la persona.
     * @return Opción seleccionada en el menú.
     */
    public abstract char mostrarMenu();
    
   /**
     * Verifica si los datos del usuario proporcionados coinciden con los datos almacenados.
     * @param datos Datos a comparar en formato "usuario:password".
     * @return true si los datos coinciden, false en caso contrario.
     */
    public boolean buscarUsuario(String datos) {
        return datos.equals(usuario + ":" + password);
    }

}
