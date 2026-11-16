package Sesion5_CapasArquitectura.Repository;

import Sesion5_CapasArquitectura.Model.Banda;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BandaRepositoryCSV {

    private final String nombreFichero = "bandas.csv";

    public void save(Banda b) throws IOException {
        ArrayList<Banda> bandas = cargarCSV();
        bandas.add(b);
        guardarCSV(bandas);
    }

    public Banda findById(int id) throws IOException {
        for (Banda banda : cargarCSV()) {
            if (banda.getId() == id) {
                return banda;
            }
        }
        return null;
    }

    public ArrayList<Banda> findAll() throws IOException {
        return cargarCSV();
    }

    public void deleteById(int id) throws IOException {
        ArrayList<Banda> bandas = cargarCSV();
        bandas.removeIf(b -> b.getId() == id);
        guardarCSV(bandas);
    }

    private ArrayList<Banda> cargarCSV() throws IOException {
        ArrayList<Banda> bandasCargadas = new ArrayList<>();
        File fichero = new File(nombreFichero);
        if (!fichero.exists()) {
            return bandasCargadas;
        }

        try (Scanner sc = new Scanner(fichero)) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                if (linea.isBlank()) continue;
                String[] campos = linea.split(",");
                bandasCargadas.add(new Banda(
                        Integer.parseInt(campos[0]),
                        campos[1],
                        Integer.parseInt(campos[2])
                ));
            }
        }
        return bandasCargadas;
    }

    private void guardarCSV(ArrayList<Banda> bandas) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(nombreFichero, false))) {
            for (Banda banda : bandas) {
                pw.println(banda);
            }
        }
    }
}
