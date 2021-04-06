package br.com.zupfy.controllers;

import br.com.zupfy.dtos.AlbumMusicasDetailDTO;
import br.com.zupfy.models.Album;
import br.com.zupfy.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("albuns/")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @GetMapping("{id}/")
    public AlbumMusicasDetailDTO pesquisarAlbumPorID(@PathVariable int id){
        Album album = albumService.buscarPorId(id);

        return AlbumMusicasDetailDTO.converterModelParaDTO(album);
    }
}
