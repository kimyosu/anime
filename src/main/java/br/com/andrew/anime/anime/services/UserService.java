package br.com.andrew.anime.anime.services;

import br.com.andrew.anime.anime.entities.User;
import br.com.andrew.anime.anime.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public User findById(Long id){ //Busca Users no banco de dados pelo id
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.get();
    }

    public List<User> findAll(){ //Busca todos os Users do banco de dados
        return userRepository.findAll();
    }

    public User insert(User user){ //Insere um novo User no banco de dados
        return userRepository.save(user);
    }
}
