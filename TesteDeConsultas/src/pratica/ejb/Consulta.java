package pratica.ejb;

import java.util.List;
import javax.ejb.Local;

@Local
public interface Consulta {
	public List<Object[]> getResult(String jpql);
}
