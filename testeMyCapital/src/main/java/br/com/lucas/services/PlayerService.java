package br.com.lucas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucas.entities.Card;
import br.com.lucas.entities.Player;
import br.com.lucas.entities.repository.CardRepository;
import br.com.lucas.entities.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository repo;

	@Autowired
	private CardRepository cardRepo;

	public List<Player> findAll() {
		return repo.findAll();
	}

	public Player findById(Long id) {
		Optional<Player> player = repo.findById(id);
		if (player.isEmpty()) {
			throw new RuntimeException("Player id not found");
		}
		return player.get();
	}

	public Player create(Player player) {
		return repo.save(player);
	}

	public void delete(Long id) {
		repo.delete(this.findById(id));
	}

	public void update(Long id, Player obj) {
		Player player = this.findById(id);
		updateData(player, obj);
		repo.save(player);
	}

	public void danoRecebido(Long id, Integer dano) {
		Player player = this.findById(id);
		player.danoRecebido(dano);
		repo.save(player);
	}

	public void addCard(Long id, Long cardId) {
		Player player = this.findById(id);
		Optional<Card> card = cardRepo.findById(cardId);
		player.addCards(card.get());
		repo.save(player);
	}

	public List<Card> getDeck(Long id) {
		Player player = findById(id);
		return player.getCards();
	}

	private void updateData(Player player, Player obj) {
		player.setNome(obj.getNome() != null ? obj.getNome() : player.getNome());
	}

	private Boolean limiteDuasCartas(Card card, Player player) {
		int contador = 0;
		for (Card obj : player.getCards()) {
			if (obj.getId() == card.getId()) {
				contador++;
				if (contador >= 2) {
					return false;
				}
			}
		}
		return true;
	}

}
