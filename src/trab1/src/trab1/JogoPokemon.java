package trab1;
import java.util.Scanner;

public class JogoPokemon extends Controller{
	Treinador jogador1;
	Treinador jogador2;
	Habilidade hab1;
	Habilidade hab2;
	
	public JogoPokemon() {
		this.criaJogadores();
	}
	
	public void criaJogadores() {
		Habilidade ataqueForte = new Habilidade(5, 8, "ataque forte");
		Habilidade ataqueRapido = new Habilidade(2.5, 2, "ataque rapido");
		Habilidade choqueDoTrovao = new Habilidade(5, 5, "choque do trovao");
		Habilidade Mordida = new Habilidade(4,4, "mordida");
		Habilidade tarefaDeMac = new Habilidade(4,4, "tarefa de MAC");
		Habilidade trabalhoDeMac = new Habilidade(7,9, "trabalho de MAC");
		Habilidade sintaxError = new Habilidade(4.5, 5, "Syntax Error");
		
		Habilidade[] habPikachu = new Habilidade[4];
		habPikachu[0] = ataqueForte;
		habPikachu[1] = ataqueRapido;
		habPikachu[2] = choqueDoTrovao;
		habPikachu[3] = Mordida;
		
		Habilidade[] habProfessor = new Habilidade[3];
		habProfessor[0] = tarefaDeMac;
		habProfessor[1] = trabalhoDeMac;
		habProfessor[2] = sintaxError;

		Pokemon pikachu = new Pokemon("Eletrico", 30, "Pikachu", habPikachu);	
		Pokemon professor = new Pokemon("Fantasma", 40, "Professor", habProfessor);
		
		Pokemon[] poksJog1 = new Pokemon[1];
		poksJog1[0] = pikachu;
		Pokemon[] poksJog2 = new Pokemon[1];
		poksJog2[0] = professor;
		
		this.jogador1 = new Treinador("Nome", poksJog1);
		this.jogador2 = new Treinador("Nome", poksJog2);
	}

	public static void main(String[] args) {
		JogoPokemon jogo = new JogoPokemon();
		jogo.partida();
	}
	
