package Sesion6_Binarios;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio41_binario {
    public static void main(String[] args) throws IOException {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("valores.dat"))) {
            out.writeInt(42);
            out.writeDouble(36.6);
            out.writeBoolean(true);
            out.writeUTF("termometro");
        }
        System.out.println("Datos escritos en valores.dat");
    }
}
