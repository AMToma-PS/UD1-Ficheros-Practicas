package Sesion6_Binarios;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Ejercicio42_binario {
    public static void main(String[] args) throws IOException {
        try (DataInputStream in = new DataInputStream(new FileInputStream("valores.dat"))) {
            int entero = in.readInt();
            double decimal = in.readDouble();
            boolean logico = in.readBoolean();
            String texto = in.readUTF();

            System.out.println("Entero leido:   " + entero);
            System.out.println("Decimal leido:  " + decimal);
            System.out.println("Booleano leido: " + logico);
            System.out.println("Texto leido:    " + texto);
        }
    }
}
