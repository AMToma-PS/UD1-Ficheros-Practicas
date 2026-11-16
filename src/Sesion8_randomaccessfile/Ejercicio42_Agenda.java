package Sesion8_randomaccessfile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio42_Agenda {
    static final int TAM_ID = 4;
    static final int TAM_NOMBRE = 3;
    static final int TAM_REGISTRO = TAM_ID + TAM_NOMBRE*2;
    static final String NOMBRE_FICHERO = "agenda.dat";

    public static void main(String[] args) throws IOException {
        try(RandomAccessFile raf = new RandomAccessFile(NOMBRE_FICHERO, "rw")){
            raf.setLength(0);

            System.out.println("## Escribo unos contactos");
            escribir(1, "ana");
            escribir(2, "edu");
            escribir(3, "eva");
            escribir(6, "leo");

            System.out.println("## Leo unos contactos");
            leer(1);
            leer(2);
            leer(3);
            leer(6);

            System.out.println("## Modifico el nombre");
            cambiarNombre(3, "ali");

            System.out.println("## Vuelvo a leer ese contacto");
            leer(3);

            System.out.println("## Tamaño del archivo: "+raf.length());
        }
    }

    static void escribir(int id, String nombre) {
        try(RandomAccessFile raf = new RandomAccessFile(NOMBRE_FICHERO, "rw")) {
            raf.seek(id*TAM_REGISTRO);

            raf.writeInt(id);
            raf.writeChars(nombre);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static void leer(int id) {
        try(RandomAccessFile raf = new RandomAccessFile(NOMBRE_FICHERO, "rw")) {
            raf.seek(id*TAM_REGISTRO);

            System.out.println("Datos del registro leido: ");
            System.out.println(" - ID: "+raf.readInt());

            String nombreLeido = "";
            for (int i = 0; i < TAM_NOMBRE; i++) {
                nombreLeido += raf.readChar();
            }
            System.out.println(" - Nombre: " + nombreLeido);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void cambiarNombre(int id, String nuevoNombre) {
        try(RandomAccessFile raf = new RandomAccessFile(NOMBRE_FICHERO, "rw")) {
            raf.seek(id*TAM_REGISTRO+TAM_ID);

            raf.writeChars(nuevoNombre);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
