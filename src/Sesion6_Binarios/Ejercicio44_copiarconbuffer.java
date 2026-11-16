package Sesion6_Binarios;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio44_copiarconbuffer {

    public static void main(String[] args) throws IOException {
        long inicio = System.nanoTime();
        long bytesCopiados = 0;

        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("paisaje.jpg"));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("paisaje_copia_buffer.jpg"))) {
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
                bytesCopiados++;
            }
        }

        long milisegundos = (System.nanoTime() - inicio) / 1_000_000;
        System.out.println("Bytes copiados: " + bytesCopiados);
        System.out.println("Tiempo con buffer: " + milisegundos + " ms");
    }
}
