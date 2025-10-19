package br.com.andrew.anime.anime.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_anime")
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    private Long id;

    @Column(unique = true, nullable = false)
    private String title;

    private String genre;
    private String synopsis;

    /*
    OneToMany = um anime pode ser o favorito de muitos usuarios
    mappedBy = "favoriteAnime" indica que o relacionamento é mapeado pelo atributo favorite
     */

    @OneToMany(mappedBy = "favoriteAnime", fetch = FetchType.LAZY)
    @JsonIgnore //Não inclua esse campo no JSON, evitando loop
    private Set<User> user = new HashSet<>();

    @Transient
    private Set<Character> character = new HashSet<>();

    public Anime(){}

    public Anime(Long id, String title, String genre, String synopsis) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.synopsis = synopsis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Set<Character> getCharacter() {
        return character;
    }

    public Set<User> getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Anime anime = (Anime) o;
        return Objects.equals(id, anime.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
