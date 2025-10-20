package br.com.andrew.anime.anime.repository;

import br.com.andrew.anime.anime.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
