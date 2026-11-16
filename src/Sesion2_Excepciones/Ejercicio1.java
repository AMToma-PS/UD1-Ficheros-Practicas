package Sesion2_Excepciones;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class Ejercicio1 {
    public static void main(String[] args) {
        Path ruta = Path.of("papelera.txt");

        try {
            Files.delete(ruta);
            System.out.println("Fichero " + ruta.getFileName() + " borrado");
        } catch (NoSuchFileException e) {
            System.out.println("El fichero no existe: " + ruta.toAbsolutePath());
        } catch (DirectoryNotEmptyException e) {
            System.out.println("La carpeta que quieres borrar no esta vacia");
        } catch (IOException e) {
            System.out.println("Error. No se pudo borrar el elemento: " + e.getMessage());
        }
    }
}
