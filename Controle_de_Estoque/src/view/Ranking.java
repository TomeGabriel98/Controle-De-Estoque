package view;

import javax.swing.JOptionPane;

import controle.Estoque;
import modelo.Produto;

public class Ranking {
	public Ranking(Estoque estoque) {
		Produto produto = estoque.produtoMaisVendido();
		int valor = produto.getQuantidadeVendida();
		
		JOptionPane.showMessageDialog(null, "Produto que mais vendeu.\n" + "\nNome: " 
				+ produto.getNome() + "\nPre�o: " + produto.getPreco() + "\nQuant. Dispon�vel: " 
				+ produto.getQuantidade() + "\nTotal Vendido: " + valor + "\nOpini�es: " 
				+ produto.getComentario());
	}

}
