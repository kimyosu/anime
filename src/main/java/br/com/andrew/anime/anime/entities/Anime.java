package br.com.andrew.anime.anime.entities;

import br.com.andrew.anime.anime.entities.enums.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_anime")
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    private Long id;

    @Column(unique = true, nullable = false) //Indica que o titulo é unico e nao pode ser nulo
    private String title;

    private Instant releaseDate;

    private Genre genres;

    private String synopsis;

    /*
    OneToMany = um anime pode ser o favorito de muitos usuarios
    mappedBy = "favoriteAnime" indica que o relacionamento é mapeado pelo atributo favorite
     */

    @JsonIgnore
    @OneToMany(mappedBy = "favoriteAnime")
    private Set<User> user = new HashSet<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "tb_anime_character",
            joinColumns = @JoinColumn(name = "anime_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id"))
    private Set<Character> characters = new HashSet<>();

    public Anime() {
    }

    public Anime(Long id, String title, Genre genres, Instant releaseDate, String synopsis) {
        this.id = id;
        this.title = title;
        this.genres = genres;
        this.synopsis = synopsis;
        this.releaseDate = releaseDate;
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

    public Genre getGenres() {
        return genres;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }


    public Instant getReleaseDate() {
        return releaseDate;
    }

    public Set<User> getUser() {
        return user;
    }

    public Set<Character> getCharacters() {
        return characters;
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
