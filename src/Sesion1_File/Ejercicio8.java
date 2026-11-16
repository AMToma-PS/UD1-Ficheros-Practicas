package Sesion1_File;

import java.io.File;

public class Ejercicio8 {
    public static void main(String[] args) {
        File carpeta = new File("copias");

        if (!carpeta.isDirectory()) {
            System.out.println(carpeta.getName() + " no es un directorio");
            return;
        }

        listarContenido(carpeta, 0);
    }

    public static void listarContenido(File carpetaActual, int nivel) {
        File[] contenido = carpetaActual.listFiles();

        if (contenido == null || contenido.length == 0) {
            System.out.println("  ".repeat(nivel) + "(vacia)");
            return;
        }

        for (File f : contenido) {
            System.out.println("  ".repeat(nivel) + f.getPath());
            if (f.isDirectory())
                listarContenido(f, nivel + 1);
        }
    }
}
