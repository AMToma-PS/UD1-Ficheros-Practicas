package Sesion1_File;

import java.io.File;

public class Ejercicio7 {
    public static void main(String[] args) {
        File directorio = new File("datos2");

        System.out.println("Version 1 - usando list()");

        String[] contenido = directorio.list();

        if(contenido == null){
            System.out.println("Directorio vacio");
        }

        for(int i=0; i<contenido.length; i++){
            System.out.println(contenido[i]);
        }

        for (String s: contenido) {
            System.out.println(s);
        }

        System.out.println("Version 2 - usando File()");

        File[] contenido2 = directorio.listFiles();

        for (File f: contenido2) {
            System.out.println(f.isDirectory() ? "[Carpeta] "+f.getName(): "- "+f.getName());
        }
    }
}
