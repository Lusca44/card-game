package br.com.lucas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucas.entities.Card;
import br.com.lucas.entities.Player;
import br.com.lucas.services.PlayerService;

@RestController
@RequestMapping(value = "/players")
public class PlayerController {

	@Autowired
	private PlayerService service;

	@GetMapping
	public ResponseEntity<List<Player>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Player> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}

	@PostMapping
	public ResponseEntity<Player> create(@RequestBody Player player) {
		return ResponseEntity.ok().body(service.create(player));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping(value = "/addCard/{cardId}/inPlayer/{id}")
	public ResponseEntity<Void> addCards(@PathVariable Long id, @PathVariable Long cardId){
		service.addCard(id, cardId);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/getDeck/{id}")
	public ResponseEntity<List<Card>> getDeck(@PathVariable Long id){
		return ResponseEntity.ok().body(service.getDeck(id));
	}

}
