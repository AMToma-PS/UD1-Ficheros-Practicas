package Sesion3_ficherosTexto;

import java.io.*;

public class Ejercicio7 {
    public static void main(String[] args) {
        try {
            combinaFicheros("f1.txt", "f2.txt");
        } catch (IOException e) {
            System.out.println("Algo salio mal");
        }
    }

    public static void combinaFicheros(String f1, String f2) throws IOException {
        BufferedWriter bWriter = new BufferedWriter(
                                new FileWriter("ejercicio7.txt"));

        BufferedReader bReader = new BufferedReader(
                                new FileReader(f1));

        String linea = "";
        while((linea = bReader.readLine()) != null){
            bWriter.write(linea);
            bWriter.newLine();
        }

        bReader.close();

        bReader = new BufferedReader(new FileReader(f2));

        linea = "";
        while((linea = bReader.readLine()) != null){
            bWriter.write(linea);
            bWriter.newLine();
        }

        bReader.close();
        bWriter.close();
    }
}
