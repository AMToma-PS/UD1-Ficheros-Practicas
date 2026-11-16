package Sesion5_CapasArquitectura.mundial.modelo;

public class Piloto {

    private int dorsal;
    private String nombre;
    private int idEscuderia;

    public Piloto() { }

    public Piloto(int dorsal, String nombre, int idEscuderia) {
        this.dorsal = dorsal;
        this.nombre = nombre;
        this.idEscuderia = idEscuderia;
    }

    public int getDorsal() { return dorsal; }
    public void setDorsal(int dorsal) { this.dorsal = dorsal; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getIdEscuderia() { return idEscuderia; }
    public void setIdEscuderia(int idEscuderia) { this.idEscuderia = idEscuderia; }

    @Override
    public String toString() {
        return "#" + dorsal + " " + nombre + " (escuderia " + idEscuderia + ")";
    }
}
