package Sesion1_File;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un nombre de archivo: ");
        String nombreArchivo = sc.nextLine();

        File ficheroUsuario = new File(nombreArchivo);

        if(ficheroUsuario.exists())
            System.out.println("El fichero ya existia");
        else
            ficheroUsuario.createNewFile();

        if(ficheroUsuario.createNewFile()){
            System.out.println("Fichero creado");
        }else{
            System.out.println("Ya existia");
        }

        System.out.println("Fin del programa");
    }
}
