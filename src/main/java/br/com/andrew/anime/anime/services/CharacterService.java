package br.com.andrew.anime.anime.services;
import br.com.andrew.anime.anime.entities.Character;
import br.com.andrew.anime.anime.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {
    @Autowired
    CharacterRepository characterRepository;


    public Character findById(Long id){
        Optional<Character> optionalCharacter = characterRepository.findById(id);
        return optionalCharacter.get();
    }

    public List<br.com.andrew.anime.anime.entities.Character> findAll(){
        return characterRepository.findAll();
    }

    public Character insert(Character character) {
        return characterRepository.save(character);
    }
}
