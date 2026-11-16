package Sesion3_ficherosTexto;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio1 {
    public static void main(String[] args) {
        try (FileReader fichero = new FileReader("notas.txt")) {
            int caracter;
            int total = 0;
            while ((caracter = fichero.read()) != -1) {
                System.out.print((char) caracter);
                total++;
            }
            System.out.println();
            System.out.println("Caracteres leidos: " + total);
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el fichero");
        } catch (IOException e) {
            System.out.println("Error leyendo el fichero: " + e.getMessage());
        }
    }
}
