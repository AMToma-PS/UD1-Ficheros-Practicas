package Sesion3_ficherosTexto;

import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio3 {
    public static void main(String[] args) throws IOException {
        int numeroFicheros = 4;

        for (int i = 1; i <= numeroFicheros; i++) {
            String nombre = "informe" + i + ".txt";
            try (FileWriter escritor = new FileWriter(nombre)) {
                escritor.write("Este es el fichero " + nombre);
            }
            System.out.println("Creado " + nombre);
        }
    }
}
