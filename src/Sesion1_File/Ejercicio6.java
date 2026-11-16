package Sesion1_File;

import java.io.File;

public class Ejercicio6 {
    public static void main(String[] args) {
        File d = new File("documentos");

        if (!d.exists()) {
            System.out.println("La carpeta " + d.getName() + " no existe");
        } else if (!d.isDirectory()) {
            System.out.println(d.getName() + " no es un directorio");
        } else if (d.delete()) {
            System.out.println("Carpeta " + d.getName() + " borrada");
        } else {
            System.out.println("No se pudo borrar " + d.getName() + ": no esta vacia");
        }
    }
}
