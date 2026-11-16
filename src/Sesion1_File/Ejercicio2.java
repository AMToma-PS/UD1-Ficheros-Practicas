package Sesion1_File;

import java.io.File;
public class Ejercicio2 {
    public static void main(String[] args) {
        File f = new File("datos");

        if(f.isDirectory()){
            System.out.println("Tamaño: "+f.length());
        } else {
            System.out.println("Lo que has seleccionado no es un directorio");
        }
    }
}
