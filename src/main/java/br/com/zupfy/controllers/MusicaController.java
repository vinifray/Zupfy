package br.com.zupfy.controllers;

import br.com.zupfy.dtos.CadastroDeMusicaDTO;
import br.com.zupfy.models.Musica;
import br.com.zupfy.services.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("musicas/")
public class MusicaController {

    @Autowired
    private MusicaService musicaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Musica registrarMusica(@RequestBody @Valid CadastroDeMusicaDTO musicaDTO){
        Musica musica = musicaDTO.converterDTOParaModel();
        return musicaService.salvarNovaMusica(musica);
    }

    @GetMapping("{id}/")
    public Musica pesquisarPorID(@PathVariable int id){
        return musicaService.buscarPorID(id);
    }

}
