package Sesion8_randomaccessfile;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio1_demostracion {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("random.dat", "rw");

        for (int i = 0; i < 10; i++) {
            raf.writeInt(i);
        }

        raf.seek(20);

        int sexto = raf.readInt();
        System.out.println("El entero es: " + sexto);

        raf.seek(20);
        raf.writeInt(255);

        raf.seek(20);

        sexto = raf.readInt();
        System.out.println("El entero es: " + sexto);

        raf.close();
    }
}
