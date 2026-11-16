package Sesion4_PrintWriterScanner_CSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio62_CSV {
      public static void main(String[] args) throws FileNotFoundException {
          ArrayList<Alumno> alumnos = cargar("alumnos.csv");

          alumnos.forEach(System.out::println);

          alumnos.add(new Alumno(3, "Julian","j@iespab.com"));
          alumnos.get(1).setNombre("Eustaquio");

          guardar(alumnos, "alumnos2.csv");
    }

    static ArrayList<Alumno> cargar(String nombreFichero) throws FileNotFoundException {
        ArrayList<Alumno> alumnosMemoria = new ArrayList<>();

        Scanner sc = new Scanner(new File(nombreFichero));

        String lineaTitulos = sc.nextLine();

        while(sc.hasNextLine()){
            String linea = sc.nextLine();
            String[] datosLineaSeperados = linea.split(",");
            Alumno a = new Alumno(
                    Integer.parseInt(datosLineaSeperados[0]),
                    datosLineaSeperados[1],
                    datosLineaSeperados[2]);
            alumnosMemoria.add(a);
        }

        return alumnosMemoria;
    }

    static void guardar(ArrayList<Alumno> alus, String nombreFichero ) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File(nombreFichero));

        pw.println("id,nombre,email");
        for (Alumno a: alus) {
            pw.println(a);
        }

        pw.close();
    }

    static void modificarEmail(int id, String nuevoEmail){
    }
}
