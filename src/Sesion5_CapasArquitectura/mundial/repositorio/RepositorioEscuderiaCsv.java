package Sesion5_CapasArquitectura.mundial.repositorio;

import Sesion5_CapasArquitectura.mundial.modelo.Escuderia;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RepositorioEscuderiaCsv {

    private final Path fichero;

    public RepositorioEscuderiaCsv(Path fichero) {
        this.fichero = fichero;
    }

    private List<Escuderia> cargar() throws IOException {
        List<Escuderia> lista = new ArrayList<>();

        if (!Files.exists(fichero)) return lista;

        try (Scanner sc = new Scanner(fichero)) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                if (linea.isBlank()) continue;

                String[] campos = linea.split(";");
                lista.add(new Escuderia(
                        Integer.parseInt(campos[0]),
                        campos[1],
                        Integer.parseInt(campos[2])));
            }
        }
        return lista;
    }

    private void guardar(List<Escuderia> lista) throws IOException {
        try (PrintWriter pw = new PrintWriter(fichero.toFile())) {
            for (Escuderia e : lista) {
                pw.println(e.getId() + ";" + e.getNombre() + ";" + e.getPuntos());
            }
        }
    }

    public List<Escuderia> buscarTodos() throws IOException {
        return cargar();
    }

    public Escuderia buscarPorId(int id) throws IOException {
        for (Escuderia e : cargar()) {
            if (e.getId() == id) return e;
        }
        return null;
    }

    public void insertar(Escuderia escuderia) throws IOException {
        List<Escuderia> lista = cargar();
        lista.add(escuderia);
        guardar(lista);
    }

    public boolean actualizar(Escuderia escuderia) throws IOException {
        List<Escuderia> lista = cargar();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == escuderia.getId()) {
                lista.set(i, escuderia);
                guardar(lista);
                return true;
            }
        }
        return false;
    }

    public boolean eliminar(int id) throws IOException {
        List<Escuderia> lista = cargar();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                lista.remove(i);
                guardar(lista);
                return true;
            }
        }
        return false;
    }
}
