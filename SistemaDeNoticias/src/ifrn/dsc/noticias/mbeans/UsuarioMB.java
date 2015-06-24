package ifrn.dsc.noticias.mbeans;

import ifrn.dsc.noticias.ejb.FachadaSistema;
import ifrn.dsc.noticias.exceptions.LoginExistenteExecption;
import ifrn.dsc.noticias.modelo.Noticia;
import ifrn.dsc.noticias.modelo.Usuario;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="usuarioMB")
@SessionScoped
public class UsuarioMB {	
	private String login, senha1, senha2;
	private Usuario usuario;
	private String msg;
	private String noticia;
	private int noticiaRemover;
	private Usuario autorNoticia;
	
	@EJB
	private FachadaSistema fachada;
	
	public UsuarioMB() {
		super();
		usuario = null;
		msg = "";
		noticia = "";
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

	public int getNoticiaRemover() {
		return noticiaRemover;
	}

	public void setNoticiaRemover(int noticiaRemover) {
		this.noticiaRemover = noticiaRemover;
	}

	public Usuario getAutorNoticia() {
		return autorNoticia;
	}

	public void setAutorNoticia(Usuario autorNoticia) {
		this.autorNoticia = autorNoticia;
	}

	public String cadastraUsuario() {
		if (login != null && !login.isEmpty() && 
				senha1 != null && !senha1.isEmpty() && 
				senha2 != null && !senha2.isEmpty()) {
			if (senha1.equals(senha2)) {
				usuario = new Usuario(login, senha1);
				try {
					fachada.cadastraUsuario(usuario);
					return "index.xhtml";
				} catch (LoginExistenteExecption e) {
					this.setMsg(e.getMessage());
				}
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
			usuario = fachada.autenticar(login, senha1);
			if (usuario == null) {
				this.setMsg("Informações não correspondem a um usuário válido!");
			}
		} else {
			this.setMsg("Forneça as informações de login e senha!");
		}
		return "index.xhtml";
	}
	
	public String logout() {
		usuario = null;
		login = "";
		return "index.xhtml";
	}
	
	public String cadastrarNoticia() {
		if (noticia != null && !noticia.isEmpty()) {
			Noticia nova = new Noticia();
			nova.setConteudo(noticia);
			nova.setData(new Date());
			boolean ok = fachada.adicionaNoticia(usuario, nova);
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
	
	public boolean autorNoticia(int idNoticia) {
		Noticia noticia = fachada.getNoticia(idNoticia);
		if (usuario != null && noticia.getUsuario().getId() == this.usuario.getId()) {
			return true;
		}
		return false;
	}
	
	public String removerNoticia() {
		boolean ok = fachada.removeNoticia(autorNoticia, noticiaRemover);
		if (ok) {
			this.setMsg("Notícia removida com sucesso!");
		} else {
			this.setMsg("Não foi possível remover a referida notícia!");
		}
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
