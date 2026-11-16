package Sesion3_ficherosTexto;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio1 {
    public static void main(String[] args) {
        try {
            FileReader fichero = new FileReader("datos1.txt");

            int letra;
            while((letra = fichero.read()) != -1)
                System.out.print((char)letra);

            fichero.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error en el nombre del fichero");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
