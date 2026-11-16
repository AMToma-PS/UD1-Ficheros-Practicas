package Sesion3_ficherosTexto;

import java.io.FileReader;
import java.io.IOException;

public class Ejercicio2 {
    public static void main(String[] args) {
        char vocalBuscada = 'E';
        char vocal = Character.toLowerCase(vocalBuscada);

        try (FileReader lector = new FileReader("cuento.txt")) {
            int contador = 0;
            int caracter;
            while ((caracter = lector.read()) != -1) {
                if (Character.toLowerCase((char) caracter) == vocal)
                    contador++;
            }
            System.out.println("La vocal '" + vocal + "' aparece " + contador + " veces");
        } catch (IOException e) {
            System.out.println("Error leyendo el fichero: " + e.getMessage());
        }
    }
}
