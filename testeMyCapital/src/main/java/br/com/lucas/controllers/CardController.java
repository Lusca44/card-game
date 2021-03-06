package br.com.lucas.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucas.entities.Card;
import br.com.lucas.services.CardService;

@RestController
@RequestMapping(value = "/cards")
public class CardController {

	@Autowired
	private CardService service;

	@GetMapping
	public ResponseEntity<List<Card>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Card> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}

	@GetMapping(value = "/byName")
	public ResponseEntity<List<Card>> findByName(@PathParam(value = "name") String name) {
		List<Card> cards = service.findAll();
		List<Card> cardByName = new ArrayList<>();
		for(Card card : cards) {
			if(card.getNome().contains(name)) {
				cardByName.add(card);
			}
		}
		return ResponseEntity.ok().body(cardByName);
	}

	@GetMapping(value = "/byClass")
	public ResponseEntity<List<Card>> findByClass(@PathParam(value = "classe") String classe) {
		List<Card> cards = service.findAll();
		List<Card> cardByClasse = new ArrayList<>();
		for(Card card : cards) {
			if(card.getNome().contains(classe)) {
				cardByClasse.add(card);
			}
		}
		return ResponseEntity.ok().body(cardByClasse);
	}
	
	@GetMapping(value = "/byType")
	public ResponseEntity<List<Card>> findByType(@PathParam(value = "type") String type) {
		List<Card> cards = service.findAll();
		List<Card> cardByType = new ArrayList<>();
		for(Card card : cards) {
			if(card.getNome().contains(type)) {
				cardByType.add(card);
			}
		}
		return ResponseEntity.ok().body(cardByType);
	}

	@PostMapping
	public ResponseEntity<Card> create(@RequestBody Card card) {
		return ResponseEntity.ok().body(service.create(card));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Card obj) {
		service.update(id, obj);
		return ResponseEntity.noContent().build();
	}

}
