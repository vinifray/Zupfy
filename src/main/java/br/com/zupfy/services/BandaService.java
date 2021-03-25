package br.com.zupfy.services;

import br.com.zupfy.models.Banda;
import br.com.zupfy.repositories.BandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

@Service
public class BandaService {

    @Autowired
    private BandaRepository bandaRepository;

    public Banda salvarBanda(Banda banda){
        try{
            Banda obj = bandaRepository.save(banda);
            return banda;
        }catch (Exception error){
            throw new RuntimeException("Objeto já cadastro");
        }
    }

    public List<Banda> retornarTodasAsBandas(){
        List<Banda> bandas = (List<Banda>) bandaRepository.findAll();
        return bandas;
    }

    public Banda buscarBandaPeloId(int id){
        Optional<Banda> optionalBanda = bandaRepository.findById(id);

        if(optionalBanda.isPresent()){
            return optionalBanda.get();
        }

        throw new RuntimeException("Banda não existe");
    }

    public Banda atualizarBanda(Banda banda){
        if (bandaRepository.existsById(banda.getId())){
            Banda objBanda = salvarBanda(banda);
            return objBanda;
        }
        throw new RuntimeException("Banda não existe");
    }

    public Banda atualizarParcialBanda(Banda banda){
        Banda objetoBanda = buscarBandaPeloId(banda.getId());

        if(!objetoBanda.getNome().equals(banda.getNome()) && banda.getNome() != null ){
            objetoBanda.setNome(banda.getNome());
        }

        if (objetoBanda.getNascimento() != banda.getNascimento() && banda.getNascimento() != null){
            objetoBanda.setNascimento(banda.getNascimento());
        }

        return atualizarBanda(objetoBanda);
    }

    public void deletarBanda(int id){
        bandaRepository.deleteById(id);
    }
}
