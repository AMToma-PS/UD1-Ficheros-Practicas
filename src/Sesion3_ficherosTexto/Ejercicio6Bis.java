package Sesion3_ficherosTexto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio6Bis {
    public static void main(String[] args) throws IOException {
        int numPalabras = cuentaPalabrasFichero("palabras.txt");
        System.out.println("Palabras encontradas: " + numPalabras);
    }

    public static int cuentaPalabrasFichero(String nombreFichero) throws IOException {
        try (BufferedReader lector = new BufferedReader(new FileReader(nombreFichero))) {
            return lector.lines()
                    .map(String::trim)
                    .filter(linea -> !linea.isEmpty())
                    .mapToInt(linea -> linea.split("\\s+").length)
                    .sum();
        }
    }
}
