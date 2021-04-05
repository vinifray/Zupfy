package br.com.zupfy.services;

import br.com.zupfy.models.Banda;
import br.com.zupfy.models.Musica;
import br.com.zupfy.repositories.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MusicaService {

    @Autowired
    private MusicaRepository musicaRepository;

    @Autowired
    private BandaService bandaService;

    public Musica salvarMuscia(Musica musica){
        Musica objetoMusica = musicaRepository.save(musica);
        return objetoMusica;
    }

    public Musica buscarPorID(int id){
        Optional<Musica> optionalMusica = musicaRepository.findById(id);

        if(optionalMusica.isPresent()){
            return optionalMusica.get();
        }

        throw new RuntimeException("Objeto não encontrado");
    }

    public Musica salvarNovaMusica(Musica musica){
        Banda banda = bandaService.buscarBandaPeloId(musica.getBanda().getId());
        musica.setBanda(banda);

        return salvarMuscia(musica);
    }
}
