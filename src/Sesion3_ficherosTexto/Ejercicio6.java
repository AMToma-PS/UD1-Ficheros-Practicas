package Sesion3_ficherosTexto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio6 {
    public static void main(String[] args) {
        try {
            int numPalabras = cuentaPalabrasFichero("ejercicio6.txt");
            System.out.println("Palabras encontradas: "+numPalabras);
        } catch (FileNotFoundException e) {
            System.out.println("Ha sucedido un error. Vuelve a intentarlo");
        } catch (IOException e) {
            System.out.println("Ha sucedido un error. Vuelve a intentarlo");
        }
    }

    public static int cuentaPalabrasFichero(String nombreFichero) throws IOException {
        BufferedReader bReader = new BufferedReader(
                                        new FileReader(nombreFichero));

        int contador =0;
        String linea = "";

        while((linea = bReader.readLine()) != null){
            if(!linea.isEmpty()){
                linea = linea.trim();
                String[] palabrasLinea = linea.split("\\s+");
                contador += palabrasLinea.length;
                System.out.println("Palabras contadas en esta linea: "+palabrasLinea.length);
            }
        }

        return contador;
    }
}
