package Sesion4_PrintWriterScanner_CSV;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio61 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        int numerosSumados = 0;
        int cuantosNumerosHay = 0;

        try {
            Scanner sc = new Scanner(new File("media.txt"));

            while(sc.hasNextLine()){
                try {
                    int numeroAuxiliar = Integer.valueOf(sc.nextLine());
                    numerosSumados += numeroAuxiliar;
                    numeros.add(numeroAuxiliar);
                    System.out.println("Numero leido: "+numeroAuxiliar  );
                }catch (Exception e){
                    System.out.println("He leido algo raro");
                }
            }

            sc.close();

            cuantosNumerosHay = numeros.size();
            float resultado = numerosSumados / cuantosNumerosHay;

            PrintWriter pw = new PrintWriter(new FileWriter("resultado.txt"));

            pw.printf("Media: %.2f%n", resultado);

            pw.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
