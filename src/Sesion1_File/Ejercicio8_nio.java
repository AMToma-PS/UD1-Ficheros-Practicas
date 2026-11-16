package Sesion1_File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Ejercicio8_nio {
    public static void main(String[] args) {
        Path ruta = Path.of("copias");

        try (Stream<Path> contenido = Files.walk(ruta)) {
            contenido.forEach(p -> System.out.println((Files.isDirectory(p) ? "[DIR]  " : "[FILE] ") + p));
        } catch (IOException e) {
            System.out.println("No se pudo recorrer " + ruta.toAbsolutePath() + ": " + e.getMessage());
        }
    }
}
