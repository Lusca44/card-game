package br.com.lucas.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucas.entities.Card;
import br.com.lucas.entities.repository.CardRepository;

@Service
public class CardService {
	
	@Autowired
	private CardRepository repo;

	public List<Card> findAll(){
		return repo.findAll();
	}
	
	public Card findById(Long id) {
		Optional<Card> card = repo.findById(id);
		if(card.isEmpty()) {
			throw new RuntimeException("Card id not found!");
		}
		return card.get();
	}
	
	public Card create (Card card) {
		return repo.save(card);
	}
	
	public void delete(Long id) {
		repo.delete(this.findById(id));
	}
	
	public void update(Long id, Card obj) {
		Card card = this.findById(id);
		updateData(card,obj);
		repo.save(card);
	}
	
	private void updateData(Card card, Card obj) {
		card.setNome(obj.getNome() != null ? obj.getNome() : card.getNome());
		card.setAtaque(obj.getAtaque() != null ? obj.getAtaque() : card.getAtaque());
		card.setDefesa(obj.getDefesa() != null ? obj.getDefesa() : card.getDefesa());
		card.setClasse(obj.getClasse() != null ? obj.getClasse() : card.getClasse());
		card.setType(obj.getType() != null ? obj.getType() : card.getType());
		card.setDescricao(obj.getDescricao() != null ? obj.getDescricao() : card.getDescricao());
	}
	
}
