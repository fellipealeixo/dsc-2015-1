package exemplo.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import exemplo.entidade.Usuario;

@Stateless
public class AutenticadorImpl implements Autenticador {

	@EJB
	private UsuarioDAO dao;
	
	@Override
	public boolean autenticar(String loginVal, String senhaVal) {
		Usuario usr = dao.getUsuario(loginVal, senhaVal);
		if (usr == null) {
			return false;
		}
		return true;
	}

}
