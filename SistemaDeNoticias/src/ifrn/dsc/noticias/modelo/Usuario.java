package ifrn.dsc.noticias.modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String login;
	private String senha;
	private List<Noticia> noticias;
	private List<Comentario> comentarios;
	
	public Usuario() {
		super();
		noticias = new ArrayList<Noticia>();
		comentarios = new ArrayList<Comentario>();
	}

	public Usuario(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
		noticias = new ArrayList<Noticia>();
		comentarios = new ArrayList<Comentario>();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public boolean addNoticia(Noticia n) {
		n.setUsuario(this);
		return noticias.add(n);
	}

	public boolean removeNoticia(Noticia n) {
		return noticias.remove(n);
	}
	
	public boolean alteraNoticia(Noticia antiga, String novoTexto) {
		if (noticias.contains(antiga)) {
			antiga.setConteudo(novoTexto);
			return true;
		}
		return false;
	}
	
	public boolean addComentario(Comentario c) {
		return comentarios.add(c);
	}
}
