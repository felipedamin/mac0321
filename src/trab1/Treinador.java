package trab1;

public class Treinador {
	private String nome;
	private Pokemon[] pokemons = new Pokemon[6];
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Pokemon[] getPokemons() {
		return pokemons;
	}
	public void setPokemons(Pokemon[] pokemons) {
		this.pokemons = pokemons;
	}
}
