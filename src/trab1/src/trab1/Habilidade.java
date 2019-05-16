package trab1;
public class Habilidade {
	private String tipo;
	private String nome;
	private double dano;
	private int prioridade;
	
	public Habilidade(double dano, int prioridade, String nome) {
		this.dano = dano;
		this.prioridade = prioridade;
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}
	public int getPrioridade() {
		return this.prioridade;
	}
	public String getTipo() {
		return this.tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getDano() {
		return this.dano;
	}
	
}
