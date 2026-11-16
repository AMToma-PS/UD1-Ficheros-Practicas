package Sesion5_CapasArquitectura.liga.repositorio;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Sesion5_CapasArquitectura.liga.repositorio.*;
import Sesion5_CapasArquitectura.liga.modelo.*;
import Sesion5_CapasArquitectura.liga.servicio.*;

public class RepositorioJugadorCsv {
    private final Path fichero;

    public RepositorioJugadorCsv(Path fichero) {
        this.fichero = fichero;
    }

    private List<Jugador> cargar() throws IOException {
        List<Jugador> lista = new ArrayList<>();

        if (!Files.exists(fichero)) return lista;

        try (Scanner sc = new Scanner(fichero)) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                if (linea.isBlank()) continue;

                String[] campos = linea.split(",");
                lista.add(new Jugador(
                        Integer.parseInt(campos[0]),
                        campos[1],
                        Integer.parseInt(campos[2])));
            }
        }
        return lista;
    }

    private void guardar(List<Jugador> lista) throws IOException {
        try (PrintWriter pw = new PrintWriter(fichero.toFile())) {
            for (Jugador j : lista) {
                pw.println(j.getDorsal() + "," + j.getNombre() + "," + j.getIdEquipo());
            }
        }
    }

    public List<Jugador> buscarTodos() throws IOException {
        return cargar();
    }

    public Jugador buscarPorId(int dorsal) throws IOException {
        for (Jugador j : cargar()) {
            if (j.getDorsal() == dorsal) return j;
        }
        return null;
    }

    public void insertar(Jugador jugador) throws IOException {
        List<Jugador> lista = cargar();
        lista.add(jugador);
        guardar(lista);
    }

    public boolean actualizar(Jugador jugador) throws IOException {
        List<Jugador> lista = cargar();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getDorsal() == jugador.getDorsal()) {
                lista.set(i, jugador);
                guardar(lista);
                return true;
            }
        }
        return false;
    }

    public boolean eliminar(int dorsal) throws IOException {
        List<Jugador> lista = cargar();

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
