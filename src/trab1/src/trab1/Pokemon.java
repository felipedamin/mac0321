package trab1;

public class Pokemon {
	private double hp;
	private double maxHp;
	private String tipo;
	private String nome;
	private Habilidade[] habilidades;
	
	public Pokemon(String tipo, double hp, String nome, Habilidade[] habilidades) {
		this.tipo = tipo;
		this.nome = nome;
		this.habilidades = habilidades;
		this.hp = hp;
		this.maxHp = hp;
		for (int i = 0; i < habilidades.length; i++) {
			this.habilidades[i].setTipo(this.tipo);
		}
	}
	public double getHp() {
		return this.hp;
	}
	public double getMaxHp() {
		return this.maxHp;
	}
	public void setHp(double hp) {
		this.hp = hp;
	}
	public String getTipo() {
		return this.tipo;
	}
	public String getNome() {
		return this.nome;
	}
	public Habilidade[] getHabilidades() {
		return this.habilidades;
	}
	
}
