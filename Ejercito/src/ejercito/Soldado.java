/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercito;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase que representa a un soldado. Extiende la clase Persona e implementa
 * Serializable.
 */
public class Soldado extends Persona implements Serializable {

    Validacion v = new Validacion();

    private String codigo;
    private String fechaGraduacion;
    private ArrayList<Servicio> servicios;
    private Compania compañia;
    private Cuartel cuartel;
    private Cuerpo cuerpo;

    public Soldado(String u, String p, String n, String a, String codigo, String fechaGraduacion) {
        setUsuario(u);
        setPassword(p);
        setNombre(n);
        setApellido(a);
        this.codigo = codigo;
        this.fechaGraduacion = fechaGraduacion;
        servicios = new ArrayList<>();
        compañia = new Compania();
        cuartel = new Cuartel();
        cuerpo = new Cuerpo();
    }

    /**
     * Verifica si el código del soldado coincide con el código proporcionado.
     *
     * @param codigoSoldado Código a verificar.
     * @return true si el código coincide, false de lo contrario.
     */
    public boolean coincideCodigo(String codigoSoldado) {
        return codigoSoldado.equals(codigo);
    }

    /**
     * Verifica si el soldado tiene servicios asignados.
     *
     * @return true si no tiene servicios asignados, false de lo contrario.
     */
    public boolean verificarServicios() {
        return v.validarArray(servicios);
    }

    /**
     * Obtiene una lista de códigos de los servicios del soldado.
     *
     * @return Lista de códigos de servicios.
     */
    public ArrayList obtenerListaCodigos() {
        ArrayList<String> listaCodigos = new ArrayList<>();

        for (Servicio s : servicios) {
            listaCodigos.add(s.getCodigo());
        }

        return listaCodigos;
    }

    /**
     * Agrega un servicio a la lista de servicios del soldado.
     *
     * @param servicio Servicio a agregar.
     */
    public void agregarServicio(Servicio servicio) {
        servicios.add(servicio);
    }

    /**
     * Permite al soldado realizar un servicio asignado, marcándolo como
     * finalizado, con la fecha de finalización del servicio
     */
    public void realizarServicio() {
        if (v.validarArray(servicios)) {
            EntradaSalida.mostrarString("No tienes servicios asignados");
            return;
        }

        mostrarServicios();

        String codigoServicio = EntradaSalida.leerString("Ingresar el codigo de un servicio");

        if (!v.validarContenido(obtenerListaCodigos(), codigoServicio)) {
            EntradaSalida.advertenciaMensaje("El código ingresado es incorrecto");
        } else {
            for (Servicio s : servicios) {
                if (s.coincideCodigo(codigoServicio)) {
                    s.setFinalizacion(LocalDate.now());
                    EntradaSalida.mostrarString("La tarea a finalizado");
                    return;
                }
            }
        }

    }

    /**
     * Muestra los servicios asignados al soldado.
     */
    public void mostrarServicios() {
        if (!verificarServicios()) {
            servicios.forEach(Servicio::mostrarInformacion);
        }
    }

    /**
     * Proporciona el menú de opciones para el soldado y maneja las opciones
     * seleccionadas.
     *
     * @param sistemaEjercito El sistema del ejército.
     * @return true si el soldado decide seguir en el sistema, false si decide
     * salir.
     */
    @Override
    public boolean proceder(SistemaEjercito sistemaEjercito) {
        char opc;
        boolean seguir = true;
        do {
            opc = mostrarMenu();
            switch (opc) {
                case '1':
                    EntradaSalida.mostrarString("***MIS DATOS***");
                    mostrar();
                    break;
                case '2':
                    realizarServicio();
                    break;
                case '3':
                    seguir = true;
                    break;
                case '4':
                    seguir = false;
                    break;
                default:
                    EntradaSalida.advertenciaMensaje("ERROR: Opcion incorrecta");
                    System.out.println("");
                    opc = '*';
            }
        } while (opc != '3' && opc != '4');
        return seguir;
    }

    /**
     * Muestra la información del soldado.
     */
    @Override
    public void mostrar() {
        EntradaSalida.mostrarString("-----------------------");
        EntradaSalida.mostrarString("Soldado - Usuario: " + this.getUsuario());
        EntradaSalida.mostrarString("Codigo Soldado: " + codigo + " Graduacion: " + fechaGraduacion);
        EntradaSalida.mostrarString("Password: " + this.getPassword());
        EntradaSalida.mostrarString("Servicios Asignados: " + servicios.size());
        mostrarServicios();
        compañia.mostrarInformacion();
        cuartel.mostrarInformacion();
        cuerpo.mostrarInformacion();
        EntradaSalida.mostrarString("-----------------------");
    }

    /**
     * Informa al usuario que solo puede ver su propia información.
     */
    @Override
    public void verInfomacion(SistemaEjercito sistemaEjercito) {
        EntradaSalida.mostrarString("El usuario solo puede ver su informacion");
    }

    /**
     * Muestra el menú de opciones para el soldado.
     *
     * @return La opción seleccionada por el soldado.
     */
    @Override
    public char mostrarMenu() {
        return EntradaSalida.leerChar("OPCIONES DEL SOLDADO\n"
                + "[1] Ver Mi Informacion\n"
                + "[2] Finalizar mis servicios\n"
                + "[3] Cerrar Sesion\n"
                + "[4] Salir del sistema\n");
    }

    public Cuerpo getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(Cuerpo cuerpo) {
        this.cuerpo = cuerpo;
    }

    public String getFechaGraduacion() {
        return fechaGraduacion;
    }

    public void setFechaGraduacion(String fechaGraduacion) {
        this.fechaGraduacion = fechaGraduacion;
    }

    public Cuartel getCuartel() {
        return cuartel;
    }

    public void setCuartel(Cuartel cuartel) {
        this.cuartel = cuartel;
    }

    public Compania getCompañia() {
        return compañia;
    }

    public void setCompañia(Compania compañia) {
        this.compañia = compañia;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
