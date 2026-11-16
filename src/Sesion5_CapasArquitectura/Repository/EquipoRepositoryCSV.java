package Sesion5_CapasArquitectura.Repository;

import Sesion5_CapasArquitectura.Model.Equipo;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EquipoRepositoryCSV {
    private final String nombreFichero = "equipos.csv";

    public void save(Equipo e) throws IOException {
            ArrayList<Equipo> equipos = cargarCSV();
            equipos.add(e);
            guardarCSV(equipos);
    }
    public Equipo findById(int id) throws IOException {
        Equipo equipoEncontrado = new Equipo();
            ArrayList<Equipo> equipos = cargarCSV();
            for (Equipo equipo : equipos) {
                if(equipo.getId() == id) {
                    equipoEncontrado = equipo;
                    return equipoEncontrado;
                }
            }
        return null;
    }

    public ArrayList<Equipo> findAll() throws IOException {
        return cargarCSV();
    }

    public void deleteById(int id) throws IOException {
        ArrayList<Equipo> equipos = cargarCSV();
        for (Equipo equipo : equipos) {
            if(equipo.getId() == id){
                equipos.remove(equipo);
                break;
            }
        }
        guardarCSV(equipos);
    }

    private ArrayList<Equipo> cargarCSV() throws IOException {
        Scanner sc = new Scanner(new File(nombreFichero));

        ArrayList<Equipo> equiposCargados = new ArrayList<>();
        while(sc.hasNextLine()){
            String[] lineaLeida = sc.nextLine().split(",");
            equiposCargados.add(new Equipo(
                    Integer.parseInt(lineaLeida[0]),
                    lineaLeida[1],
                    Integer.parseInt(lineaLeida[2])
            ));
        }
        sc.close();
        return equiposCargados;
    }
    private void guardarCSV(ArrayList<Equipo> equipos) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(new File(nombreFichero), false));
        for (Equipo equipo : equipos) {
            pw.println(equipo);
        }
        pw.close();
    }
}
