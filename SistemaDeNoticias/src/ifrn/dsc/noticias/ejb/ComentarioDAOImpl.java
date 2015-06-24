package ifrn.dsc.noticias.ejb;

import ifrn.dsc.noticias.exceptions.EntidadeInexistenteException;
import ifrn.dsc.noticias.exceptions.ViolacaoDeAutoriaException;
import ifrn.dsc.noticias.modelo.Comentario;
import ifrn.dsc.noticias.modelo.Noticia;
import ifrn.dsc.noticias.modelo.Usuario;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ComentarioDAOImpl implements ComentarioDAO {

	@PersistenceContext(unitName="sist-noticias")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Comentario> getComentariosByNoticia(int idNoticia)
			throws EntidadeInexistenteException {
		Query consulta = em.createNamedQuery("getComentariosByNoticia");
		consulta.setParameter("idNoticia", idNoticia);
		return consulta.getResultList();
	}

	@Override
	public void removeComentario(Usuario usuarioLogado, int idComentario)
			throws EntidadeInexistenteException, ViolacaoDeAutoriaException {
		if (usuarioLogado != null) {
			usuarioLogado = em.merge(usuarioLogado);
			Comentario comentario = em.find(Comentario.class, idComentario);
			if (comentario != null && comentario.getUsuario().getId() == usuarioLogado.getId()) {
				comentario.setUsuario(null);
				em.remove(comentario);
			}
		}
	}

	@Override
	public boolean inserirComentario(Usuario autorComentrio, int idNoticia,
			String comentario) throws EntidadeInexistenteException {
		if (autorComentrio != null) {
			autorComentrio = em.merge(autorComentrio);
			Noticia noticia = em.find(Noticia.class, idNoticia);
			if (noticia != null) {
				Comentario novo = new Comentario();
				novo.setTexto(comentario);
				novo.setNoticia(noticia);
				novo.setUsuario(autorComentrio);
				em.persist(novo);
				return true;
			}
		}
		return false;
	}

}
