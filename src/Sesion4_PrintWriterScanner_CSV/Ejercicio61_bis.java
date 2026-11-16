package Sesion4_PrintWriterScanner_CSV;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Scanner;

public class Ejercicio61_bis {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();

        try {
            Scanner sc = new Scanner(new File("media.txt"));

            while(sc.hasNextLine()){
                try {
                    int numeroAuxiliar = Integer.valueOf(sc.nextLine());
                    numeros.add(numeroAuxiliar);
                }catch (Exception e){
                    System.out.println("He leido algo raro");
                }
            }

            sc.close();

            OptionalDouble media = numeros.stream()
                    .mapToInt(x -> x.intValue())
                    .average();

            PrintWriter pw = new PrintWriter(new FileWriter("resultado.txt"));

            if(media.isPresent())
                pw.printf("Media: %.2f%n", media.getAsDouble());

            pw.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
