package Sesion5_CapasArquitectura.Repository;

import Sesion5_CapasArquitectura.Model.Equipo;
import Sesion5_CapasArquitectura.Model.Jugador;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class JugadorRepositoryCSV {
    private final String nombreFichero = "jugadores.csv";

    public void save(Jugador j) throws IOException {
        ArrayList<Jugador> jugadoresCargados = cargarCSV();
        jugadoresCargados.add(j);
        guardarCSV(jugadoresCargados);
    }
    public Jugador findById(int dorsal) throws IOException {
        Jugador jEncontrado = new Jugador();
        ArrayList<Jugador> jugadoresCargados = cargarCSV();
        for (Jugador j : jugadoresCargados) {
            if(j.getDorsal() == dorsal)
                jEncontrado = j;
        }
        return jEncontrado;
    }

    public ArrayList<Jugador> findAll() throws IOException {
        ArrayList<Jugador> jugadoresCargados = cargarCSV();
        return jugadoresCargados;
    }

    public ArrayList<Jugador> jugadoresDelEquipo(int idEquipo) throws IOException {
        ArrayList<Jugador> jugadoresEquipo = new ArrayList<>();
        ArrayList<Jugador> jugadoresCargados = cargarCSV();

        for (Jugador j: jugadoresCargados) {
            if(j.getEquipo() == idEquipo)
                jugadoresEquipo.add(j);
        }

        return jugadoresEquipo;
    }

    public void deleteById(int dorsal) throws IOException {
        ArrayList<Jugador> jugadoresCargados = cargarCSV();
        for (Jugador j : jugadoresCargados) {
            if(j.getDorsal() == dorsal)
                jugadoresCargados.remove(j);
        }
        guardarCSV(jugadoresCargados);
    }

    public void cambiarEquipo (int dorsal, int nuevoEquipo) throws IOException {
        ArrayList<Jugador> jugadoresCargados = cargarCSV();
        for (Jugador j : jugadoresCargados) {
            if(j.getDorsal() == dorsal){
                j.setEquipo(nuevoEquipo);
            }
        }
        guardarCSV(jugadoresCargados);
    }

    private ArrayList<Jugador> cargarCSV() throws IOException {
        Scanner sc = new Scanner(new File(nombreFichero));

        ArrayList<Jugador> jugadoresCargados = new ArrayList<>();
        while(sc.hasNextLine()){
            String[] lineaLeida = sc.nextLine().split(",");
            jugadoresCargados.add(new Jugador(
                    Integer.parseInt(lineaLeida[0]),
                    lineaLeida[1],
                    Integer.parseInt(lineaLeida[2])
            ));
        }
        sc.close();
        return jugadoresCargados;
    }

    private void guardarCSV(ArrayList<Jugador> jugadores) throws IOException {
            PrintWriter pw = new PrintWriter(new FileWriter(new File(nombreFichero), false));
            for (Jugador j : jugadores) {
                pw.println(j);
            }
            pw.close();
    }
}
