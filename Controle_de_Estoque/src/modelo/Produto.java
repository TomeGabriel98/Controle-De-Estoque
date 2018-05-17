package modelo;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Produto implements Serializable {
	int codigo;
	String nome;
	double preco;
	int quantidade;
	int quantidadeVendida;
	ArrayList<String> comentarios;
	
	public Produto() {
		comentarios = new ArrayList<>();
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public int getQuantidadeVendida() {
		return quantidadeVendida;
	}
	
	public void setQuantidadeVendida(int quantidadeVendida) {
		this.quantidadeVendida = quantidadeVendida;
	}
	
	public ArrayList<String> getComentario() {
		return comentarios;
	}
	
	public void setComentario(String comentario) {
		comentarios.add(comentario);
	}
	
	

}
