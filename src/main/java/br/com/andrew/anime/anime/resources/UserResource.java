package br.com.andrew.anime.anime.resources;

import br.com.andrew.anime.anime.entities.User;
import br.com.andrew.anime.anime.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    UserService service;

    @GetMapping(value = "/{id}") //Indica que a função recebe um parametro no path, exemplo: "site/users/" 1 sendo o
        //parametro
    public ResponseEntity<User> findById(@PathVariable Long id){ //@PathVariable -> diz essa variavel vai pegar o valor
            //passado pelo path
        User user = service.findById(id); //findById retorna um User
        return ResponseEntity.ok().body(user);
        /*
        ok -> codigo HTTP 200 que indica que a requisição foi bem recebida
        body -> retorna um Json contendo as informações do User
         */
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }


}
