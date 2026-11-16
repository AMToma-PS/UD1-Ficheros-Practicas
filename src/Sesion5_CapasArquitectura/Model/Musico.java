package Sesion5_CapasArquitectura.Model;

public class Musico {
    private int id;
    private String nombre;
    private int banda;

    public Musico() {}

    public Musico(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Musico(int id, String nombre, int idBanda) {
        this.id = id;
        this.nombre = nombre;
        this.banda = idBanda;
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

    public int getBanda() {
        return banda;
    }

    public void setBanda(int banda) {
        this.banda = banda;
    }

    @Override
    public String toString() {
        return id + "," + nombre + "," + banda;
    }
}
