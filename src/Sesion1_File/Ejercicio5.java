package Sesion1_File;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class Ejercicio5 {
    public static void main(String[] args) {
        File f = new File("temporal.txt");

        if (f.delete()) {
            System.out.println("File.delete(): " + f.getName() + " borrado");
        } else {
            System.out.println("File.delete(): no se pudo borrar " + f.getName());
        }

        Path ruta = Path.of("temporal_nio.txt");

        try {
            Files.delete(ruta);
            System.out.println("Files.delete(): " + ruta.getFileName() + " borrado");
        } catch (NoSuchFileException e) {
            System.out.println("Files.delete(): no existe " + ruta.toAbsolutePath());
        } catch (DirectoryNotEmptyException e) {
            System.out.println("Files.delete(): es un directorio con contenido");
        } catch (IOException e) {
            System.out.println("Files.delete(): error " + e.getMessage());
        }
    }
}
