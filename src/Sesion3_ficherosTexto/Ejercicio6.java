package Sesion3_ficherosTexto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio6 {
    public static void main(String[] args) {
        try {
            int numPalabras = cuentaPalabrasFichero("palabras.txt");
            System.out.println("Palabras encontradas: " + numPalabras);
        } catch (IOException e) {
            System.out.println("Ha sucedido un error: " + e.getMessage());
        }
    }

    public static int cuentaPalabrasFichero(String nombreFichero) throws IOException {
        int contador = 0;

        try (BufferedReader lector = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            int numLinea = 0;
            while ((linea = lector.readLine()) != null) {
                numLinea++;
                linea = linea.trim();
                if (linea.isEmpty()) {
                    System.out.println("Linea " + numLinea + ": vacia");
                    continue;
                }
                int palabras = linea.split("\\s+").length;
                contador += palabras;
                System.out.println("Linea " + numLinea + ": " + palabras + " palabras");
            }
        }

        return contador;
    }
}
