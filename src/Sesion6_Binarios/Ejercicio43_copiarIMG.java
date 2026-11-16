package Sesion6_Binarios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio43_copiarIMG {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("fotogrande.jpg");

        FileOutputStream out = new FileOutputStream("copia.jpg");

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
