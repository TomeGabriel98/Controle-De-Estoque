package view;

import java.util.List;

import javax.swing.JOptionPane;

import controle.Estoque;
import modelo.Produto;

public class Consulta {
	public void atualizarQuantidade(Estoque estoque) {
		int codigo = Integer.parseInt(JOptionPane.showInputDialog("Código do Produto: "));
		int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade nova: "));
		
		estoque.atualizarQuantidade(codigo, quantidade);
	}
	
	public void imprimirEstoque(Estoque estoque) {
		List<Produto> produtos = estoque.imprimirEstoque();
		
		for (Produto produto : produtos) {
			JOptionPane.showMessageDialog(null, "Nome: " + produto.getNome() + "\nPreço: " 
					+ produto.getPreco() + "\nQuant. Disponível: " + produto.getQuantidade() 
					+ "\nQuant. Vendida: " + produto.getQuantidadeVendida() + "\nOpiniões: " 
					+ produto.getComentario());
		}
	}

}
