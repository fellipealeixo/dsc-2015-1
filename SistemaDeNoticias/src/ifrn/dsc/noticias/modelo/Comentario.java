package ifrn.dsc.noticias.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
	@NamedQuery(name="getComentariosByNoticia", query="SELECT c FROM Comentario c WHERE c.noticia.id = :idNticia")
})

@Entity
public class Comentario implements Serializable {
	private static final long serialVersionUID = -5437635284730953155L;
	private int id;
	private String texto;
	private Noticia noticia;
	private Usuario usuario;
	
	public Comentario() {
		super();
	}
	
	public Comentario(String texto, Noticia noticia, Usuario usuario) {
		super();
		this.texto = texto;
		this.noticia = noticia;
		noticia.addComentario(this);
		this.usuario = usuario;
		usuario.addComentario(this);
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	@ManyToOne
	public Noticia getNoticia() {
		return noticia;
	}
	
	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
		noticia.addComentario(this);
	}
	
	@ManyToOne
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
		usuario.addComentario(this);
	}
}
