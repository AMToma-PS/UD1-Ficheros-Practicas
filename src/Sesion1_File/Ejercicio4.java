package Sesion1_File;

import java.io.File;

public class Ejercicio4 {
    public static void main(String[] args) {
        File f = new File("datos2");
        if(f.mkdir())
            System.out.println("Directorio craedo");
        else
            System.out.println("Directorio no creado");

        File f2 = new File("datos2/one/two/three");
        if(f2.mkdirs())
            System.out.println("Directorio creado");
        else
            System.out.println("Directorio no creado");
    }
}
