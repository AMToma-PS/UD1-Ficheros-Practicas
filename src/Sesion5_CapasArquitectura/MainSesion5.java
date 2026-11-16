package Sesion5_CapasArquitectura;

import Sesion5_CapasArquitectura.Model.Banda;
import Sesion5_CapasArquitectura.Model.Musico;
import Sesion5_CapasArquitectura.Service.FestivalService;

import java.io.File;
import java.io.IOException;

public class MainSesion5 {
    public static void main(String[] args) throws IOException {
        File fMusicos = new File("musicos.csv");
        fMusicos.delete();
        fMusicos.createNewFile();
        File fBandas = new File("bandas.csv");
        fBandas.delete();
        fBandas.createNewFile();

        FestivalService festival = new FestivalService();

        festival.creaBanda(new Banda(1, "Los Electricos", 1200));
        festival.creaBanda(new Banda(2, "Acustica Norte", 800));
        festival.creaBanda(new Banda(3, "Ruido Blanco", 150));

        System.out.println("### Busco la banda id 3 ###");
        System.out.println(festival.encuentraBanda(3));

        festival.borraBanda(3);

        System.out.println("### Listo todas las bandas ###");
        for (Banda b : festival.listarBandas()) {
            System.out.println(b);
        }

        festival.creaMusico(new Musico(1, "Lucia", 1));
        festival.creaMusico(new Musico(2, "Diego", 1));
        festival.creaMusico(new Musico(3, "Irene", 2));

        System.out.println("### Musicos de la banda 1 ###");
        for (Musico m : festival.listaMusicosBanda(1)) {
            System.out.println(m);
        }

        festival.cambiaDeBanda(2, 2);

        System.out.println("### Musicos de la banda 2 despues del cambio ###");
        for (Musico m : festival.listaMusicosBanda(2)) {
            System.out.println(m);
        }

        festival.borraMusico(2);

        System.out.println("### Todos los musicos despues del borrado ###");
        for (Musico m : festival.listarMusicos()) {
            System.out.println(m);
        }

        Banda banda = festival.encuentraBanda(2);
        System.out.println("### Banda 2 con su formacion ###");
        System.out.println(banda + " -> " + banda.getMusicos().size() + " musicos");
    }
}
