package br.com.zupfy.services;

import br.com.zupfy.dtos.FiltroDeAlbunsDTO;
import br.com.zupfy.models.Album;
import br.com.zupfy.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public Album salvarAlbum(Album album){
        Album objetoAlbum = albumRepository.save(album);
        return objetoAlbum;
    }

    public Album buscarPorId(int id){
        Optional<Album> optionalAlbum = albumRepository.findById(id);

        if(optionalAlbum.isPresent()){
            return optionalAlbum.get();
        }

        throw new RuntimeException("Album não existe");
    }

    public Album buscarOuCriarAlbum(Album album){
        if(album.getId() != null){
            album = buscarPorId(album.getId());
        }else {
            album = salvarAlbum(album);
        }

        return album;
    }

    public Iterable<Album> retornarTodosOsAlbuns(){
        return albumRepository.findAll();
    }

    public Iterable<Album> pesquisarTodosOsAlbuns(FiltroDeAlbunsDTO filtro){
        if(filtro.getNome() == null){
            return albumRepository.findAll();
        }
        return albumRepository.findByNome(filtro.getNome());
    }
}
