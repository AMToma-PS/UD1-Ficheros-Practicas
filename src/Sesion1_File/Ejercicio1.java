package Sesion1_File;

import java.io.File;

public class Ejercicio1 {
    public static void main(String[] args) {
        File f = new File("datos1.txt");

        if(f.exists()){
            System.out.println("Nombre: "+f.getName());
            System.out.println("Tamaño: "+f.length());
            System.out.println("Ruta absoluta: "+f.getAbsolutePath());
        } else {
            System.out.println("El archivo seleccionado no existe");
        }
    }
}
