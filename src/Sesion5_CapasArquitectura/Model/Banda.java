package Sesion5_CapasArquitectura.Model;

import java.util.ArrayList;

public class Banda {

    private int id;
    private String nombre;
    private int fans;
    private ArrayList<Musico> musicos = new ArrayList<>();

    public Banda() {}

    public Banda(int id, String nombre, int fans) {
        this.id = id;
        this.nombre = nombre;
        this.fans = fans;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    public ArrayList<Musico> getMusicos() {
        return musicos;
    }

    public void setMusicos(ArrayList<Musico> musicos) {
        this.musicos = musicos;
    }

    public void addMusico(Musico musico) {
        musicos.add(musico);
    }

    @Override
    public String toString() {
        return id + "," + nombre + "," + fans;
    }
}
