package Sesion3_ficherosTexto;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio2 {
    public static void main(String[] args) {
        try {
            FileReader fReader = new FileReader("libro.txt");
            int contador = 0;
            char vocalBuscada = 'a';

            int letra;
            while((letra = fReader.read())!=-1){
                if(vocalBuscada == Character.toLowerCase(letra))
                    contador++;
            }

            fReader.close();

            System.out.println("El resultado es: "+contador+" "+vocalBuscada+"s");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
