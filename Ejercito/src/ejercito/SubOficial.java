
package ejercito;

public class SubOficial extends Persona {

    private Validacion v = new Validacion();

    public SubOficial(String u, String p) {
        setUsuario(u);
        setPassword(p);
    }

    /**
     * Muestra la información del SubOficial.
     */
    @Override
    public void mostrar() {
        System.out.println("-----------------------");
        System.out.println("SubOficial - Usuario: " + this.getUsuario());
        System.out.println("Password: " + this.getPassword());
        System.out.println("-----------------------");
    }

    /**
     * Proporciona el menú de opciones para el SubOficial y maneja las opciones
     * seleccionadas.
     *
     * @param sistemaEjercito El sistema del ejército.
     * @return true si el SubOficial decide seguir en el sistema, false si
     * decide salir.
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
                    crearServicio(sistemaEjercito);
                    break;
                case '3':
                    verInfomacion(sistemaEjercito);
                    break;
                case '4':
                    seguir = true;
                    break;
                case '5':
                    seguir = false;
                    break;
                default:
                    EntradaSalida.advertenciaMensaje("ERROR: Opcion incorrecta");
                    EntradaSalida.mostrarString("");
                    opc = '*';
            }
        } while (opc != '4' && opc != '5');

        return seguir;
    }

    /**
     * Crea un nuevo servicio y lo asigna a un soldado.
     *
     * @param sistemaEjercito El sistema del ejército.
     */
    public void crearServicio(SistemaEjercito sistemaEjercito) {
        char opc;
        if (!sistemaEjercito.verificarSoldados()) {
            EntradaSalida.advertenciaMensaje("No existen soldados, crea uno!");
            return;
        }
        String codigo = EntradaSalida.leerString("Ingresar Código del Servicio");
        String descripcion = EntradaSalida.leerString("Ingresar Descripcion del Servicio");

        sistemaEjercito.mostrarInformacionPersonas(sistemaEjercito.getSoldados(), "Soldado");

        do {
            String codigoSoldado = EntradaSalida.leerString("Ingresar codigo del soldado");
            Soldado soldado = sistemaEjercito.buscarSoldado(codigoSoldado);

            if (soldado == null) {
                EntradaSalida.advertenciaMensaje("El soldado ingresado no fue encontrado");
                return;
            }

            if (!soldado.verificarServicios()) {
                if (v.validarContenido(soldado.obtenerListaCodigos(), codigo)) {
                    EntradaSalida.advertenciaMensaje("Ese servicio, ya esta asignado en el soldado");
                    return;
                }
            }

            EntradaSalida.destacarMensaje("El soldado fue encontrado, y se le asigno el servicio");
            Servicio servicio = new Servicio(codigo, descripcion);
            soldado.agregarServicio(servicio);

            opc = EntradaSalida.leerChar("Presione S para continuar, en caso contrario cualquier tecla");
        } while (opc == 's' || opc == 'S' );

    }

    /**
     * Crea un nuevo soldado y lo agrega al sistema.
     *
     * @param sistemaEjercito El sistema del ejército.
     */
    public void crearSoldado(SistemaEjercito sistemaEjercito) {
        if (!sistemaEjercito.verificarEstructuras()) {
            return;
        }

        String nombre = EntradaSalida.leerString("Nombre de Soldado");
        String apellido = EntradaSalida.leerString("Apellido de Soldado");
        String usuario = EntradaSalida.leerString("Ingresar nombre de usuario");
        String password = EntradaSalida.leerString("Ingresar contraseña");
        String graduacion = EntradaSalida.leerString("Ingresar fecha de graduacion (YYYY-MM-DD)");
        String codigo = EntradaSalida.leerString("Ingresar codigo del soldado");

        if (sistemaEjercito.buscarPersona(usuario + ":" + password) != null) {
            EntradaSalida.advertenciaMensaje("El usuario ya está en el sistema");
            return;
        }

        if (sistemaEjercito.buscarSoldado(codigo) != null) {
            EntradaSalida.advertenciaMensaje("El codigo del usuario ya existe");
            return;
        }

        System.out.println("");
        sistemaEjercito.mostrarInformacionEstructura(sistemaEjercito.getCompañias(), "Compania");
        System.out.println("");

        String codigoCompañia = EntradaSalida.leerString("Ingresar el codigo de una compania");

        Compania compañia = sistemaEjercito.buscarCompañia(codigoCompañia);

        if (compañia == null) {
            EntradaSalida.advertenciaMensaje("La compania ingresada no existe");
            return;
        }

        System.out.println("");
        sistemaEjercito.mostrarInformacionEstructura(sistemaEjercito.getCuarteles(), "Cuartel");
        System.out.println("");

        String codigoCuartel = EntradaSalida.leerString("Ingresar el codigo de algun cuartel");

        Cuartel cuartel = sistemaEjercito.buscarCuartel(codigoCuartel);

        if (cuartel == null) {
            EntradaSalida.advertenciaMensaje("El cuartel ingresado no existe");
            return;
        }

        System.out.println("");
        sistemaEjercito.mostrarInformacionEstructura(sistemaEjercito.getCuerpos(), "Cuerpo");
        System.out.println("");

        String codigoCuerpo = EntradaSalida.leerString("Ingresar el codigo de un cuerpo");

        Cuerpo cuerpo = sistemaEjercito.buscarCuerpo(codigoCuerpo);

        if (cuerpo == null) {
            EntradaSalida.advertenciaMensaje("El Cuerpo ingresado no existe");
            return;
        }

        Soldado nuevoSoldado = new Soldado(usuario, password, nombre, apellido, codigo, graduacion);

        nuevoSoldado.setCompañia(compañia);
        nuevoSoldado.setCuartel(cuartel);
        nuevoSoldado.setCuerpo(cuerpo);

        sistemaEjercito.agregarSoldado(nuevoSoldado);
        EntradaSalida.destacarMensaje("Se ha creado un nuevo Soldado");
    }

    /**
     * Muestra la información del sistema, incluyendo soldados, cuarteles,
     * compañías y cuerpos.
     *
     * @param sistemaEjercito El sistema del ejército.
     */
    @Override
    public void verInfomacion(SistemaEjercito sistemaEjercito) {
        EntradaSalida.mostrarString("");
        sistemaEjercito.mostrarInformacionPersonas(sistemaEjercito.getSoldados(), "Soldado");
        sistemaEjercito.mostrarInformacionEstructura(sistemaEjercito.getCuarteles(), "Cuartel");
        sistemaEjercito.mostrarInformacionEstructura(sistemaEjercito.getCompañias(), "Companias");
        sistemaEjercito.mostrarInformacionEstructura(sistemaEjercito.getCuerpos(), "Cuerpo");
        EntradaSalida.mostrarString("");
    }

    /**
     * Muestra el menú de opciones para el SubOficial.
     *
     * @return La opción seleccionada por el SubOficial.
     */
    @Override
    public char mostrarMenu() {
        return EntradaSalida.leerChar("OPCIONES DEL SUBOFICIAL\n"
                + "[1] Dar de alta un soldado\n"
                + "[2] Dar de alta un servicio\n"
                + "[3] Mostrar el contenido del sistema\n"
                + "[4] Cerrar Sesion\n"
                + "[5] Salir del sistema\n");
    }

}
