package controle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import modelo.Produto;

public class Estoque {
	File file = new File("C:\\Users\\Gabriel Tomé\\OneDrive\\Documentos\\Fatec\\3° Semestre\\Programação Orientada a Objetos\\Trabalho 1\\Controle de Estoque\\estoque.ser");
	public ArrayList<Produto> produtos;
	
	public Estoque() {
		produtos = new ArrayList<>();
	}
	
	public void inserirProduto(Produto produto) {
		produto.setQuantidadeVendida(0);
		produtos.add(produto);
	}
	
	public boolean buscaProduto(int codigo) {
		for (Produto produto : produtos) {
			if(codigo == produto.getCodigo()) return true;
		}
		
		return false;
	}
	
	public void venda(int codigo, int quantidade) {
		for (Produto produto : produtos) {
			if(codigo == produto.getCodigo()) {
				produto.setQuantidade(produto.getQuantidade() - quantidade);
				produto.setQuantidadeVendida(produto.getQuantidadeVendida() + quantidade);
			}
		}
	}
	
	public int quantidadeDisponivel(int codigo) {
		for (Produto produto : produtos) {
			if(codigo == produto.getCodigo()) return produto.getQuantidade();
		}
		
		return 0;
	}
	
	public ArrayList<Produto> imprimirEstoque(){
		return produtos;
	}
	
	public void atualizarQuantidade(int codigo, int quantidade) {
		for (Produto produto : produtos) {
			if(codigo == produto.getCodigo())
				produto.setQuantidade(produto.getQuantidade() + quantidade);
		}
	}
	
	public Produto produtoMaisVendido() {
		int maior = 0;
		Produto p = null;
		
		for (Produto produto : produtos) {
			int aux = produto.getQuantidadeVendida();
			if(aux >= maior) {
				maior = aux;
				p = produto;
			}
		}
		
		return p;
	}
	
	public int buscarCodigo() {
		if(produtos.isEmpty()) return 0;
		
		return produtos.size();
	}
	
	public void gravarArquivo() throws IOException{
		ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(file));
		
		escritor.writeObject(produtos);
		
		escritor.flush();
		escritor.close();
	}
	
	@SuppressWarnings("unchecked")
	public void lerArquivo() throws IOException, ClassNotFoundException{
		FileInputStream input = new FileInputStream("estoque.ser");
		ObjectInputStream arquivo = new ObjectInputStream(input);
		
		produtos = (ArrayList<Produto>) arquivo.readObject();
		
		input.close();
		arquivo.close();
	}

}
