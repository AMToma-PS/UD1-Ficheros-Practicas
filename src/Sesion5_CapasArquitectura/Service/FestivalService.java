package Sesion5_CapasArquitectura.Service;

import Sesion5_CapasArquitectura.Model.Banda;
import Sesion5_CapasArquitectura.Model.Musico;
import Sesion5_CapasArquitectura.Repository.BandaRepositoryCSV;
import Sesion5_CapasArquitectura.Repository.MusicoRepositoryCSV;

import java.io.IOException;
import java.util.ArrayList;

public class FestivalService {

    private final BandaRepositoryCSV bandaRepository = new BandaRepositoryCSV();
    private final MusicoRepositoryCSV musicoRepository = new MusicoRepositoryCSV();

    public void creaBanda(Banda b) throws IOException {
        bandaRepository.save(b);
    }

    public ArrayList<Banda> listarBandas() throws IOException {
        return bandaRepository.findAll();
    }

    public Banda encuentraBanda(int id) throws IOException {
        Banda encontrada = bandaRepository.findById(id);
        if (encontrada != null) {
            encontrada.setMusicos(musicoRepository.musicosDeLaBanda(id));
        }
        return encontrada;
    }

    public void borraBanda(int id) throws IOException {
        bandaRepository.deleteById(id);
    }

    public void creaMusico(Musico m) throws IOException {
        musicoRepository.save(m);
    }

    public ArrayList<Musico> listarMusicos() throws IOException {
        return musicoRepository.findAll();
    }

    public ArrayList<Musico> listaMusicosBanda(int idBanda) throws IOException {
        return musicoRepository.musicosDeLaBanda(idBanda);
    }

    public void cambiaDeBanda(int idMusico, int idBandaNueva) throws IOException {
        musicoRepository.cambiarBanda(idMusico, idBandaNueva);
    }

    public void borraMusico(int idMusico) throws IOException {
        musicoRepository.deleteById(idMusico);
    }
}
