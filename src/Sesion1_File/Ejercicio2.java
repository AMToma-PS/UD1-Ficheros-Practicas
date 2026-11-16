package Sesion1_File;

import java.io.File;

public class Ejercicio2 {
    public static void main(String[] args) {
        File carpeta = new File("documentos");

        if (carpeta.isDirectory()) {
            System.out.println("Carpeta: " + carpeta.getName());
            System.out.println("Ruta absoluta: " + carpeta.getAbsolutePath());
            System.out.println("length(): " + carpeta.length());
        } else {
            System.out.println("La ruta indicada no es un directorio");
        }
    }
}
