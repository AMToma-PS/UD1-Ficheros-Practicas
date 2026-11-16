package Sesion6_Binarios;

import java.io.*;

public class Ejercicio44_copiarconbuffer {
    public static void main(String[] args) throws IOException {
        BufferedInputStream in = new BufferedInputStream(
                new FileInputStream("fotogrande.jpg"));

        BufferedOutputStream out  = new BufferedOutputStream(
                new FileOutputStream("copia.jpg"));

        long t1 = System.nanoTime();

        int b;
        while((b = in.read()) != -1){
            out.write(b);
        }

        long tiempoConBuffer = (System.nanoTime() - t1) / 1_000_000;

        System.out.println("Tiempo: "+tiempoConBuffer);

        in.close();
        out.close();
    }
}
