package Sesion8_randomaccessfile;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio42_Inventario {

    static final int TAM_CODIGO = 4;
    static final int TAM_NOMBRE = 5;
    static final int TAM_STOCK = 4;
    static final int TAM_REGISTRO = TAM_CODIGO + TAM_NOMBRE * 2 + TAM_STOCK;
    static final String NOMBRE_FICHERO = "inventario.dat";

    public static void main(String[] args) throws IOException {

        try (RandomAccessFile raf = new RandomAccessFile(NOMBRE_FICHERO, "rw")) {
            raf.setLength(0);
        }

        System.out.println("## Escribo unos productos");
        escribir(1, "mesa", 12);
        escribir(2, "silla", 40);
        escribir(3, "sofa", 3);
        escribir(6, "lampara", 25);

        System.out.println("## Leo los productos");
        leer(1);
        leer(2);
        leer(3);
        leer(6);

        System.out.println("## Modifico el nombre y el stock del producto 3");
        cambiarNombre(3, "cama");
        cambiarStock(3, 7);

        System.out.println("## Vuelvo a leer ese producto");
        leer(3);

        try (RandomAccessFile raf = new RandomAccessFile(NOMBRE_FICHERO, "r")) {
            System.out.println("## Tamaño del archivo: " + raf.length() + " bytes");
        }
    }

    static String ajustar(String nombre) {
        StringBuilder sb = new StringBuilder(nombre);
        sb.setLength(TAM_NOMBRE);
        return sb.toString().replace('\0', ' ');
    }

    static void escribir(int codigo, String nombre, int stock) {
        try (RandomAccessFile raf = new RandomAccessFile(NOMBRE_FICHERO, "rw")) {
            raf.seek((long) codigo * TAM_REGISTRO);
            raf.writeInt(codigo);
            raf.writeChars(ajustar(nombre));
            raf.writeInt(stock);
        } catch (IOException e) {
            System.out.println("Error escribiendo el registro " + codigo + ": " + e.getMessage());
        }
    }

    static void leer(int codigo) {
        try (RandomAccessFile raf = new RandomAccessFile(NOMBRE_FICHERO, "r")) {
            raf.seek((long) codigo * TAM_REGISTRO);

            int codigoLeido = raf.readInt();

            StringBuilder nombre = new StringBuilder();
            for (int i = 0; i < TAM_NOMBRE; i++) {
                nombre.append(raf.readChar());
            }

            int stock = raf.readInt();

            System.out.println(" - Codigo: " + codigoLeido + " | Nombre: " + nombre.toString().trim() + " | Stock: " + stock);
        } catch (IOException e) {
            System.out.println("Error leyendo el registro " + codigo + ": " + e.getMessage());
        }
    }

    static void cambiarNombre(int codigo, String nuevoNombre) {
        try (RandomAccessFile raf = new RandomAccessFile(NOMBRE_FICHERO, "rw")) {
            raf.seek((long) codigo * TAM_REGISTRO + TAM_CODIGO);
            raf.writeChars(ajustar(nuevoNombre));
        } catch (IOException e) {
            System.out.println("Error modificando el registro " + codigo + ": " + e.getMessage());
        }
    }

    static void cambiarStock(int codigo, int nuevoStock) {
        try (RandomAccessFile raf = new RandomAccessFile(NOMBRE_FICHERO, "rw")) {
            raf.seek((long) codigo * TAM_REGISTRO + TAM_CODIGO + TAM_NOMBRE * 2);
            raf.writeInt(nuevoStock);
        } catch (IOException e) {
            System.out.println("Error modificando el registro " + codigo + ": " + e.getMessage());
        }
    }
}
