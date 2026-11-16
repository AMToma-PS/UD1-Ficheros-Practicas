package Sesion5_CapasArquitectura.liga.servicio;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Sesion5_CapasArquitectura.liga.repositorio.*;
import Sesion5_CapasArquitectura.liga.modelo.*;
import Sesion5_CapasArquitectura.liga.servicio.*;

public class LigaService {
    private final RepositorioJugadorCsv repoJugadores;
    private final RepositorioEquipoCsv repoEquipos;

    public LigaService(RepositorioJugadorCsv repoJugadores, RepositorioEquipoCsv repoEquipos) {
        this.repoJugadores = repoJugadores;
        this.repoEquipos = repoEquipos;
    }

    public void fichar(Jugador jugador, int idEquipo) throws IOException {
        if (jugador.getNombre() == null || jugador.getNombre().isBlank()) {
            throw new IllegalArgumentException("El jugador debe tener nombre");
        }

        if (jugador.getDorsal() < 1 || jugador.getDorsal() > 99) {
            throw new IllegalArgumentException("El dorsal debe estar entre 1 y 99");
        }

        if (repoJugadores.buscarPorId(jugador.getDorsal()) != null) {
            throw new IllegalArgumentException(
                    "Ya existe un jugador con el dorsal " + jugador.getDorsal());
        }

        if (repoEquipos.buscarPorId(idEquipo) == null) {
            throw new IllegalArgumentException("No existe el equipo " + idEquipo);
        }

        jugador.setIdEquipo(idEquipo);
        repoJugadores.insertar(jugador);
    }

    public List<Jugador> listarJugadores() throws IOException {
        return repoJugadores.buscarTodos();
    }

    public List<Equipo> listarEquipos() throws IOException {
        return repoEquipos.buscarTodos();
    }

    public Equipo equipoConJugadores(int id) throws IOException {
        Equipo equipo = repoEquipos.buscarPorId(id);
        if (equipo == null) return null;

        List<Jugador> suyos = new ArrayList<>();
        for (Jugador j : repoJugadores.buscarTodos()) {
            if (j.getIdEquipo() == id) {
                suyos.add(j);
            }
        }

        equipo.setJugadores(suyos);
        return equipo;
    }

    public void sumarPuntos(int idEquipo, int puntos) throws IOException {
        Equipo equipo = repoEquipos.buscarPorId(idEquipo);
        if (equipo == null) {
            throw new IllegalArgumentException("No existe el equipo " + idEquipo);
        }

        equipo.setPuntos(equipo.getPuntos() + puntos);
        repoEquipos.actualizar(equipo);
    }

    public List<Equipo> clasificacion() throws IOException {
        List<Equipo> equipos = repoEquipos.buscarTodos();
        equipos.sort((a, b) -> b.getPuntos() - a.getPuntos());
        return equipos;
    }
}
