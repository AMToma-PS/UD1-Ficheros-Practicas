package Sesion1_File;

import java.io.File;

public class Ejercicio8 {
    public static void main(String[] args) {
        File carpeta = new File("datos2");

        listarContenido(carpeta);
    }

    public static void listarContenido(File carpetaActual){
        File[] contenido = carpetaActual.listFiles();

        if(contenido == null || contenido.length == 0) {
            System.out.println("No es un directorio o esta vacio");
        } else {
            for (File f : contenido) {
                System.out.println(f.getPath());

                if(f.isDirectory())
                    listarContenido(f);
            }
        }
    }
}
