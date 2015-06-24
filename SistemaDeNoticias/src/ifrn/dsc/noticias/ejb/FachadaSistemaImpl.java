package ifrn.dsc.noticias.ejb;

import ifrn.dsc.noticias.exceptions.LoginExistenteExecption;
import ifrn.dsc.noticias.modelo.Noticia;
import ifrn.dsc.noticias.modelo.Usuario;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class FachadaSistemaImpl implements FachadaSistema {

	@EJB
	private NegocioNoticia noticias;
	@EJB
	private NegocioUsuario usuarios;
	
	@Override
	public void cadastraUsuario(Usuario usuario) throws LoginExistenteExecption {
		usuarios.cadastraUsuario(usuario);
	}

	@Override
	public Usuario autenticar(String login, String senha1) {
		return usuarios.autenticar(login, senha1);
	}
	
	@Override
	public List<Noticia> getAllNoticias() {
		return noticias.getAllNoticias();
	}

	@Override
	public boolean adicionaNoticia(Usuario usuario, Noticia nova) {
		try {
			noticias.adicionaNoticia(usuario, nova);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public Noticia getNoticia(int idNoticia) {
		return noticias.getNoticia(idNoticia);
	}

	@Override
	public boolean removeNoticia(Usuario autorNoticia, int noticiaRemover) {
		try {
			noticias.removeNoticia(autorNoticia, noticiaRemover);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

}
