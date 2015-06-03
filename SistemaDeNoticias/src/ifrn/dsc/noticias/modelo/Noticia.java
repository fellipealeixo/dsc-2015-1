package ifrn.dsc.noticias.modelo;

import java.util.Date;
import java.util.List;

public class Noticia {
	private int id;
	private String conteudo;
	private Date data;
	private Usuario usuario;
	private List<Comentario> comentarios;
	
	public Noticia() {
		super();
	}
	
	public Noticia(int id, String conteudo, Date data) {
		super();
		this.id = id;
		this.conteudo = conteudo;
		this.data = data;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public boolean addComentario(Comentario e) {
		return comentarios.add(e);
	}
}
