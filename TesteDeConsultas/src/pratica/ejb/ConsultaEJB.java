package pratica.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ConsultaEJB implements Consulta {
	@PersistenceContext(unitName="testeDeConsultas")
	EntityManager em;
	
	@Override
	public List<Object[]> getResult(String jpql) {
		Query query = em.createQuery(jpql);
		List<Object[]> result = new ArrayList<Object[]>();
		// Verifica se a consulta retorna um único resultado
		try {
			Object single = query.getSingleResult();
			if (single != null) {
				Object[] singleResult = new Object[1];
				singleResult[0] = single;
				result.add(singleResult);
				return result;
			}
		} catch (NonUniqueResultException nurex) {
			// ok
		} catch (NoResultException nrex) {
			return result;
		}
		return null;
	}
}
