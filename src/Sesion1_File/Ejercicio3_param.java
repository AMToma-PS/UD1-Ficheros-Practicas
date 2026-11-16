package Sesion1_File;

import java.io.File;
import java.io.IOException;

public class Ejercicio3_param {
    public static void main(String[] args) throws IOException {
        File ficheroUsuario = new File(args[0]);

        if(ficheroUsuario.createNewFile()){
            System.out.println("Fichero creado");
        }else{
            System.out.println("Ya existia");
        }
    }
}
