/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercito;

import java.util.Scanner;

/**
 * Clase que proporciona métodos de entrada y salida para interactuar con el
 * usuario.
 */
public class EntradaSalida {

    private static Scanner sc = new Scanner(System.in);
    private static Validacion v = new Validacion();

    /**
     * Lee un carácter desde la entrada estándar después de mostrar un mensaje.
     *
     * @param texto Mensaje a mostrar al usuario.
     * @return Primer carácter de la entrada del usuario, o '0' si la entrada
     * está vacía.
     */
    public static char leerChar(String texto) {
        System.out.println(texto);
        String st = sc.nextLine().trim();
        return st.isEmpty() ? '0' : st.charAt(0);
    }

    /**
     * Lee una cadena de texto desde la entrada estándar después de mostrar un
     * mensaje. Realiza una validación y solicita al usuario que vuelva a
     * introducir la cadena si no es válida.
     *
     * @param texto Mensaje a mostrar al usuario.
     * @return Cadena de texto válida introducida por el usuario.
     */
    public static String leerString(String texto) {
        String st = "";

        do {
            System.out.println(texto);
            st = sc.nextLine();
        } while (v.validarString(st));
        return st;
    }

    /**
     * Muestra una cadena de texto en la salida estándar.
     *
     * @param texto Cadena de texto a mostrar.
     */
    public static void mostrarString(String texto) {
        System.out.println(texto);
    }

    /**
     * Muestra un mensaje destacado en la salida estándar.
     *
     * @param texto Mensaje a destacar.
     */
    public static void destacarMensaje(String texto) {
        System.out.println("======================");
        EntradaSalida.mostrarString("***" + texto + "***");
        System.out.println("======================");
    }

    /**
     * Muestra un mensaje de advertencia en la salida estándar.
     *
     * @param texto Mensaje de advertencia.
     */
    public static void advertenciaMensaje(String texto) {
        System.out.println(" ");
        System.err.println(texto);
        System.out.println(" ");

    }
}
