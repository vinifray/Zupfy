package br.com.zupfy.repositories;

import br.com.zupfy.models.Album;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AlbumRepository extends CrudRepository<Album, Integer> {

    Iterable<Album> findByNome(String nome);

}
