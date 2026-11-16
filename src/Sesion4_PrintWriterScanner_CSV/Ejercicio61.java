package Sesion4_PrintWriterScanner_CSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio61 {
    public static void main(String[] args) {
        ArrayList<Integer> temperaturas = new ArrayList<>();
        int suma = 0;

        try (Scanner sc = new Scanner(new File("temperaturas.txt"))) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine().trim();
                try {
                    int temperatura = Integer.parseInt(linea);
                    suma += temperatura;
                    temperaturas.add(temperatura);
                    System.out.println("Temperatura leida: " + temperatura);
                } catch (NumberFormatException e) {
                    System.out.println("Linea ignorada: \"" + linea + "\"");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra temperaturas.txt");
            return;
        }

        if (temperaturas.isEmpty()) {
            System.out.println("No hay temperaturas validas");
            return;
        }

        double media = (double) suma / temperaturas.size();

        try (PrintWriter pw = new PrintWriter(new FileWriter("media_temperaturas.txt"))) {
            pw.printf("Lecturas: %d%n", temperaturas.size());
            pw.printf("Media: %.2f%n", media);
            System.out.printf("Media guardada en media_temperaturas.txt: %.2f%n", media);
        } catch (IOException e) {
            System.out.println("Error al escribir el resultado: " + e.getMessage());
        }
    }
}
