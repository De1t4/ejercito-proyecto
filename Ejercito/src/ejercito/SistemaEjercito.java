/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercito;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase que representa el sistema del ejército. Implementa la interfaz
 * Serializable.
 */
public class SistemaEjercito implements Serializable {

    Validacion v = new Validacion();

    private ArrayList<Compania> companias;
    private ArrayList<Cuartel> cuarteles;
    private ArrayList<Cuerpo> cuerpos;
    private ArrayList<Persona> personas;
    private ArrayList<SubOficial> suboficiales;
    private ArrayList<Soldado> soldados;

    /**
     * Constructor que inicializa las listas de estructuras y personas del
     * ejército.
     */
    public SistemaEjercito() {
        companias = new ArrayList<>();
        cuarteles = new ArrayList<>();
        cuerpos = new ArrayList<>();
        personas = new ArrayList<>();
        soldados = new ArrayList<>();
        suboficiales = new ArrayList<>();
    }

    /**
     * Valida si hay soldados en el sistema.
     *
     * @return true si hay soldados, false de lo contrario.
     */
    public boolean validarSoldados() {
        if (v.validarArray(soldados)) {
            EntradaSalida.advertenciaMensaje("No existen soldados, crea uno!");
            return false;
        }
        return true;
    }

    /**
     * Valida si hay estructuras militares (compañías, cuarteles, cuerpos) en el
     * sistema.
     *
     * @return true si hay estructuras, false de lo contrario.
     */
    public boolean validarEstructura() {
        if (v.validarArray(companias)) {
            EntradaSalida.advertenciaMensaje("No hay companias, crea una!!");
            return false;
        }

        if (v.validarArray(cuarteles)) {
            EntradaSalida.advertenciaMensaje("No hay Cuarteles, crea uno");
            return false;
        }

        if (v.validarArray(cuerpos)) {
            EntradaSalida.advertenciaMensaje("No hay Cuerpos del ejercito, crea uno ");
            return false;
        }
        return true;
    }
   /**
     * Agrega un nuevo soldado al sistema.
     * 
     * @param nuevoSoldado El nuevo soldado a agregar.
     */
    public void agregarSoldado(Soldado nuevoSoldado) {
        soldados.add(nuevoSoldado);
        personas.add(nuevoSoldado);
    }


    /**
     * Muestra información de una lista de personas.
     * método comodín para la visualización de información de las clases que heredan la clase persona
     * @param personas Lista de personas a mostrar.
     * @param nombreObjeto Nombre del tipo de personas a mostrar.
     */
    public void mostrarInformacionPersonas(ArrayList<? extends Persona> personas, String nombreObjeto) {
        if (v.validarArray(personas)) {
            EntradaSalida.mostrarString("No hay " + nombreObjeto + " registrados");
        } else {
            EntradaSalida.mostrarString("=============================================");
            EntradaSalida.mostrarString(nombreObjeto);
            for (Persona p : personas) {
                p.mostrar();
            }
            EntradaSalida.mostrarString("=============================================");
        }
    }
    /**
     * Muestra información de una lista de estructuras militares.
     *  método comodín para la visualización de información de las clases que heredan la clase EstructuraMilitar
     * @param estructuras Lista de estructuras militares a mostrar.
     * @param nombreObjeto Nombre del tipo de estructuras a mostrar.
     */
    public void mostrarInformacionEstructura(ArrayList<? extends EstructuraMilitar> estructuras, String nombreObjeto) {
        if (v.validarArray(estructuras)) {
            EntradaSalida.mostrarString("No hay " + nombreObjeto + " registrados");
        } else {
            EntradaSalida.mostrarString("=============================================");
            EntradaSalida.mostrarString(nombreObjeto);
            for (EstructuraMilitar e : estructuras) {
                e.mostrarInformacion();
            }
            EntradaSalida.mostrarString("=============================================");
        }
    }
    /**
     * Busca una compañía por su código.
     * 
     * @param codigoCompañia Código de la compañía a buscar.
     * @return La compañía encontrada, o null si no se encuentra.
     */
    public Compania buscarCompañia(String codigoCompañia) {
        for (Compania compañia : companias) {
            if (compañia.coincideCodigo(codigoCompañia)) {
                return compañia;
            }
        }
        return null;
    }
    /**
     * Busca una cuartel por su código.
     * 
     * @param codigoCuartel Código de la compañía a buscar.
     * @return cuartel .El cuartel encontrada, o null si no se encuentra.
     */
    public Cuartel buscarCuartel(String codigoCuartel) {
        for (Cuartel cuartel : cuarteles) {
            if (cuartel.coincideCodigo(codigoCuartel)) {
                return cuartel;
            }
        }
        return null;
    }
    /**
     * Busca un cuerpo por su código.
     * 
     * @param codigoCuerpo Código del cuerpo a buscar.
     * @return El cuerpo encontrado, o null si no se encuentra.
     */
    public Cuerpo buscarCuerpo(String codigoCuerpo) {
        for (Cuerpo c : cuerpos) {
            if (c.coincideCodigo(codigoCuerpo)) {
                return c;
            }
        }
        return null;
    }
    /**
     * Busca un soldado por su código.
     * 
     * @param codigoSoldado Código del soldado a buscar.
     * @return El soldado encontrado, o null si no se encuentra.
     */
    public Soldado buscarSoldado(String codigoSoldado) {
        for (Soldado s : soldados) {
            if (s.coincideCodigo(codigoSoldado)) {
                return s;
            }
        }
        return null;
    }
    /**
     * Busca una persona por su nombre de usuario y contraseña.
     * 
     * @param datos Datos de la persona en formato "usuario:password".
     * @return La persona encontrada, o null si no se encuentra.
     */
    public Persona buscarPersona(String datos) {
        for (Persona p : personas) {
            if (p.buscarUsuario(datos)) {//ojo con los getters, implementar patron de diseño tell don't ask
                return p;
            }
        }
        return null;
    }

    public ArrayList<Soldado> getSoldados() {
        return soldados;
    }

    public void setSoldados(ArrayList<Soldado> soldados) {
        this.soldados = soldados;
    }

    public ArrayList<Compania> getCompanias() {
        return companias;
    }

    public void setCompanias(ArrayList<Compania> companias) {
        this.companias = companias;
    }

    public ArrayList<Cuartel> getCuarteles() {
        return cuarteles;
    }

    public void setCuarteles(ArrayList<Cuartel> cuarteles) {
        this.cuarteles = cuarteles;
    }

    public ArrayList<Cuerpo> getCuerpos() {
        return cuerpos;
    }

    public void setCuerpos(ArrayList<Cuerpo> cuerpos) {
        this.cuerpos = cuerpos;
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    public ArrayList<SubOficial> getSuboficiales() {
        return suboficiales;
    }

    public void setSuboficiales(ArrayList<SubOficial> suboficiales) {
        this.suboficiales = suboficiales;
    }

}
