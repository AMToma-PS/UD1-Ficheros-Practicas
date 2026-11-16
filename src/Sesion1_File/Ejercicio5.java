package Sesion1_File;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class Ejercicio5 {
    public static void main(String[] args) {
        File f = new File("ejercicio3.txt");

        if (f.delete()) {
            System.out.println("Borrado");
        } else {
            System.out.println("No se pudo borrar");
        }

        Path ruta = Path.of("datos1.txt");

        try {
            Files.delete(ruta);
            System.out.println("Borrado");
        } catch (NoSuchFileException e) {
            System.out.println("No existe: " + ruta.toAbsolutePath());
        } catch (DirectoryNotEmptyException e) {
            System.out.println("Es un directorio con contenido");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
