package ifrn.dsc.noticias.mbeans;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="usuarioMB")
public class UsuarioMB {
	private String login, senha1, senha2;
	
	public UsuarioMB() {
		super();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha1() {
		return senha1;
	}

	public void setSenha1(String senha1) {
		this.senha1 = senha1;
	}

	public String getSenha2() {
		return senha2;
	}

	public void setSenha2(String senha2) {
		this.senha2 = senha2;
	}
	
	public String cadastraUsuario() {
		return "index.xhtml";
	}
}
