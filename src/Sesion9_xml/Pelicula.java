package Sesion9_xml;

public class Pelicula {

    private int id;
    private String titulo;
    private int anio;

    public Pelicula(int id, String titulo, int anio) {
        this.id = id;
        this.titulo = titulo;
        this.anio = anio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Pelicula{id=" + id + ", titulo='" + titulo + "', anio=" + anio + "}";
    }
}
