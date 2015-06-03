package ifrn.dsc.niticias.negocio;

import ifrn.dsc.noticias.modelo.Comentario;
import ifrn.dsc.noticias.modelo.Noticia;
import ifrn.dsc.noticias.modelo.Usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fachada {
	private Map<String, Usuario> usuarios;
	private List<Noticia> noticias;

	public Fachada() {
		super();
		usuarios = new HashMap<String, Usuario>();
		noticias = new ArrayList<Noticia>();
	}

	public boolean cadastraUsuario(Usuario novo) {
		if (usuarios.containsKey(novo.getLogin())) {
			return false;
		}
		usuarios.put(novo.getLogin(), novo);
		return true;
	}

	public boolean adicionaNoticia(Usuario usr, Noticia noticia) {
		if (usr != null && noticia != null) {
			usr.addNoticia(noticia);
			noticias.add(noticia);
			return true;
		}
		return false;
	}

	public boolean removeNoticia(Usuario usr, Noticia noticia) {
		if (usr != null) {
			if (usr.removeNoticia(noticia)) {
				noticias.remove(noticia);
				return true;
			}
		}
		return false;
	}

	public boolean atualizaNoticia(Usuario usr, Noticia noticia, String novoTexto) {
		if (usr != null) {
			if (usr.alteraNoticia(noticia, novoTexto)) {
				// replace
				noticia.setConteudo(novoTexto);
				return null != noticias.set(noticias.indexOf(noticia), noticia);	
			}
		}
		return false;
	}

	public boolean comentarNoticia(Usuario usr, int idNoticia, String comentario) {
		if (usr != null) {
			Noticia noticia = noticias.get(idNoticia);
			if (noticia != null) {
				new Comentario(comentario, noticia, usr);
				return true;
			}
		}
		return false;
	}
}
