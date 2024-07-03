/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercito;

import java.io.IOException;
/**
 * Clase que gestiona el control y la ejecución del sistema del ejército.
 */
public class Control {

   /**
     * Método principal que ejecuta el sistema del ejército.
     * Inicializa el sistema, carga datos desde un archivo si existe, o solicita
     * datos de inicio de sesión si no encuentra el archivo.
     * Guarda los cambios en el archivo "ejercito.txt" al finalizar cada sesión.
     */
    public  void ejecutar() {
        SistemaEjercito sistemaEjercito = new SistemaEjercito();
        GestorArchivos gestorArchivos = new GestorArchivos();
        
        boolean seguir = true;

        try {
            sistemaEjercito = (SistemaEjercito) gestorArchivos.leerArchivo("ejercito.txt");

        } catch (Exception e) {
            String usuario = EntradaSalida.leerString("Arranque inicial del sistema. Sr. Oficial, ingrese su nombre de usuario:");
            String password = EntradaSalida.leerString("Ingrese su password:");

            sistemaEjercito.getPersonas().add(new Oficial(usuario, password));

            try {
                gestorArchivos.guardarArchivo(sistemaEjercito, "ejercito.txt");
                EntradaSalida.mostrarString("El arranque ha sido exitoso. Ahora se debe reiniciar el sistema...");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            seguir = false;
        }

        while (seguir) {

            String usuario = EntradaSalida.leerString("Ingrese el usuario:");
            String password = EntradaSalida.leerString("Ingrese la password:");

            Persona p = sistemaEjercito.buscarPersona(usuario + ":" + password);
            if (p == null) {
                EntradaSalida.advertenciaMensaje("ERROR: La combinacion usuario/password ingresada no es valida.");
            } else {
                seguir = p.proceder(sistemaEjercito);
                if (!seguir) {
                    try {
                        gestorArchivos.guardarArchivo(sistemaEjercito,"ejercito.txt"); // Método para guardar el estado en un archivo
                    } catch (IOException ex) {
                        EntradaSalida.advertenciaMensaje("Error al guardar en el archivo ejercito.txt.");
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}
