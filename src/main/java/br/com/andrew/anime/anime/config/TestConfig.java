package br.com.andrew.anime.anime.config;

import br.com.andrew.anime.anime.entities.Anime;
import br.com.andrew.anime.anime.entities.User;
import br.com.andrew.anime.anime.entities.Character;
import br.com.andrew.anime.anime.entities.enums.Gender;
import br.com.andrew.anime.anime.entities.enums.Genre;
import br.com.andrew.anime.anime.repository.AnimeRepository;
import br.com.andrew.anime.anime.repository.CharacterRepository;
import br.com.andrew.anime.anime.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AnimeRepository animeRepository;
    @Autowired
    CharacterRepository characterRepository;

    @Override
    public void run(String... args) throws Exception {
        Anime anime = new Anime(null, "Code Geass", Genre.DRAMA, Instant.parse("2006-10-05T00:00:00Z"),
                "Príncipe exilado usa poder sobrenacular para comandar rebelião mascarada contra império.");
        Anime anime2 = new Anime(null, "Darker than Black", Genre.FICCAO_CIENTIFICA, Instant.parse("2006-10-05T00:00:00Z"),
                "Em um mundo onde pessoas com poderes especiais surgem, um misterioso contratado conhecido como Hei" +
                        " realiza missões perigosas.");
        Anime anime3 = new Anime(null, "Perfect Blue", Genre.SUSPENSE, Instant.parse("1997-08-01T00:00:00Z"),
                "Uma ex-ídolo pop enfrenta uma crise de identidade e perseguição enquanto tenta se reinventar como atriz.");


        User user = new User(null, "Kimy", "KimySysout");
        User user2 = new User(null, "Likata", "LikataKun");
        User user3 = new User(null, "Ekissu", "Ekissu");

        Character character = new Character(null, "Lelouch Lamperouge", Instant.parse("1999-12-05T00:00:00Z"), Gender.MALE);
        Character character2 = new Character(null, "C.C", null, Gender.MALE);
        Character character3 = new Character(null, "Milly Ashford", Instant.parse("2000-03-15T00:00:00Z"), Gender.FEMALE);
        Character character4 = new Character(null, "Hei", Instant.parse("1985-07-20T00:00:00Z"), Gender.MALE);
        Character character5 = new Character(null, "Mima Kirigoe", Instant.parse("1979-09-10T00:00:00Z"), Gender.FEMALE);
        characterRepository.saveAll(Arrays.asList(character, character2, character3, character4, character5));

        anime.getCharacters().add(character);
        anime.getCharacters().add(character2);
        anime.getCharacters().add(character3);
        anime2.getCharacters().add(character4);
        anime3.getCharacters().add(character5);


        user.setFavoriteAnime(anime);
        user2.setFavoriteAnime(anime2);
        user3.setFavoriteAnime(anime3);

        animeRepository.saveAll(Arrays.asList(anime, anime2, anime3));
        userRepository.saveAll(Arrays.asList(user, user2, user3));
    }
}
