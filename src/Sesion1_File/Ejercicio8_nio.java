package Sesion1_File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Ejercicio8_nio {
    public static void main(String[] args) {
        Path ruta = Path.of("datos2");

        try (Stream<Path> contenido = Files.walk(ruta);){
            contenido.forEach(System.out::println);

            contenido.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
