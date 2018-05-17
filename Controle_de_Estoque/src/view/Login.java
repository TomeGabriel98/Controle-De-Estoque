package view;

import javax.swing.JOptionPane;

public class Login {
	private String usuario = "admin";
	private String senha = "admin";
	
	public boolean login() {
		String verificarUsuario = JOptionPane.showInputDialog("Usu�rio: ");
		String verificarSenha = JOptionPane.showInputDialog("Senha: ");
		
		while(!verificarUsuario.equals(usuario) && !verificarSenha.equals(senha)) {
			JOptionPane.showMessageDialog(null, "Senha ou usu�rio inexistente!");
			verificarUsuario = JOptionPane.showInputDialog("Usu�rio: ");
			verificarSenha = JOptionPane.showInputDialog("Senha: ");
		}
		
		if(verificarUsuario.equals(usuario) && verificarSenha.equals(senha)) return true;
		
		return false;
	}

}
