package br.com.lucas.entities.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucas.entities.Player;

public interface PlayerRepository extends JpaRepository<Player, Long>{

}
