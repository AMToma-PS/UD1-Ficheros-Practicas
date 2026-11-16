package Sesion1_File;

import java.io.File;

public class Ejercicio7 {
    public static void main(String[] args) {
        File directorio = new File("copias");

        if (!directorio.isDirectory()) {
            System.out.println(directorio.getName() + " no es un directorio");
            return;
        }

        System.out.println("Version 1 - list()");
        String[] nombres = directorio.list();

        if (nombres == null || nombres.length == 0) {
            System.out.println("Directorio vacio");
        } else {
            for (String nombre : nombres) {
                System.out.println(nombre);
            }
        }

        System.out.println("Version 2 - listFiles()");
        File[] elementos = directorio.listFiles();

        if (elementos == null || elementos.length == 0) {
            System.out.println("Directorio vacio");
        } else {
            for (File f : elementos) {
                System.out.println(f.isDirectory() ? "[DIR]  " + f.getName() : "[FILE] " + f.getName());
            }
        }
    }
}
