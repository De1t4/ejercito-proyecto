/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercito;

import java.util.ArrayList;

/**
 * Clase que representa a un oficial en el sistema del ejército. Hereda de la
 * clase SubOficial.
 */
public class Oficial extends SubOficial {

    public Oficial(String u, String p) {
        super(u, p);
        setUsuario(u);
        setPassword(p);
    }

    @Override
    public void mostrar() {
        EntradaSalida.mostrarString("-----------------------");
        EntradaSalida.mostrarString("Persona - Oficial: " + this.getUsuario());
        EntradaSalida.mostrarString("Password: " + this.getPassword());
        EntradaSalida.mostrarString("-----------------------");
    }

    /**
     * Procede con las acciones permitidas para el oficial en el sistema del
     * ejército. Muestra un menú de opciones y realiza las acciones
     * correspondientes.
     *
     * @param sistemaEjercito Instancia del sistema del ejército.
     * @return true si el procedimiento debe continuar, false si debe detenerse.
     */
    @Override
    public boolean proceder(SistemaEjercito sistemaEjercito) {
        char opc;
        boolean seguir = true;
        do {
            opc = mostrarMenu();
            switch (opc) {
                case '1':
                    crearSoldado(sistemaEjercito);
                    break;
                case '2':
                    crearSubOficial(sistemaEjercito);
                    break;
                case '3':
                    crearServicio(sistemaEjercito);
                    break;
                case '4':
                    crearCompañia(sistemaEjercito);
                    break;
                case '5':
                    crearCuartel(sistemaEjercito);
                    break;
                case '6':
                    crearCuerpo(sistemaEjercito);
                    break;
                case '7':
                    verInfomacion(sistemaEjercito);
                    break;
                case '8':
                    seguir = true;
                    break;
                case '9':
                    seguir = false;
                    break;
                default:
                    EntradaSalida.mostrarString("Opcion incorrecta");
                    opc = '*';
            }
        } while (opc != '8' && opc != '9');
        return seguir;
    }

    /**
     * Crea un nuevo cuerpo de ejercito en el sistema del ejército.
     *
     * @param sistemaEjercito Instancia del sistema del ejército, para ser
     * almacenado en el sistema.
     */
    public void crearCuerpo(SistemaEjercito sistemaEjercito) {
        String codigo = EntradaSalida.leerString("Ingresar codigo del cuerpo");

        String denominacion = EntradaSalida.leerString("Ingresar denominacion del cuerpo");

        ArrayList<Cuerpo> ListaCuerpos = sistemaEjercito.getCuerpos();
        ArrayList<String> ListadoCodigos = new ArrayList<>();
        for (int i = 0; i < ListaCuerpos.size(); i++) {
            ListadoCodigos.add(ListaCuerpos.get(i).getCodigo());
        }

        if (ListadoCodigos.contains(codigo)) {
            EntradaSalida.advertenciaMensaje("El codigo ingresado ya existe");
            return;
        }

        EntradaSalida.destacarMensaje("El cuerpo del ejercito fue creado");

        Cuerpo cuerpo = new Cuerpo(codigo, denominacion);

        sistemaEjercito.getCuerpos().add(cuerpo);
    }

    /**
     * Crea un nuevo suboficial en el sistema del ejército.
     *
     * @param sistemaEjercito Instancia del sistema del ejército, para ser
     * almacenado en el sistema.
     */
    public void crearSubOficial(SistemaEjercito sistemaEjercito) {
        String nombre = EntradaSalida.leerString("Nombre de Sub Oficial");

        String apellido = EntradaSalida.leerString("Apellido de Sub Oficial");

        String usuario = EntradaSalida.leerString("Ingresar Nombre Usuario");

        String password = EntradaSalida.leerString("Ingresar Contraseña");

        Persona p = sistemaEjercito.buscarPersona(usuario + ":" + password);
        if (p != null) {
            EntradaSalida.advertenciaMensaje("El usuario ya existe");
            return;
        }
        EntradaSalida.destacarMensaje("Se creado un nuevo Sub Oficial");

        SubOficial subOficial = new SubOficial(usuario, password);
        subOficial.setApellido(apellido);
        subOficial.setNombre(nombre);

        sistemaEjercito.getPersonas().add(subOficial);
        sistemaEjercito.getSuboficiales().add(subOficial);
    }

