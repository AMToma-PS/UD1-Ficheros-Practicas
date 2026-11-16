package Sesion2_Excepciones;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class Ejercicio1 {
    public static void main(String[] args) {
        try {
            Path ruta = Path.of("");

            Files.delete(ruta);
        } catch (NoSuchFileException e) {
            System.out.println("El fichero no existe");
        } catch (DirectoryNotEmptyException e) {
            System.out.println("La carpeta que quieres borrar no esta vacia");
        } catch (IOException e) {
            System.out.println("Error. No se puedo borrar el elemento: "+e.getMessage());
        }
    }
}
