package Sesion5_CapasArquitectura;

import Sesion5_CapasArquitectura.Model.Equipo;
import Sesion5_CapasArquitectura.Model.Jugador;
import Sesion5_CapasArquitectura.Service.LigaService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainSesion5 {
    public static void main(String[] args) throws IOException {
        File fJugadores = new File("jugadores.csv");
        fJugadores.delete();
        fJugadores.createNewFile();
        File fEquipos = new File("equipos.csv");
        fEquipos.delete();
        fEquipos.createNewFile();

        LigaService eService = new LigaService();

        eService.creaEquipo(new Equipo(1, "Los buenos", 100));
        eService.creaEquipo(new Equipo(2, "Los regulares", 50));
        eService.creaEquipo(new Equipo(3, "Los malos", 10));

        System.out.println("### Busco el equipo id 3 ###");
        System.out.println(eService.encuentraEquipo(3));

        eService.borraEquipo(3);

        System.out.println("### Listo todos los equipos ###");
        for (Equipo e : eService.listarEquipos()) {
            System.out.println(e);
        }

        eService.creaJugador(new Jugador(2, "Sergio", 1));
        eService.creaJugador(new Jugador(7, "jpg7", 1));
        eService.creaJugador(new Jugador(10, "Maria", 2));

        System.out.println("### Todos los jugadores###");
        for (Jugador j : eService.listajugadoresEquipo(1)) {
            System.out.println(j);
        }

        eService.cambiaDeEquipo(7, 2);

        System.out.println("### Todos los jugadores despues de cambioEquipo ###");
        for (Jugador j : eService.listajugadoresEquipo(1)) {
            System.out.println(j);
        }

        eService.borraJugador(7);

        System.out.println("### Todos los jugadores despues de borrado ###");
        for (Jugador j : eService.listajugadoresEquipo(1)) {
            System.out.println(j);
        }
    }
}
