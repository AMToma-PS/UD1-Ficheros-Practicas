package Sesion3_ficherosTexto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio5 {
    public static void main(String[] args) {
        escribirFichero("lineas.txt", 50);
    }

    public static void escribirFichero(String nombreFichero, int numLineas) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreFichero))) {
            for (int i = 1; i <= numLineas; i++) {
                escritor.write("Linea numero " + i + " de " + numLineas);
                escritor.newLine();
            }
            System.out.println("Escritas " + numLineas + " lineas en " + nombreFichero);
        } catch (IOException e) {
            System.out.println("Error escribiendo el fichero: " + e.getMessage());
        }
    }
}
