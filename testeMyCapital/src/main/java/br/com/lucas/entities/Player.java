package br.com.lucas.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Player implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Integer vida;

	
	@OneToMany(targetEntity = Card.class)
	private List<Card> cards = new ArrayList<>();

	public Player() {
	}

	public Player(String nome) {
		this.nome = nome;
	}

	@PrePersist
	public void prePersist() {
		this.vida = 30;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getVida() {
		return vida;
	}

	public void setVida(Integer vida) {
		this.vida = vida;
	}

	public void danoRecebido(Integer dano) {
		this.vida -= dano;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void addCards(Card card) {
		cards.add(card);
	}
}
