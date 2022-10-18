package dao;

import java.util.LinkedList;

import model.Produto;

public class Produto_DAO {

	private LinkedList<Produto> listProduto;

	public Produto_DAO() {
		super();
		this.listProduto = new LinkedList<Produto>();
	}
	
	public void add(Produto produto) {
		if(this.listProduto.contains(produto)) {
			System.out.println("Esse produto já foi cadastrado");
		}
		this.listProduto.add(produto);
	}
	
	public void imprimirLista() {
		for(int i = 0; i < this.listProduto.size(); i++) {
			System.out.println(this.listProduto.get(i).getNome());
			System.out.println(this.listProduto.get(i).getPreco());
			System.out.println(this.listProduto.get(i).getPrecoComAliquota());
		}
	}
}