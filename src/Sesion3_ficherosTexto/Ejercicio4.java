package Sesion3_ficherosTexto;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) throws IOException {
        String fraseUsuario = "";

        FileWriter fWriter = new FileWriter("memoriasUsuario.txt", true);

        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe frases para guardar: ");
        fraseUsuario = sc.nextLine();

        while(!fraseUsuario.toLowerCase().equals("fin")){
            fWriter.write(fraseUsuario+"\n");
            fraseUsuario = sc.nextLine();
        }

        sc.close();
        fWriter.close();
    }
}
