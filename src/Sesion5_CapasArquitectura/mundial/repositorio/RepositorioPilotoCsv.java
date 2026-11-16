package Sesion5_CapasArquitectura.mundial.repositorio;

import Sesion5_CapasArquitectura.mundial.modelo.Piloto;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RepositorioPilotoCsv {

    private final Path fichero;

    public RepositorioPilotoCsv(Path fichero) {
        this.fichero = fichero;
    }

    private List<Piloto> cargar() throws IOException {
        List<Piloto> lista = new ArrayList<>();

        if (!Files.exists(fichero)) return lista;

        try (Scanner sc = new Scanner(fichero)) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                if (linea.isBlank()) continue;

                String[] campos = linea.split(";");
                lista.add(new Piloto(
                        Integer.parseInt(campos[0]),
                        campos[1],
                        Integer.parseInt(campos[2])));
            }
        }
        return lista;
    }

    private void guardar(List<Piloto> lista) throws IOException {
        try (PrintWriter pw = new PrintWriter(fichero.toFile())) {
            for (Piloto p : lista) {
                pw.println(p.getDorsal() + ";" + p.getNombre() + ";" + p.getIdEscuderia());
            }
        }
    }

    public List<Piloto> buscarTodos() throws IOException {
        return cargar();
    }

    public Piloto buscarPorId(int dorsal) throws IOException {
        for (Piloto p : cargar()) {
            if (p.getDorsal() == dorsal) return p;
        }
        return null;
    }

    public void insertar(Piloto piloto) throws IOException {
        List<Piloto> lista = cargar();
        lista.add(piloto);
        guardar(lista);
    }

    public boolean actualizar(Piloto piloto) throws IOException {
        List<Piloto> lista = cargar();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getDorsal() == piloto.getDorsal()) {
                lista.set(i, piloto);
                guardar(lista);
                return true;
            }
        }
        return false;
    }

    public boolean eliminar(int dorsal) throws IOException {
        List<Piloto> lista = cargar();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getDorsal() == dorsal) {
                lista.remove(i);
                guardar(lista);
                return true;
            }
        }
        return false;
    }
}
