package ifrn.dsc.noticias.ejb;

import ifrn.dsc.noticias.exceptions.LoginExistenteExecption;
import ifrn.dsc.noticias.modelo.Usuario;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
public class UsuarioDAOImpl implements UsuarioDAO {
	
	@PersistenceContext(unitName="sist-noticias")
	private EntityManager em;

	@Override
	public void salvar(Usuario novo) throws LoginExistenteExecption {
		try {
			em.persist(novo);
		} catch(Exception ex) {
			throw new LoginExistenteExecption(ex.getMessage());
		}
	}

	@Override
	public Usuario getUsuarioByLoginESenha(String login, String senha) {
		Query consulta = em.createNamedQuery("autenticaUsuario"); 
		consulta.setParameter("login", login);
		consulta.setParameter("senha", senha);
		Usuario usr = null;
		try {
			usr = (Usuario) consulta.getSingleResult();
		} catch (PersistenceException pex) {
		}
		return usr;
	}

	@Override
	public Usuario carrega(Usuario autorNoticia) {
		return em.merge(autorNoticia);
	}

}
