package Sesion8_randomaccessfile;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio1_demostracion {
    public static void main(String[] args) throws IOException {
        final int TAM_INT = 4;

        try (RandomAccessFile raf = new RandomAccessFile("numeros.dat", "rw")) {
            raf.setLength(0);

            for (int i = 0; i < 10; i++) {
                raf.writeInt(i * 10);
            }

            int posicion = 3;

            raf.seek((long) posicion * TAM_INT);
            System.out.println("Valor en la posicion " + posicion + ": " + raf.readInt());

            raf.seek((long) posicion * TAM_INT);
            raf.writeInt(999);

            raf.seek((long) posicion * TAM_INT);
            System.out.println("Valor en la posicion " + posicion + " tras sobrescribir: " + raf.readInt());

            System.out.println("Contenido completo:");
            raf.seek(0);
            while (raf.getFilePointer() < raf.length()) {
                System.out.print(raf.readInt() + " ");
            }
            System.out.println();
            System.out.println("Tamaño del fichero: " + raf.length() + " bytes");
        }
    }
}
