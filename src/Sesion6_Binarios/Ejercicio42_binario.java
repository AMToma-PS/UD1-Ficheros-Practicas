package Sesion6_Binarios;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ejercicio42_binario {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new FileInputStream("datos.dat"));

        float numero = in.readFloat();

        System.out.println("El numero leido es: "+numero);

        in.close();
    }
}
