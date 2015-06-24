package ifrn.dsc.noticias.ejb;

import ifrn.dsc.noticias.exceptions.LoginExistenteExecption;
import ifrn.dsc.noticias.modelo.Usuario;

import javax.ejb.Local;

@Local
public interface NegocioUsuario {

	public void cadastraUsuario(Usuario novo) throws LoginExistenteExecption;
	
	public Usuario autenticar(String login, String senha);
}
