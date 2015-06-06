package ifrn.dsc.noticias.mbeans;

import ifrn.dsc.noticias.modelo.Noticia;
import ifrn.dsc.noticias.modelo.Usuario;
import ifrn.dsc.noticias.negocio.GerenteNoticias;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="usuarioMB")
@SessionScoped
public class UsuarioMB {
	private GerenteNoticias gerente;
	
	private String login, senha1, senha2;
	private Usuario usuario;
	private String msg;

	private String noticia;
	
	public UsuarioMB() {
		super();
		usuario = null;
		msg = "";
		noticia = "";
		
		gerente = GerenteNoticias.getInstancia();
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
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getMsg() {
		String retorno = msg;
		msg = "";
		return retorno;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getNoticia() {
		return noticia;
	}

	public void setNoticia(String noticia) {
		this.noticia = noticia;
	}

	public String cadastraUsuario() {
		if (login != null && !login.isEmpty() && 
				senha1 != null && !senha1.isEmpty() && 
				senha2 != null && !senha2.isEmpty()) {
			if (senha1.equals(senha2)) {
				usuario = new Usuario(login, senha1);
				gerente.cadastraUsuario(usuario);
				return "index.xhtml";
			} else {
				this.setMsg("As senhas informadas precisam ser iguais!");
			}
		} else {
			this.setMsg("Todas os dados necessitam ser informadas!");
		}
		return "cadastroUsr.xhtml";
	}
	
	public String efetuarLogin() {
		if (login != null && !login.isEmpty() && senha1 != null && !senha1.isEmpty() ) {
			usuario = gerente.autenticar(login, senha1);
			if (usuario == null) {
				this.setMsg("Informações não correspondem a um usuário válido!");
			}
		} else {
			this.setMsg("Forneça as informações de login e senha!");
		}
		return "index.xhtml";
	}
	
	public String cadastrarNoticia() {
		if (noticia != null && !noticia.isEmpty()) {
			Noticia nova = new Noticia();
			nova.setConteudo(noticia);
			nova.setData(new Date());
			boolean ok = gerente.adicionaNoticia(usuario, nova);
			noticia = "";
			if (ok) {
				this.setMsg("Notícia cadastrada com sucesso!");
			} else {
				this.setMsg("A notícia não pôde ser cadastrada...");
			}
		} else {
			this.setMsg("A notícia não pode ser vazia!");
		}
		return "index.xhtml";
	}
	
	public String logout() {
		usuario = null;
		login = "";
		return "index.xhtml";
	}
	
	public boolean isLogado() {
		return usuario != null;
	}
	
	public boolean isNotLogado() {
		return usuario == null;
	}
	
	public boolean isComMensagem() {
		return !msg.isEmpty();
	}
}
