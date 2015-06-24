package ifrn.dsc.noticias.ejb;

import ifrn.dsc.noticias.modelo.Noticia;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class NoticiaDAOImpl implements NoticiaDAO {
	
	@PersistenceContext(unitName="sist-noticias")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Noticia> getAllNoticias() {
		Query consulta = em.createNamedQuery("listNoticias");
		return consulta.getResultList();
	}

	@Override
	public Noticia getNoticia(int idNoticia) {
		return em.find(Noticia.class, idNoticia);
	}

	@Override
	public void salvar(Noticia noticia) {
		em.persist(noticia);
	}

	@Override
	public void remover(Noticia noticia) {
		em.remove(noticia);
	}

	@Override
	public void atualiza(Noticia alterada) {
		em.merge(alterada);
	}
}
