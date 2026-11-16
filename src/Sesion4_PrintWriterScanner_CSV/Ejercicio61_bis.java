package Sesion4_PrintWriterScanner_CSV;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.Scanner;

public class Ejercicio61_bis {
    public static void main(String[] args) {
        ArrayList<Integer> temperaturas = new ArrayList<>();

        try (Scanner sc = new Scanner(new File("temperaturas.txt"))) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine().trim();
                try {
                    temperaturas.add(Integer.parseInt(linea));
                } catch (NumberFormatException e) {
                    System.out.println("Linea ignorada: \"" + linea + "\"");
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer temperaturas.txt");
            return;
        }

        OptionalDouble media = temperaturas.stream()
                .mapToInt(Integer::intValue)
                .average();

        int maxima = temperaturas.stream().mapToInt(Integer::intValue).max().orElse(0);
        int minima = temperaturas.stream().mapToInt(Integer::intValue).min().orElse(0);

        try (PrintWriter pw = new PrintWriter(new FileWriter("media_temperaturas.txt"))) {
            if (media.isPresent()) {
                pw.printf("Media: %.2f%n", media.getAsDouble());
                pw.printf("Maxima: %d%n", maxima);
                pw.printf("Minima: %d%n", minima);
                System.out.printf("Media %.2f, maxima %d, minima %d%n", media.getAsDouble(), maxima, minima);
            } else {
                pw.println("Sin datos");
                System.out.println("Sin datos");
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el resultado: " + e.getMessage());
        }
    }
}
