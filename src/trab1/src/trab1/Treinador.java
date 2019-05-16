package trab1;

public class Treinador {
	private String nome;
	private Pokemon[] pokemons;
	private Pokemon pokemonAtual;
	
	public Treinador(String nome, Pokemon[] pokemons) {
		this.nome = nome;
		this.pokemons = pokemons;
	}
	
	public void setPokemonAtual(String pokemon) {
		for (int i = 0; i < pokemons.length; i++) {
			if (pokemons[i].getNome().equals(pokemon)) {
				this.pokemonAtual = pokemons[i];
				return;
			}
		}
		System.out.println("Voce deveria ter informado um pokemon existente");
	}
	public String getNome() {
		return this.nome;
	}
	public Pokemon[] getPokemons() {
		return this.pokemons;
	}
	public Pokemon getPokemonAtual() {
		return this.pokemonAtual;
	}
	
	public String getPokemonsVivos() {
		//verifico qntos estao vivos
		int cont = 0;
		String vivos = "";
		for (int i = 0; i < pokemons.length; i++) {
			if (pokemons[i].getHp() > 0) {
				vivos = vivos + pokemons[i].getNome() + " ";
				i++;
			}
		}
		return vivos;
	}
}
