package view;

import java.util.List;

import javax.swing.JOptionPane;

import controle.Estoque;
import modelo.Produto;

public class Recomendacao {
	public Recomendacao(Estoque estoque) {
		List<Produto> produtos = estoque.imprimirEstoque();
		boolean quantidadeMinima = true;
		
		for (Produto produto : produtos) {
			if(produto.getQuantidade() < 10) {
				JOptionPane.showMessageDialog(null, "Produto " + produto.getNome() 
					+ " está em falta! Compre mais.\nApenas " + produto.getQuantidade() 
					+ " em estoque!");
				quantidadeMinima = false;
			}
		}
		
		if(quantidadeMinima) JOptionPane.showMessageDialog(null, "Nenhum produto em falta!");
	}

}
