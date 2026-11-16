package Sesion5_CapasArquitectura.mundial.servicio;

import Sesion5_CapasArquitectura.mundial.modelo.Escuderia;
import Sesion5_CapasArquitectura.mundial.modelo.Piloto;
import Sesion5_CapasArquitectura.mundial.repositorio.RepositorioEscuderiaCsv;
import Sesion5_CapasArquitectura.mundial.repositorio.RepositorioPilotoCsv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MundialService {

    private static final int MAX_PILOTOS_POR_ESCUDERIA = 2;

    private final RepositorioPilotoCsv repoPilotos;
    private final RepositorioEscuderiaCsv repoEscuderias;

    public MundialService(RepositorioPilotoCsv repoPilotos, RepositorioEscuderiaCsv repoEscuderias) {
        this.repoPilotos = repoPilotos;
        this.repoEscuderias = repoEscuderias;
    }

    public void contratar(Piloto piloto, int idEscuderia) throws IOException {

        if (piloto.getNombre() == null || piloto.getNombre().isBlank()) {
            throw new IllegalArgumentException("El piloto debe tener nombre");
        }

        if (piloto.getDorsal() < 1 || piloto.getDorsal() > 99) {
            throw new IllegalArgumentException("El dorsal debe estar entre 1 y 99");
        }

        if (repoPilotos.buscarPorId(piloto.getDorsal()) != null) {
            throw new IllegalArgumentException(
                    "Ya existe un piloto con el dorsal " + piloto.getDorsal());
        }

        if (repoEscuderias.buscarPorId(idEscuderia) == null) {
            throw new IllegalArgumentException("No existe la escuderia " + idEscuderia);
        }

        if (pilotosDe(idEscuderia).size() >= MAX_PILOTOS_POR_ESCUDERIA) {
            throw new IllegalArgumentException(
                    "La escuderia " + idEscuderia + " ya tiene " + MAX_PILOTOS_POR_ESCUDERIA + " pilotos");
        }

        piloto.setIdEscuderia(idEscuderia);
        repoPilotos.insertar(piloto);
    }

    public List<Piloto> listarPilotos() throws IOException {
        return repoPilotos.buscarTodos();
    }

    public List<Escuderia> listarEscuderias() throws IOException {
        return repoEscuderias.buscarTodos();
    }

    public Escuderia escuderiaConPilotos(int id) throws IOException {
        Escuderia escuderia = repoEscuderias.buscarPorId(id);
        if (escuderia == null) return null;

        escuderia.setPilotos(pilotosDe(id));
        return escuderia;
    }

    private List<Piloto> pilotosDe(int idEscuderia) throws IOException {
        List<Piloto> suyos = new ArrayList<>();
        for (Piloto p : repoPilotos.buscarTodos()) {
            if (p.getIdEscuderia() == idEscuderia) {
                suyos.add(p);
            }
        }
        return suyos;
    }

    public void sumarPuntos(int idEscuderia, int puntos) throws IOException {
        Escuderia escuderia = repoEscuderias.buscarPorId(idEscuderia);
        if (escuderia == null) {
            throw new IllegalArgumentException("No existe la escuderia " + idEscuderia);
        }

        escuderia.setPuntos(escuderia.getPuntos() + puntos);
        repoEscuderias.actualizar(escuderia);
    }

    public List<Escuderia> clasificacion() throws IOException {
        List<Escuderia> escuderias = repoEscuderias.buscarTodos();
        escuderias.sort((a, b) -> b.getPuntos() - a.getPuntos());
        return escuderias;
    }
}
