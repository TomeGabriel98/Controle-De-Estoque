package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import controle.Estoque;

public class Inicio {

	private static int opcao;
	static Estoque estoque = new Estoque();
	static Consulta quantidade = new Consulta();
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Login validacao = new Login();
		
		if(validacao.login()) {
			estoque.lerArquivo();
			JOptionPane.showMessageDialog(null, "Bem vindo!");
			
			while(opcao != 7) {
				menu();
				switch(opcao) {
				case 1:
					new Cadastro(estoque);
					break;
				case 2:
					new Venda(estoque);
					break;
				case 3:
					quantidade.atualizarQuantidade(estoque);
					break;
				case 4:
					quantidade.imprimirEstoque(estoque);
					break;
				case 5:
					new Ranking(estoque);
					break;
				case 6:
					new Recomendacao(estoque);
					break;
				}
			}
			
			estoque.gravarArquivo();
		}

	}
	
	public static void menu() {
		try {
			String aux = JOptionPane.showInputDialog("Informe a opção desejada!"
					+ "\n(1) Cadastrar Produto" + "\n(2) Vender Produto"
					+ "\n(3) Adicionar nova quant." + "\n(4) Estoque" + "\n(5) Ranking de vendas"
					+ "\n(6) Recomendações" + "\n(7) Sair");
			
			if(aux == null) opcao = 7;
			else opcao = Integer.parseInt(aux);
		} catch(Exception NumberFormatException) {
			JOptionPane.showMessageDialog(null, "Digite uma opção válida!");
			opcao = 0;
		}
	}

}
