package Sesion1_File;

import java.io.File;

public class Ejercicio1 {
    public static void main(String[] args) {
        File f = new File("notas.txt");

        if (f.exists()) {
            System.out.println("Nombre: " + f.getName());
            System.out.println("Tamaño: " + f.length() + " bytes");
            System.out.println("Ruta absoluta: " + f.getAbsolutePath());
            System.out.println("Se puede leer: " + (f.canRead() ? "si" : "no"));
        } else {
            System.out.println("El fichero " + f.getName() + " no existe");
        }
    }
}
