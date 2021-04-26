package br.com.zupfy.controllers;

import br.com.zupfy.dtos.AlbumDTO;
import br.com.zupfy.dtos.AlbumMusicasDetailDTO;
import br.com.zupfy.dtos.FiltroDeAlbunsDTO;
import br.com.zupfy.models.Album;
import br.com.zupfy.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/albuns/")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @GetMapping("{id}/")
    public AlbumMusicasDetailDTO pesquisarAlbumPorID(@PathVariable int id){
        Album album = albumService.buscarPorId(id);

        return AlbumMusicasDetailDTO.converterModelParaDTO(album);
    }

    //Exemplo de param com DTO para Filtro
    @GetMapping
    public Iterable<AlbumDTO> retornarTodosOsAlbuns(@ModelAttribute FiltroDeAlbunsDTO filtro ){
        Iterable<Album> albuns = albumService.pesquisarTodosOsAlbuns(filtro);
        return AlbumDTO.converterIterableDeModelParaDTO(albuns);
    }

//    Exemplo quando não existe DTO de filtro
//    @GetMapping
//    public Iterable<AlbumDTO> retornarTodosOsAlbuns(@RequestParam( name = "nome",required = false) String nome ){
//        Iterable<Album> albuns = albumService.pesquisarTodosOsAlbuns(nome);
//        return AlbumDTO.converterIterableDeModelParaDTO(albuns);
//    }
}
