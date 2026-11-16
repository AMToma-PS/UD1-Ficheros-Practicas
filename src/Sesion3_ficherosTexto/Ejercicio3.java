package Sesion3_ficherosTexto;

import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio3 {
    public static void main(String[] args) throws IOException {
        int numeroFicheros = 5;

        for(int i=0; i<numeroFicheros; i++){
            FileWriter fWriter = new FileWriter("nombre"+i+".txt");
            fWriter.write("Este es fichero numero"+i);
            fWriter.close();
        }
    }
}
