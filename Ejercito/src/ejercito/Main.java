package ejercito;

/**
 * Clase principal que contiene el método de inicio del programa.
 */
public class Main {

    public static void main(String[] args) {
        /**
         * Método principal que inicia la ejecución del programa. Crea una
         * instancia de Control y llama al método ejecutar().
         */
        Control c = new Control();
        try {
            c.ejecutar();
        } catch (NullPointerException e) {
            EntradaSalida.mostrarString(e.getMessage());
        }

    }
}
