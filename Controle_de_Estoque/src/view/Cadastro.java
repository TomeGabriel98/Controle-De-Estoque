package view;

import javax.swing.JOptionPane;

import controle.Estoque;
import modelo.Produto;

public class Cadastro {
	public Cadastro(Estoque estoque) {
		int ultimoCodigo = estoque.buscarCodigo();
		int codigo = ultimoCodigo + 1;
		Produto produto = new Produto();
		
		//Integer.parseInt(JOptionPane.showInputDialog("Código: "));
		produto.setCodigo(codigo);
		JOptionPane.showMessageDialog(null, "Código: " + codigo);
		produto.setNome(JOptionPane.showInputDialog("Nome: "));
		produto.setPreco(Double.parseDouble(JOptionPane.showInputDialog("Preço: ")));
		produto.setQuantidade(Integer.parseInt(JOptionPane.showInputDialog("Quantidade: ")));
		
		estoque.inserirProduto(produto);
		codigo++;
	}

}
