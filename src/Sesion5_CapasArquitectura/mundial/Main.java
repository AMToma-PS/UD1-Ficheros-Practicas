package Sesion5_CapasArquitectura.mundial;

import Sesion5_CapasArquitectura.mundial.modelo.Escuderia;
import Sesion5_CapasArquitectura.mundial.modelo.Piloto;
import Sesion5_CapasArquitectura.mundial.repositorio.RepositorioEscuderiaCsv;
import Sesion5_CapasArquitectura.mundial.repositorio.RepositorioPilotoCsv;
import Sesion5_CapasArquitectura.mundial.servicio.MundialService;

import java.io.IOException;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {

        RepositorioPilotoCsv repoPilotos = new RepositorioPilotoCsv(Path.of("pilotos.csv"));
        RepositorioEscuderiaCsv repoEscuderias = new RepositorioEscuderiaCsv(Path.of("escuderias.csv"));

        MundialService mundial = new MundialService(repoPilotos, repoEscuderias);

        for (Escuderia e : repoEscuderias.buscarTodos()) repoEscuderias.eliminar(e.getId());
        for (Piloto p : repoPilotos.buscarTodos()) repoPilotos.eliminar(p.getDorsal());

        repoEscuderias.insertar(new Escuderia(1, "Scuderia Roja", 0));
        repoEscuderias.insertar(new Escuderia(2, "Flechas Plateadas", 0));
        repoEscuderias.insertar(new Escuderia(3, "Toro Azul", 0));

        mundial.contratar(new Piloto(14, "Fernando Alonso", 0), 1);
        mundial.contratar(new Piloto(55, "Carlos Sainz", 0), 1);
        mundial.contratar(new Piloto(44, "Lewis Hamilton", 0), 2);
        mundial.contratar(new Piloto(1, "Max Verstappen", 0), 3);

        System.out.println("=== Pilotos de una escuderia ===");
        System.out.println("Desde el repositorio: " + repoEscuderias.buscarPorId(1));

        Escuderia escuderia = mundial.escuderiaConPilotos(1);
        System.out.println("Desde el servicio:    " + escuderia);
        for (Piloto p : escuderia.getPilotos()) {
            System.out.println("   " + p);
        }

        System.out.println();
        System.out.println("=== Actualizar y eliminar ===");
        System.out.println("actualizar dorsal 44: " + repoPilotos.actualizar(new Piloto(44, "Sir Lewis Hamilton", 2)));
        System.out.println("actualizar dorsal 99: " + repoPilotos.actualizar(new Piloto(99, "Nadie", 1)));
        System.out.println("eliminar dorsal 55:   " + repoPilotos.eliminar(55));
        System.out.println("eliminar dorsal 77:   " + repoPilotos.eliminar(77));

        System.out.println();
        System.out.println("=== Puntos ===");
        mundial.sumarPuntos(3, 25);
        mundial.sumarPuntos(2, 18);
        mundial.sumarPuntos(1, 15);
        mundial.sumarPuntos(2, 25);

        System.out.println("Clasificacion de constructores:");
        int posicion = 1;
        for (Escuderia e : mundial.clasificacion()) {
            System.out.println("   " + posicion++ + ". " + e);
        }

        System.out.println();
        System.out.println("=== Reglas de negocio ===");
        probarRegla(mundial, new Piloto(5, "", 0), 1);
        probarRegla(mundial, new Piloto(150, "Pepe", 0), 1);
        probarRegla(mundial, new Piloto(14, "Otro", 0), 2);
        probarRegla(mundial, new Piloto(5, "Pepe", 0), 9);
        probarRegla(mundial, new Piloto(63, "George Russell", 0), 2);
        probarRegla(mundial, new Piloto(16, "Charles Leclerc", 0), 1);
        probarRegla(mundial, new Piloto(81, "Oscar Piastri", 0), 1);
    }

    private static void probarRegla(MundialService mundial, Piloto piloto, int idEscuderia)
            throws IOException {
        try {
            mundial.contratar(piloto, idEscuderia);
            System.out.println("   contratado: " + piloto);
        } catch (IllegalArgumentException e) {
            System.out.println("   rechazado: " + e.getMessage());
        }
    }
}
