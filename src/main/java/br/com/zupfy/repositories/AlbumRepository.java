package br.com.zupfy.repositories;

import br.com.zupfy.models.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album, Integer> {
}
