package ifrn.dsc.noticias.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Usuario {
	private String login;
	private String senha;
	private Map<Integer, Noticia> noticias;
	private List<Comentario> comentarios;
	
	public Usuario() {
		super();
		noticias = new HashMap<Integer, Noticia>();
		comentarios = new ArrayList<Comentario>();
	}

	public Usuario(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
		noticias = new HashMap<Integer, Noticia>();
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

	public Map<Integer, Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(Map<Integer, Noticia> noticias) {
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
		noticias.put(n.getId(), n);
		return true;
	}

	public boolean removeNoticia(int idNoticia) {
		Noticia n = noticias.remove(idNoticia);
		return n != null;
	}
	
	public boolean alteraNoticia(int idNoticia, Noticia alterada) {
		Noticia n = noticias.put(idNoticia, alterada);
		return n != null;
	}
	
	public boolean addComentario(Comentario c) {
		return comentarios.add(c);
	}
}
