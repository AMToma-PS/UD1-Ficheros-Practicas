package Sesion3_ficherosTexto;

import java.io.*;

public class Ejercicio5 {
    public static void main(String[] args) {
        escribrFichero("ejercio5.txt", 100);
    }

    public static void escribrFichero(String nombreFichero, int numLineas){
        try {
            BufferedWriter wr = new BufferedWriter(
                    new FileWriter(nombreFichero));

            for(int i=0; i<numLineas; i++){
                wr.write("esta es la linea "+i);
                wr.newLine();
            }

            wr.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
