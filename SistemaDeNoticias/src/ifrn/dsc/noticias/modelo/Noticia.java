package ifrn.dsc.noticias.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQueries({
	@NamedQuery(name="listNoticias", query="SELECT n FROM Noticia n ORDER BY n.data DESC")
})

@Entity
public class Noticia implements Serializable {
	private static final long serialVersionUID = 1L;
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
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	@Temporal(TemporalType.TIMESTAMP)
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@ManyToOne
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@OneToMany(mappedBy="noticia", cascade=CascadeType.ALL)
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
