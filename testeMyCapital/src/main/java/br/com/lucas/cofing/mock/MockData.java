package br.com.lucas.cofing.mock;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.lucas.entities.Card;
import br.com.lucas.entities.Player;
import br.com.lucas.entities.repository.CardRepository;
import br.com.lucas.entities.repository.PlayerRepository;
import br.com.lucas.typesEnum.Classes;
import br.com.lucas.typesEnum.Types;

@Configuration
public class MockData implements CommandLineRunner{

	@Autowired
	private CardRepository cardRepo;

	@Autowired
	private PlayerRepository playerRepo;
	
	
	@Override
	public void run(String... args) throws Exception {
	
		Player p1 = new Player("Lucas");
		Player p2 = new Player("Pedro");
		
		Card c1 = new Card("Dragão de Berin", "Ataque aéreo", 5, 3, Types.CRIATURA, Classes.PALADINO);
		Card c2 = new Card("Globin verde", "Ataque terrestre", 5, 3, Types.CRIATURA, Classes.QUALQUER);
		Card c3 = new Card("Lasquinha", "Ataque subterraneo", 5, 3, Types.CRIATURA, Classes.CAÇADOR);
		Card c4 = new Card("Dente de sabre", "Ataque terrestre", 5, 3, Types.CRIATURA, Classes.DRUIDA);
		Card c5 = new Card("Mago", "Ataque magico", 5, 3, Types.CRIATURA, Classes.MAGO);
		Card c6 = new Card("Anula magia", "Magia de anulação", 5, 3, Types.MAGIA, Classes.QUALQUER);
		Card c7 = new Card("Raposa infernal", "Ataque terrestre", 5, 3, Types.CRIATURA, Classes.CAÇADOR);
		Card c8 = new Card("Bola  de fogo", "Magia de ataque", 5, 3, Types.MAGIA, Classes.QUALQUER);
		Card c9 = new Card("Enxurrada de flechas", "Magia de ataque", 5, 3, Types.MAGIA, Classes.QUALQUER);
		Card c10 = new Card("Dado da sorte", "Magia de regeneração de vida", 5, 3, Types.MAGIA, Classes.QUALQUER);
		Card c11 = new Card("Elixir da vida", "Magia de regeneração de vida", 5, 3, Types.MAGIA, Classes.QUALQUER);
		Card c12 = new Card("Cão sarnento", "Ataque terrestre", 5, 3, Types.CRIATURA, Classes.DRUIDA);
		Card c13 = new Card("Chamuscada", "Ataque aéreo", 5, 3, Types.CRIATURA, Classes.DRUIDA);
		Card c14 = new Card("Leão sombrio", "Ataque terrestre", 5, 3, Types.CRIATURA, Classes.DRUIDA);
		Card c15 = new Card("Cavaleiro Morto vivo", "Ataque terrestre", 5, 3, Types.CRIATURA, Classes.CAÇADOR);
		Card c16 = new Card("Espadachin envenenado", "Ataque terrestre", 5, 3, Types.CRIATURA, Classes.CAÇADOR);
		Card c17 = new Card("Dr Criação", "Ataque terrestre", 5, 3, Types.CRIATURA, Classes.MAGO);
		Card c18 = new Card("Agora é meu!", "Magia de toma de posse", 5, 3, Types.MAGIA, Classes.QUALQUER);
		Card c19 = new Card("Serpente alada", "Ataque aéreo", 5, 3, Types.CRIATURA, Classes.CAÇADOR);
		Card c20 = new Card("Agua divina", "Magia de regeneração de vida", 5, 3, Types.MAGIA, Classes.QUALQUER);
		Card c21 = new Card("Sapo venenoso", "Ataque terrestre", 5, 3, Types.CRIATURA, Classes.CAÇADOR);
		Card c22 = new Card("Aranha negra", "Ataque aéreo", 5, 3, Types.CRIATURA, Classes.CAÇADOR);
		Card c23 = new Card("Arcanjo selestial", "Ataque aéreo", 5, 3, Types.CRIATURA, Classes.QUALQUER);
		Card c24 = new Card("Jack o estripador", "Ataque terrestre", 5, 3, Types.CRIATURA, Classes.PALADINO);
		Card c25 = new Card("Arvore do fruto divino", "Magia de regeneração de vida", 5, 3, Types.MAGIA, Classes.QUALQUER);
		
		
		cardRepo.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,
				c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25));
		
		p1.addCards(c1);
		
		playerRepo.saveAll(Arrays.asList(p1,p2));
	}
	
	

}
