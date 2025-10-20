package br.com.andrew.anime.anime.resources;

import br.com.andrew.anime.anime.entities.Character;
import br.com.andrew.anime.anime.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/character")
public class CharacterResource {
    @Autowired
    CharacterService service;

    @GetMapping(value = "/{id}") //Indica que a função recebe um parametro no path, exemplo: "site/users/" 1 sendo o
    //parametro e que responde uma requisição do tipo GET
    public ResponseEntity<Character> findById(@PathVariable Long id) { //@PathVariable -> diz essa variavel vai pegar o valor
        //passado pelo path
        Character character = service.findById(id); //findById retorna um User
        return ResponseEntity.ok().body(character);
        /*
        ok -> codigo HTTP 200 que indica que a requisição foi bem recebida
        body -> retorna um Json contendo as informações do User
         */
    }

    @GetMapping() //Indica que a função responde  uma requisição do tipo GET
    public ResponseEntity<List<Character>> findAll() {
        List<Character> list = service.findAll(); //Retorna a lista de todos os usuarios
        return ResponseEntity.ok().body(list);
         /*
        ok -> codigo HTTP 200 que indica que a requisição foi bem recebida
        body -> retorna um Json contendo as informações do User
         */
    }

    @PostMapping
    public ResponseEntity<Character> insert(Character character){
        Character obj = service.insert(character);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(uri).body(obj);
    }


}
