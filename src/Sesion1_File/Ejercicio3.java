package Sesion1_File;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre del fichero a crear: ");
        String nombreFichero = sc.nextLine();

        File fichero = new File(nombreFichero);

        if (fichero.createNewFile()) {
            System.out.println("Fichero " + fichero.getName() + " creado");
        } else {
            System.out.println("El fichero " + fichero.getName() + " ya existia");
        }

        sc.close();
        System.out.println("Fin del programa");
    }
}
