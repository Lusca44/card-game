package br.com.lucas.entities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lucas.entities.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long>{

}
