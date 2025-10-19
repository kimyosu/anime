package br.com.andrew.anime.anime.config;

import br.com.andrew.anime.anime.entities.Anime;
import br.com.andrew.anime.anime.entities.User;
import br.com.andrew.anime.anime.repository.AnimeRepository;
import br.com.andrew.anime.anime.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AnimeRepository animeRepository;

    @Override
    public void run(String... args) throws Exception {
        Anime anime = new Anime(null, "Code Geass", "Sei lá porra", "É um anime ai");
        User user = new User(null, "Kimy", "KimySysout");
        user.setFavoriteAnime(anime);

        animeRepository.save(anime);
        userRepository.save(user);

    }
}
