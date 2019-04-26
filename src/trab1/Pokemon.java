package trab1;

public class Pokemon {
	private double hp;
	private String tipo;
	private String nome;
	private Habilidade[] habilidades = new Habilidade[4];
	
	public double getHp() {
		return hp;
	}
	public void setHp(double hp) {
		this.hp = hp;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Habilidade[] getHabilidades() {
		return habilidades;
	}
	public void setHabilidades(Habilidade[] habilidades) {
		this.habilidades = habilidades;
		for (int i = 0; i < habilidades.length; i++) {
			habilidades[i].setTipo(this.tipo);
		}
	}
	
}
