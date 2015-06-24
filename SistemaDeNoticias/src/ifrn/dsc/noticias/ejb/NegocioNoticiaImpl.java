package ifrn.dsc.noticias.ejb;

import ifrn.dsc.noticias.exceptions.EntidadeInexistenteException;
import ifrn.dsc.noticias.exceptions.ViolacaoDeAutoriaException;
import ifrn.dsc.noticias.modelo.Noticia;
import ifrn.dsc.noticias.modelo.Usuario;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class NegocioNoticiaImpl implements NegocioNoticia {

	@EJB
	NoticiaDAO daoNoticia;
	@EJB
	UsuarioDAO daoUsuario;
	
	@Override
	public List<Noticia> getAllNoticias() {
		return daoNoticia.getAllNoticias();
	}

	@Override
	public Noticia getNoticia(int idNoticia) {
		return daoNoticia.getNoticia(idNoticia);
	}

	@Override
	public void adicionaNoticia(Usuario autorNoticia, Noticia noticia) {
		if (autorNoticia != null) {
			autorNoticia = daoUsuario.carrega(autorNoticia);
			noticia.setUsuario(autorNoticia);
			daoNoticia.salvar(noticia);
		}
	}

	@Override
	public void removeNoticia(Usuario usuarioLogado, int idNoticia)
			throws EntidadeInexistenteException, ViolacaoDeAutoriaException {
		if (usuarioLogado != null) {
			usuarioLogado = daoUsuario.carrega(usuarioLogado);
			Noticia noticia = daoNoticia.getNoticia(idNoticia);
			if (noticia != null && noticia.getUsuario().getId() == usuarioLogado.getId()) {
				noticia.setUsuario(null);
				daoNoticia.remover(noticia);
			}
		}	
	}

	@Override
	public void alteraNoticia(Usuario usuarioLogado, Noticia alterada)
			throws ViolacaoDeAutoriaException {
		if (usuarioLogado != null) {
			usuarioLogado = daoUsuario.carrega(usuarioLogado);
			if (alterada != null && alterada.getUsuario().getId() == usuarioLogado.getId()) {
				daoNoticia.atualiza(alterada);
			}
		}
		
	}
}
