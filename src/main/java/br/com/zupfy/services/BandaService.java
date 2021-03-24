package br.com.zupfy.services;

import br.com.zupfy.models.Banda;
import br.com.zupfy.repositories.BandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BandaService {

    @Autowired
    private BandaRepository bandaRepository;

    public Banda salvarBanda(Banda banda){
        return bandaRepository.save(banda);
    }
}
