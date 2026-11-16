package Sesion6_Binarios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio43_copiarIMG {

    public static void main(String[] args) throws IOException {
        long inicio = System.nanoTime();
        long bytesCopiados = 0;

        try (FileInputStream in = new FileInputStream("paisaje.jpg");
             FileOutputStream out = new FileOutputStream("paisaje_copia.jpg")) {
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
                bytesCopiados++;
            }
        }

        long milisegundos = (System.nanoTime() - inicio) / 1_000_000;
        System.out.println("Bytes copiados: " + bytesCopiados);
        System.out.println("Tiempo sin buffer: " + milisegundos + " ms");
    }
}
