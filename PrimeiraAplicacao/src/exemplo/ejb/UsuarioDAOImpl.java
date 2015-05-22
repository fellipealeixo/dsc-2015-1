package exemplo.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import exemplo.entidade.Usuario;

@Stateless
public class UsuarioDAOImpl implements UsuarioDAO {

	@PersistenceContext(unitName="bancoApp")
	private EntityManager em;
	
	@Override
	public Usuario getUsuario(String login, String senha) {
		Query query = em.createNamedQuery("getUserByLogin");
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		Usuario usr = null;
		try {
			usr = (Usuario) query.getSingleResult();
		} catch (NoResultException nrex) {
			return null;
		}
		return usr;
	}

}
