package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import dao.Produto_DAO;
import model.Produto;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket;
		InputStream canalEntrada;
		OutputStream canalSaida;
		BufferedReader entrada;
		PrintWriter saida;
		
		try {
			socket = new Socket("127.0.0.1", 4000);
			
			canalEntrada = socket.getInputStream();
			canalSaida = socket.getOutputStream();

			entrada = new BufferedReader(new InputStreamReader(canalEntrada));
			saida = new PrintWriter(canalSaida, true);
			
			Scanner scan = new Scanner(System.in);
			
			boolean continuar = true;
			Produto_DAO produtoDAO = new Produto_DAO();
			Produto produto;
			
			while(continuar) {
				System.out.println("1 - Cadatrar Produto");
				System.out.println("2 - Lista Produto");
				
				String opcao = scan.nextLine();
				
				if(opcao.equals("1")) {
					System.out.println("Nome do Produto:");
					String nome = scan.nextLine();
					
					System.out.println("Preço do Produto:");
					Double preco = scan.nextDouble();
					
					saida.println(nome);
					
					String aliquotaString = entrada.readLine();
					Double aliquota = Double.parseDouble(aliquotaString);
					
					Double valorAliquota = preco + (preco * (aliquota / 100));
					
					produto = new Produto(nome, preco, valorAliquota);
					produtoDAO.add(produto);
					
										
				} else if (opcao.equals("2")) {
					produtoDAO.imprimirLista();
				}
				
				System.out.println("Deseja Continuar? (S/N) ");
				String resposta = scan.nextLine();
				
				if(resposta.equals("N")) {
					continuar = false;
				} 
			}
			socket.close();
			scan.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}