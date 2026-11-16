package Sesion5_CapasArquitectura.mundial.modelo;

import java.util.ArrayList;
import java.util.List;

public class Escuderia {

    private int id;
    private String nombre;
    private int puntos;
    private List<Piloto> pilotos = new ArrayList<>();

    public Escuderia() { }

    public Escuderia(int id, String nombre, int puntos) {
        this.id = id;
        this.nombre = nombre;
        this.puntos = puntos;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getPuntos() { return puntos; }
    public void setPuntos(int puntos) { this.puntos = puntos; }

    public List<Piloto> getPilotos() { return pilotos; }
    public void setPilotos(List<Piloto> pilotos) { this.pilotos = pilotos; }

    @Override
    public String toString() {
        return id + ", " + nombre + ", " + puntos + " puntos, pilotos=" + pilotos.size();
    }
}
