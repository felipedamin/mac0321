package trab1;

public class Pokemon {
	private double hp;
	private String tipo;
	private String nome;
	private Habilidade[] habilidades;
	
	public Pokemon(String tipo, double hp, String nome, Habilidade[] habilidades) {
		this.tipo = tipo;
		this.nome = nome;
		this.habilidades = habilidades;
		for (int i = 0; i < habilidades.length; i++) {
			habilidades[i].setTipo(this.tipo);
		}
	}
	public double getHp() {
		return hp;
	}
	public void setHp(double hp) {
		this.hp = hp;
	}
	public String getTipo() {
		return tipo;
	}
	public String getNome() {
		return nome;
	}
	public Habilidade[] getHabilidades() {
		return habilidades;
	}
	
}
