package br.com.andrew.anime.anime.resources;

import br.com.andrew.anime.anime.entities.Anime;
import br.com.andrew.anime.anime.entities.User;
import br.com.andrew.anime.anime.services.AnimeService;
import br.com.andrew.anime.anime.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/anime")
public class AnimeResource {
    @Autowired
    AnimeService service;

    @GetMapping(value = "/{id}") //Indica que a função recebe um parametro no path, exemplo: "site/users/" 1 sendo o
    //parametro e que responde uma requisição do tipo GET
    public ResponseEntity<Anime> findById(@PathVariable Long id) { //@PathVariable -> diz essa variavel vai pegar o valor
        //passado pelo path
        Anime anime = service.findById(id); //findById retorna um User
        return ResponseEntity.ok().body(anime);
        /*
        ok -> codigo HTTP 200 que indica que a requisição foi bem recebida
        body -> retorna um Json contendo as informações do User
         */
    }

    @GetMapping() //Indica que a função responde  uma requisição do tipo GET
    public ResponseEntity<List<Anime>> findAll() {
        List<Anime> list = service.findAll(); //Retorna a lista de todos os usuarios
        return ResponseEntity.ok().body(list);
         /*
        ok -> codigo HTTP 200 que indica que a requisição foi bem recebida
        body -> retorna um Json contendo as informações do User
         */
    }


}
