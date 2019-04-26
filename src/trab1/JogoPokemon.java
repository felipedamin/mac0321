package trab1;

public class JogoPokemon extends Controller{
	
	public void criaJogadores() {
		Habilidade ataqueForte = new Habilidade(5, 2);
		Habilidade ataqueRapido = new Habilidade(2.5, 8);
		Habilidade choqueDoTrovao = new Habilidade(5, 5);
		Habilidade Mordida = new Habilidade(4,6);
		Habilidade tarefaDeMac = new Habilidade(4,6);
		Habilidade trabalhoDeMac = new Habilidade(7,1);
		Habilidade sintaxError = new Habilidade(4.5, 5);
		
		Habilidade[] habPikachu = new Habilidade[4];
		habPikachu[0] = ataqueForte;
		habPikachu[1] = ataqueRapido;
		habPikachu[2] = choqueDoTrovao;
		habPikachu[3] = Mordida;
		
		Habilidade[] habProfessor = new Habilidade[3];
		habProfessor[0] = tarefaDeMac;
		habProfessor[0] = trabalhoDeMac;
		habProfessor[0] = sintaxError;

		Pokemon pikachu = new Pokemon("Eletrico", 30, "Pikachu", habPikachu);	
		Pokemon professor = new Pokemon("Fantasma", 40, "Professor", habProfessor);
		
		Pokemon[] poksJog1 = new Pokemon[1];
		poksJog1[0] = pikachu;
		Pokemon[] poksJog2 = new Pokemon[1];
		poksJog1[0] = professor;
		
		Treinador jogador1 = new Treinador("Nome", poksJog1);
		Treinador jogador2 = new Treinador("Nome", poksJog2);
	}
	
	private class jog1Ataca extends Event {
		public jog1Ataca(long eventTime) {
			super(eventTime);
		}
		public void action() {
			// Put hardware control code here to
			// physically turn off the light.
			light = false;
		}
		public String description() {
			return "Jogador 1 atacou com " + habilidade + " e deu um dano de: " + habilida.dano;
		}
	}

	public static void main(String[] args) {
		
	}

}
