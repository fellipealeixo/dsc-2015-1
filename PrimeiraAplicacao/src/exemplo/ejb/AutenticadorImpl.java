package exemplo.ejb;

import javax.ejb.Stateless;

@Stateless
public class AutenticadorImpl implements Autenticador {

	@Override
	public boolean autenticar(String loginVal, String senhaVal) {
		// Declaração de logins estáticos
		String login[] = {"admin", "usr", "chico"};
		String senha[] = {"123", "123", "123"};
		
		for (int i = 0; i < login.length; i++) {
			if (loginVal.equals(login[i])) {
				if (senhaVal.equals(senha[i])) {
					return true;
				} else {
					break;
				}
			}
		}
		return false;
	}

}
