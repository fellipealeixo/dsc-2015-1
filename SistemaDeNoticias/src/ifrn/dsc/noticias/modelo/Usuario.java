package ifrn.dsc.noticias.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries({
	@NamedQuery(name="autenticaUsuario", query="SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha")
})

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
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
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(unique=true)
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

	@OneToMany(mappedBy="usuario", cascade=CascadeType.ALL)
	public List<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}

	@OneToMany(mappedBy="usuario", cascade=CascadeType.ALL)
	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public boolean addNoticia(Noticia n) {
		n.setUsuario(this);
		noticias.add(n);
		return true;
	}

	public boolean removeNoticia(int idNoticia) {
		Noticia n = noticias.remove(idNoticia);
		return n != null;
	}
	
	public boolean alteraNoticia(int idNoticia, Noticia alterada) {
		Noticia n = noticias.set(idNoticia, alterada);
		return n != null;
	}
	
	public boolean addComentario(Comentario c) {
		return comentarios.add(c);
	}
}
