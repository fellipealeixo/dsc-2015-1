package ifrn.dsc.noticias.ejb;

import ifrn.dsc.noticias.exceptions.LoginExistenteExecption;
import ifrn.dsc.noticias.modelo.Usuario;

import javax.ejb.Local;

@Local
public interface UsuarioDAO {

	void salvar(Usuario novo) throws LoginExistenteExecption;

	Usuario getUsuarioByLoginESenha(String login, String senha);

	Usuario carrega(Usuario autorNoticia);

}
