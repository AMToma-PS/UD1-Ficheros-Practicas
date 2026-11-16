package Sesion1_File;

import java.io.File;

public class Ejercicio6 {
    public static void main(String[] args) {
        File d = new File("datos");

        if (!d.exists())      {
            System.out.println("No existe");
            return;
        }
        if (!d.isDirectory()) {
            System.out.println("No es un directorio");
            return;
        }

        if (d.delete()) {
            System.out.println("Directorio borrado");
        } else {
            System.out.println("No se pudo borrar (¿está vacío?)");
        }
    }
}