	public void partida() {
		boolean acabou = false;
		Scanner ler = new Scanner(System.in);
		String acao1;
		String acao2;
		
		System.out.println("Jogador 1, escolha seu pokemon inicial:");
		System.out.println(jogador1.getPokemonsVivos());
		String pokemon1 = ler.nextLine();
		jogador1.setPokemonAtual(pokemon1);
		
		System.out.println("Jogador 2, escolha seu pokemon inicial:");
		System.out.println(jogador2.getPokemonsVivos());
		String pokemon2 = ler.nextLine();
		jogador2.setPokemonAtual(pokemon2);
		
		while (!acabou) {	
			ler.nextLine();
			System.out.println("Pokemon do Jogador 1: " + jogador1.getPokemonAtual().getNome());
			System.out.println("HP: " + jogador1.getPokemonAtual().getHp());
			System.out.println("Jogador 1 digite sua ação: ('fugir', 'trocar', 'item' ou 'ataque')");
			acao1 = ler.nextLine();
			
			System.out.println("Pokemon do Jogador 2 " + jogador2.getPokemonAtual().getNome());
			System.out.println("HP: " + jogador2.getPokemonAtual().getHp());
			System.out.println("Jogador 2 digite sua ação: ('fugir', 'trocar', 'item' ou 'ataque')");
			acao2 = ler.nextLine();
			
			if ("fugir".equalsIgnoreCase(acao1)) {
				acabou = true;
				System.out.println("O Jogador 1 fugiu.\nJogador 2 ganhou!");
				break;
			}
			if ("fugir".equalsIgnoreCase(acao2)) {
				acabou = true;
				System.out.println("O Jogador 2 fugiu.\nJogador 1 ganhou!");
				break;
			}
			
			if ("trocar".equalsIgnoreCase(acao1)) {
				System.out.println("Jogador 1, escolha seu pokemon");
				System.out.println(jogador1.getPokemonsVivos());
				String pokemon = ler.nextLine();
				this.troca(jogador1, pokemon);
			}
			if ("trocar".equalsIgnoreCase(acao2)) {
				System.out.println("Jogador 2, escolha seu pokemon");
				System.out.println(jogador2.getPokemonsVivos());
				String pokemon = ler.nextLine();
				this.troca(jogador2, pokemon);
			}
			
			if ("item".equalsIgnoreCase(acao1)) {
				System.out.println("Jogador 1, escolha seu item (pelo numero)");
				System.out.println("Itens:\n1) Poção de HP: 8");
				String numItem = ler.nextLine();
				if (numItem.equals("1")) {
					this.cura(jogador1.getPokemonAtual(), 8);
				}
			}
			if ("item".equalsIgnoreCase(acao2)) {
				System.out.println("Jogador 2, escolha seu item");
				System.out.println("Itens:\n1) Poção de HP: 40");
				String numItem = ler.nextLine();
				if (numItem.equals("1")) {
					this.cura(jogador2.getPokemonAtual(), 40);
				}
			}
			
			boolean ataque1 = false;
			boolean ataque2 = false;
			if ("ataque".equalsIgnoreCase(acao1)) {
				System.out.println("Jogador 1 escolha a habilidade que deseja usar (digite o numero dela)");
				Habilidade[] hab1 = jogador1.getPokemonAtual().getHabilidades();
				for (int i = 0; i < hab1.length; i++) {
					System.out.print(i + ") " + hab1[i].getNome() + ", ");
				}
				ataque1 = true;
				int escolhida1 = ler.nextInt();
				this.hab1 = jogador1.getPokemonAtual().getHabilidades()[escolhida1];
			}
			
			if ("ataque".equalsIgnoreCase(acao2)) {
				System.out.println("Jogador 2 escolha a habilidade que deseja usar (digite o numero dela)");
				Habilidade[] hab2 = jogador2.getPokemonAtual().getHabilidades();
				for (int i = 0; i < hab2.length; i++) {
					System.out.print(i + ") " + hab2[i].getNome() + ", ");
				}
				ataque2 = true;
				int escolhida2 = ler.nextInt();
				this.hab2 = jogador2.getPokemonAtual().getHabilidades()[escolhida2];
				//
			}
			
			if (ataque1 && ataque2) {
				if (this.hab2.getPrioridade() < this.hab1.getPrioridade()) {
					jogAtaca jog2Ataca = new jogAtaca(System.currentTimeMillis(), hab2, jogador1);
					jog2Ataca.action();
					System.out.println(jog2Ataca.description());
					
					if (jogador1.getPokemonAtual().getHp() > 0) {
						jogAtaca jog1Ataca = new jogAtaca(System.currentTimeMillis(), hab1, jogador2);
						jog1Ataca.action();
						System.out.println(jog1Ataca.description());
						if (jogador2.getPokemonAtual().getHp() <= 0) {
							System.out.println("Jogador 2, seu pokemon morreu! escolha outro:");
							System.out.println(jogador2.getPokemonsVivos());
							String pokemon = ler.nextLine();
							this.troca(jogador2, pokemon);
						}
					}
					else {
						System.out.println("Jogador 1, seu pokemon morreu! escolha outro:");
						System.out.println(jogador1.getPokemonsVivos());
						String pokemon = ler.nextLine();
						this.troca(jogador1, pokemon);
						ler.nextLine(); 
					}
				}
				else {
					jogAtaca jog1Ataca = new jogAtaca(System.currentTimeMillis(), hab1, jogador2);
					jog1Ataca.action();
					System.out.println(jog1Ataca.description());
					
					if (jogador2.getPokemonAtual().getHp() > 0) {
						jogAtaca jog2Ataca = new jogAtaca(System.currentTimeMillis(), hab2, jogador1);
						jog2Ataca.action();
						System.out.println(jog2Ataca.description());
						if (jogador1.getPokemonAtual().getHp() <= 0) {
							System.out.println("Jogador 1, seu pokemon morreu! escolha outro:");
							System.out.println(jogador1.getPokemonsVivos());
							String pokemon = ler.nextLine();
							this.troca(jogador1, pokemon);
						}
					}
					else {
						System.out.println("Jogador 2, seu pokemon morreu! escolha outro:");
						System.out.println(jogador2.getPokemonsVivos());
						String pokemon = ler.nextLine();
						this.troca(jogador2, pokemon);
						ler.nextLine(); 
					}
				}
			}
			
			else if (ataque1) {
				jogAtaca jog1Ataca = new jogAtaca(System.currentTimeMillis(), hab1, jogador2);
				jog1Ataca.action();
				System.out.println(jog1Ataca.description());
				if (jogador2.getPokemonAtual().getHp() <= 0) {
					System.out.println("Jogador 2, seu pokemon morreu! escolha outro:");
					System.out.println(jogador2.getPokemonsVivos());
					String pokemon = ler.nextLine();
					this.troca(jogador2, pokemon);
				}
			}
			
			else if (ataque2) {
				jogAtaca jog2Ataca = new jogAtaca(System.currentTimeMillis(), hab2, jogador1);
				jog2Ataca.action();
				System.out.println(jog2Ataca.description());
				if (jogador1.getPokemonAtual().getHp() <= 0) {
					System.out.println("Jogador 1, seu pokemon morreu! escolha outro:");
					System.out.println(jogador1.getPokemonsVivos());
					String pokemon = ler.nextLine();
					this.troca(jogador1, pokemon);
				}
			}
			
			if (perdeu(jogador1)) {
				acabou = true;
				System.out.println("O jogador 1 perdeu! (todos seus pokemons morreram)");
				break;
			}
			if (perdeu(jogador2)) {
				acabou = true;
				System.out.println("O jogador 2 perdeu! (todos seus pokemons morreram)");
				break;
			}
		}		
	}
	
	private class jogAtaca extends Event {
		Habilidade hab;
		Treinador apanha;
		public jogAtaca(long eventTime, Habilidade habilidade, Treinador outro) {
			super(eventTime);
			hab = habilidade;
			apanha = outro;
		}
		public void action() {
			Double hp = apanha.getPokemonAtual().getHp();
			apanha.getPokemonAtual().setHp(hp - hab.getDano());
		}
		public String description() {
			return "Jogador 1 atacou com " + hab.getNome() + " e deu um dano de: " + hab.getDano();
		}
	}
	
	private void cura(Pokemon pok, int pontos) {
		//restaura o HP de pok em tantos pontos de vida;
		double hp = pok.getHp();
		if (hp + pontos < pok.getMaxHp()) {
			pok.setHp(hp + pontos);			
		}
		else {
			pok.setHp(pok.getMaxHp());
		}
	}
	
	private void troca(Treinador treinador, String pok) {
		for (int i = 0; i < treinador.getPokemons().length; i++) {
			if (treinador.getPokemons()[i].getNome().equals(pok)) {
				double hp = treinador.getPokemons()[i].getHp();
				if (hp > 0) {
					treinador.setPokemonAtual(pok);
				}
				else {
					System.out.println("O pokemon escolhido já está morto");
				}
			}
		}
	}
	
	private boolean perdeu(Treinador treinador) {
		//verifica se o treinador perdeu
		for (int i = 0; i < treinador.getPokemons().length; i++) {
			if (treinador.getPokemons()[i].getHp() > 0) {
				return false;
			}
		}
		return true;
	}
	
}
