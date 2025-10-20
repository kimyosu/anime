package br.com.andrew.anime.anime.services;

import br.com.andrew.anime.anime.entities.Anime;
import br.com.andrew.anime.anime.entities.User;
import br.com.andrew.anime.anime.repository.AnimeRepository;
import br.com.andrew.anime.anime.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimeService {
    @Autowired
    AnimeRepository animeRepository;


    public Anime findById(Long id){
        Optional<Anime> optionalAnime = animeRepository.findById(id);
        return optionalAnime.get();
    }

    public List<Anime> findAll(){
        return animeRepository.findAll();
    }

    public Anime insert(Anime anime){
        return animeRepository.save(anime);
    }
}