    /**
     * Crea una nueva compañía en el sistema del ejército.
     *
     * @param sistemaEjercito Instancia del sistema del ejército, para ser
     * almacenado en el sistema.
     */
    public void crearCompañia(SistemaEjercito sistemaEjercito) {
        String actividad = EntradaSalida.leerString("Ingresar actividad de compañía");

        ArrayList<String> codigosExistentes = new ArrayList<>();
        for (Compania compania : sistemaEjercito.getCompanias()) {
            codigosExistentes.add(compania.getCodigo());
        }

        String codigo = leerCodigoUnico("Ingresar código", codigosExistentes);

        Compania compañia = new Compania(codigo, actividad);

        sistemaEjercito.getCompanias().add(compañia);
    }

    /**
     * Crea un nuevo cuartel en el sistema del ejército.
     *
     * @param sistemaEjercito Instancia del sistema del ejército, para ser
     * almacenado en el sistema.
     */
    public void crearCuartel(SistemaEjercito sistemaEjercito) {
        String nombre = EntradaSalida.leerString("Ingresar nombre del Cuartel");

        String codigo = EntradaSalida.leerString("Ingresar codigo del Cuartel");

        String ubicacion = EntradaSalida.leerString("Ingresar ubicacion del Cuartel");

        ArrayList<Cuartel> ListadoCuarteles = sistemaEjercito.getCuarteles();
        ArrayList<String> ListaCodigos = new ArrayList<>();

        for (int i = 0; i < ListadoCuarteles.size(); i++) {
            ListaCodigos.add(ListadoCuarteles.get(i).getCodigo());
        }

        if (ListaCodigos.contains(codigo)) {
            EntradaSalida.advertenciaMensaje("El codigo ingresada ya está registrado");
            return;
        }

        EntradaSalida.destacarMensaje("El Cuartel fue registrado");

        Cuartel cuartel = new Cuartel(codigo, nombre, ubicacion);

        sistemaEjercito.getCuarteles().add(cuartel);
    }

    /**
     * Lee un código único desde la entrada estándar.
     *
     * @param mensaje Mensaje a mostrar al usuario.
     * @param codigosExistentes Lista de códigos existentes para verificar si
     * existe.
     * @return Código único introducido por el usuario, en caso contrario
     * informar el código ingresado ya existe y devuelve al usuario al menu
     * inicial
     */
    private String leerCodigoUnico(String mensaje, ArrayList<String> codigosExistentes) {
        while (true) {
            String codigo = EntradaSalida.leerString(mensaje);
            if (!codigosExistentes.contains(codigo)) {
                return codigo;
            }
            EntradaSalida.advertenciaMensaje("El código ingresado ya existe. Por favor, ingrese un código único.");
        }
    }

    /**
     * Método que muestra el menú específico para el oficial.
     *
     * @return Opción seleccionada en el menú.
     */
    @Override
    public char mostrarMenu() {
        return EntradaSalida.leerChar("OPCIONES DEL OFICIAL\n"
                + "[1] Dar de alta un Soldado\n"
                + "[2] Dar de alta un SubOficial\n"
                + "[3] Dar de alta un Servicio\n"
                + "[4] Dar de alta una Compania\n"
                + "[5] Dar de alta un Cuartel\n"
                + "[6] Dar de alta un Cuerpo\n"
                + "[7] Mostrar el Contenido del Sistema\n"
                + "[8] Cerrar Sesion\n"
                + "[9] Salir del sistema\n");
    }

    /**
     * Método para ver información específica de las personas como soldados y
     * suboficiales y para ver las diferentes estructuras que forman parte del
     * sistema como cuerteles, compañias y cuerpos.
     * @param sistemaEjercito Instancia del sistema del ejército.
     */
    @Override
    public void verInfomacion(SistemaEjercito sistemaEjercito) {
        EntradaSalida.mostrarString("");
        sistemaEjercito.mostrarInformacionPersonas(sistemaEjercito.getSoldados(), "Soldado");
        sistemaEjercito.mostrarInformacionPersonas(sistemaEjercito.getSuboficiales(), "SubOfical");
        sistemaEjercito.mostrarInformacionEstructura(sistemaEjercito.getCuarteles(), "Cuartel");
        sistemaEjercito.mostrarInformacionEstructura(sistemaEjercito.getCompanias(), "Companias");
        sistemaEjercito.mostrarInformacionEstructura(sistemaEjercito.getCuerpos(), "Cuerpo");
        EntradaSalida.mostrarString("");
    }

}
