package Sesion3_ficherosTexto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) throws IOException {
        String nombreFichero = "diario.txt";
        Scanner sc = new Scanner(System.in);

        try (FileWriter escritor = new FileWriter(nombreFichero, true)) {
            System.out.println("Escribe entradas del diario (\"salir\" para terminar): ");
            String frase = sc.nextLine();

            while (!frase.equalsIgnoreCase("salir")) {
                escritor.write(frase + System.lineSeparator());
                frase = sc.nextLine();
            }
        }
        sc.close();

        System.out.println("--- Contenido de " + nombreFichero + " ---");
        try (BufferedReader lector = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            int n = 1;
            while ((linea = lector.readLine()) != null) {
                System.out.println(n++ + ". " + linea);
            }
        }
    }
}
