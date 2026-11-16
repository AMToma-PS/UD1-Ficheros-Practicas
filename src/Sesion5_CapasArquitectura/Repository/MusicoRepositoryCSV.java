package Sesion5_CapasArquitectura.Repository;

import Sesion5_CapasArquitectura.Model.Musico;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MusicoRepositoryCSV {

    private final String nombreFichero = "musicos.csv";

    public void save(Musico m) throws IOException {
        ArrayList<Musico> musicos = cargarCSV();
        musicos.add(m);
        guardarCSV(musicos);
    }

    public Musico findById(int id) throws IOException {
        for (Musico m : cargarCSV()) {
            if (m.getId() == id)
                return m;
        }
        return null;
    }

    public ArrayList<Musico> findAll() throws IOException {
        return cargarCSV();
    }

    public ArrayList<Musico> musicosDeLaBanda(int idBanda) throws IOException {
        ArrayList<Musico> musicosBanda = new ArrayList<>();
        for (Musico m : cargarCSV()) {
            if (m.getBanda() == idBanda)
                musicosBanda.add(m);
        }
        return musicosBanda;
    }

    public void deleteById(int id) throws IOException {
        ArrayList<Musico> musicos = cargarCSV();
        musicos.removeIf(m -> m.getId() == id);
        guardarCSV(musicos);
    }

    public void cambiarBanda(int id, int nuevaBanda) throws IOException {
        ArrayList<Musico> musicos = cargarCSV();
        for (Musico m : musicos) {
            if (m.getId() == id) {
                m.setBanda(nuevaBanda);
            }
        }
        guardarCSV(musicos);
    }

    private ArrayList<Musico> cargarCSV() throws IOException {
        ArrayList<Musico> musicosCargados = new ArrayList<>();
        File fichero = new File(nombreFichero);
        if (!fichero.exists()) {
            return musicosCargados;
        }

        try (Scanner sc = new Scanner(fichero)) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                if (linea.isBlank()) continue;
                String[] campos = linea.split(",");
                musicosCargados.add(new Musico(
                        Integer.parseInt(campos[0]),
                        campos[1],
                        Integer.parseInt(campos[2])
                ));
            }
        }
        return musicosCargados;
    }

    private void guardarCSV(ArrayList<Musico> musicos) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(nombreFichero, false))) {
            for (Musico m : musicos) {
                pw.println(m);
            }
        }
    }
}
