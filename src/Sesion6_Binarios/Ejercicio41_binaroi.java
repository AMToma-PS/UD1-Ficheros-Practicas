package Sesion6_Binarios;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio41_binaroi {
    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(
                new FileOutputStream("datos.dat"));

        out.writeInt(7);

        out.close();
    }
}
