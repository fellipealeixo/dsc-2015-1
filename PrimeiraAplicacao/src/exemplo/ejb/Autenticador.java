package exemplo.ejb;

import javax.ejb.Remote;

@Remote
public interface Autenticador {
	public boolean autenticar(String login, String senha);
}
