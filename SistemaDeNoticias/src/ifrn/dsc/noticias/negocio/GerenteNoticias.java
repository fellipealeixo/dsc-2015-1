package ifrn.dsc.noticias.negocio;

import ifrn.dsc.noticias.modelo.Comentario;
import ifrn.dsc.noticias.modelo.Noticia;
import ifrn.dsc.noticias.modelo.Usuario;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GerenteNoticias {
	private Map<String, Usuario> usuarios;
	private Map<Integer, Noticia> noticias;
	private static GerenteNoticias instancia = null;
	private int idNoticia = 1;

	private GerenteNoticias() {
		super();
		usuarios = new HashMap<String, Usuario>();
		noticias = new HashMap<Integer, Noticia>();
	}
	
	public static GerenteNoticias getInstancia() {
		if (instancia == null) {
			instancia = new GerenteNoticias();
		}
		return instancia;
	}

	public boolean cadastraUsuario(Usuario novo) {
		if (usuarios.containsKey(novo.getLogin())) {
			return false;
		}
		usuarios.put(novo.getLogin(), novo);
		return true;
	}
	
	public Collection<Noticia> getAllNoticias() {
		return noticias.values();
	}

	public Noticia getNoticia(int id) {
		return noticias.get(id);
	}
	
	public boolean adicionaNoticia(Usuario usr, Noticia noticia) {
		if (usr != null && noticia != null) {
			noticia.setId(idNoticia++);
			usr.addNoticia(noticia);
			Noticia n = noticias.put(noticia.getId(), noticia);
			return n == null;
		}
		return false;
	}

	public boolean removeNoticia(Usuario usr, int idNoticia) {
		if (usr != null && noticias.containsKey(idNoticia)) {
			if (usr.removeNoticia(idNoticia)) {
				noticias.remove(idNoticia);
				return true;
			}
		}
		return false;
	}

	public boolean alteraNoticia(Usuario usr, int idNoticia, Noticia alterada) {
		if (usr != null) {
			if (usr.alteraNoticia(idNoticia, alterada)) {
				Noticia n = noticias.put(idNoticia, alterada);
				return n != null;
			}
		}
		return false;
	}

	public boolean comentarNoticia(Usuario usr, int idNoticia, String comentario) {
		if (usr != null) {
			Noticia noticia = noticias.get(idNoticia);
			if (noticia != null) {
				Comentario c = new Comentario();
				c.setTexto(comentario);
				c.setNoticia(noticia);
				c.setUsuario(usr);
				return true;
			}
		}
		return false;
	}

	public Usuario autenticar(String login, String senha1) {
		if ( usuarios.containsKey(login) ) {
			Usuario usr = usuarios.get(login);
			if ( usr.getSenha().equals(senha1) ) {
				return usr;
			}
		}
		return null;
	}
}
