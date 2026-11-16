package Sesion1_File;

import java.io.File;
import java.io.IOException;

public class Ejercicio3_param {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Uso: java Sesion1_File.Ejercicio3_param <nombreFichero>");
            return;
        }

        File fichero = new File(args[0]);

        if (fichero.createNewFile()) {
            System.out.println("Fichero creado: " + fichero.getAbsolutePath());
        } else {
            System.out.println("Ya existia: " + fichero.getAbsolutePath());
        }
    }
}
