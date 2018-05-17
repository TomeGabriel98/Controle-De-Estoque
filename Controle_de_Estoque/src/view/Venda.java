package view;

import java.util.List;

import javax.swing.JOptionPane;

import controle.Estoque;
import modelo.Produto;

public class Venda {
	public Venda(Estoque estoque){
		int codigo = 0;
		
		try {
			codigo = Integer.parseInt(JOptionPane.showInputDialog("C�digo do Produto: "));
		} catch(Exception NumberFormatException){
			JOptionPane.showMessageDialog(null, "Digite um valor v�lido!");
		}
		
		if(estoque.buscaProduto(codigo) == false)
			JOptionPane.showMessageDialog(null, "Produto n�o encontrado.");
		else {
			int quantidadeDisponivel = estoque.quantidadeDisponivel(codigo);
			List<Produto> produtos = estoque.imprimirEstoque();
			
			for (Produto produto : produtos) {
				if(codigo == produto.getCodigo()) {
					JOptionPane.showMessageDialog(null, "Nome: " + produto.getNome() + "\nPre�o: "
							+ produto.getPreco() + "\nQuant. Dispon�vel: " 
							+ produto.getQuantidade());
					int quantidadeVenda = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de Venda: "));
					
					if(quantidadeVenda > quantidadeDisponivel)
						JOptionPane.showMessageDialog(null, "Quantidade n�o dispon�vel!");
					else {
						estoque.venda(codigo, quantidadeVenda);
						int resposta = JOptionPane.showConfirmDialog(null, "Deseja adicionar um coment�rio?",
								"Opini�o", JOptionPane.YES_NO_OPTION);
						
						if(resposta == JOptionPane.YES_NO_OPTION) {
							String comentario = JOptionPane.showInputDialog("");
							
							if(codigo == produto.getCodigo()) produto.setComentario(comentario);
						}
						
						JOptionPane.showMessageDialog(null, "Produto vendido!");
					}
				}
			}
		}
	}
}
