package br.com.andrew.anime.anime.entities;


import br.com.andrew.anime.anime.entities.enums.Gender;

import java.time.LocalDateTime;

public class Character {
    private Long id;
    private String name;
    private LocalDateTime birthDate;
    private Gender gender;

}
