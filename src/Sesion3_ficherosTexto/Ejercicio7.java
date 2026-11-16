package Sesion3_ficherosTexto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio7 {
    public static void main(String[] args) {
        try {
            combinaFicheros("parte1.txt", "parte2.txt", "relato_completo.txt");
            System.out.println("Ficheros combinados en relato_completo.txt");
        } catch (IOException e) {
            System.out.println("Algo salio mal: " + e.getMessage());
        }
    }

    public static void combinaFicheros(String origen1, String origen2, String destino) throws IOException {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(destino))) {
            copiarLineas(origen1, escritor);
            copiarLineas(origen2, escritor);
        }
    }

    private static void copiarLineas(String origen, BufferedWriter escritor) throws IOException {
        try (BufferedReader lector = new BufferedReader(new FileReader(origen))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                escritor.write(linea);
                escritor.newLine();
            }
        }
    }
}
