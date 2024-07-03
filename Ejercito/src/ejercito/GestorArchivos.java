/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercito;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class GestorArchivos<T> implements Serializable {

    // Método para leer un objeto de un archivo
    public T leerArchivo(String a) throws IOException, ClassNotFoundException {
        try ( FileInputStream f = new FileInputStream(a);  
            ObjectInputStream o = new ObjectInputStream(f)) {
            return (T) o.readObject();
        }
    }

    // Método para guardar un objeto en un archivo
    public void guardarArchivo(T objeto, String a) throws IOException {
        try ( FileOutputStream f = new FileOutputStream(a);  
            ObjectOutputStream o = new ObjectOutputStream(f)) {
            o.writeObject(objeto);
        }
    }
}
