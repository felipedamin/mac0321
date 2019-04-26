package trab1;

public class Treinador {
	private String nome;
	private Pokemon[] pokemons;
	private Pokemon pokemonAtual;
	
	public Treinador(String nome, Pokemon[] pokemons) {
		this.nome = nome;
		this.pokemons = pokemons;
	}
	
	public void setPokemonAtual(Pokemon pokemon) {
		this.pokemonAtual = pokemon;
	}
	public String getNome() {
		return nome;
	}
	public Pokemon[] getPokemons() {
		return pokemons;
	}
	public Pokemon getPokemonAtual() {
		return pokemonAtual;
	}
}
