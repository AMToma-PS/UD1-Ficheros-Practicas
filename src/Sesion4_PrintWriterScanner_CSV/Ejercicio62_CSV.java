package Sesion4_PrintWriterScanner_CSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio62_CSV {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Libro> libros = cargar("libros.csv");

        System.out.println("### Libros cargados ###");
        libros.forEach(System.out::println);

        libros.add(new Libro(4, "La sombra del viento", "Carlos Ruiz Zafon"));
        libros.get(1).setTitulo("Cien anos de soledad (edicion especial)");

        guardar(libros, "libros2.csv");
        System.out.println("### Guardado en libros2.csv ###");

        modificarAutor("libros2.csv", 1, "M. de Cervantes");
        cargar("libros2.csv").forEach(System.out::println);
    }

    static ArrayList<Libro> cargar(String nombreFichero) throws FileNotFoundException {
        ArrayList<Libro> librosMemoria = new ArrayList<>();

        try (Scanner sc = new Scanner(new File(nombreFichero))) {
            if (sc.hasNextLine())
                sc.nextLine();

            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                if (linea.isBlank())
                    continue;
                String[] campos = linea.split(",");
                librosMemoria.add(new Libro(
                        Integer.parseInt(campos[0].trim()),
                        campos[1].trim(),
                        campos[2].trim()));
            }
        }

        return librosMemoria;
    }

    static void guardar(ArrayList<Libro> libros, String nombreFichero) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(new File(nombreFichero))) {
            pw.println("id,titulo,autor");
            for (Libro l : libros) {
                pw.println(l);
            }
        }
    }

    static void modificarAutor(String nombreFichero, int id, String nuevoAutor) throws FileNotFoundException {
        ArrayList<Libro> libros = cargar(nombreFichero);
        for (Libro l : libros) {
            if (l.getId() == id) {
                l.setAutor(nuevoAutor);
            }
        }
        guardar(libros, nombreFichero);
    }
}
