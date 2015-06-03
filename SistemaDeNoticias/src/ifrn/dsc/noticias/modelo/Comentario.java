package ifrn.dsc.noticias.modelo;

public class Comentario {
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
	
	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public Noticia getNoticia() {
		return noticia;
	}
	
	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
		noticia.addComentario(this);
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
		usuario.addComentario(this);
	}
}
