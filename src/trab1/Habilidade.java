package trab1;
public class Habilidade {
	private String tipo;
	private double dano;
	private int prioridade;
	
	public Habilidade(double dano, int prioridade) {
		this.dano = dano;
		this.prioridade = prioridade;
	}
	
	public int getPrioridade() {
		return prioridade;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getDano() {
		return dano;
	}
	
}
