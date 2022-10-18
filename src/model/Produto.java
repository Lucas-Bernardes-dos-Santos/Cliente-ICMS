package model;

public class Produto {

	private String nome;
	private Double preco;
	private Double precoComAliquota;
	
	public Produto(String nome, Double preco, Double precoComAliquota) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.precoComAliquota = precoComAliquota;
	}

	// Getters and Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getPrecoComAliquota() {
		return precoComAliquota;
	}
	public void setPrecoComAliquota(Double precoComAliquota) {
		this.precoComAliquota = precoComAliquota;
	}	
}