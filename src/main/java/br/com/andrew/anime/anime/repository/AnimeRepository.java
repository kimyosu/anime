package br.com.andrew.anime.anime.repository;

import br.com.andrew.anime.anime.entities.Anime;
import br.com.andrew.anime.anime.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {

}
