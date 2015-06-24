package ifrn.dsc.noticias.ejb;

import ifrn.dsc.noticias.exceptions.LoginExistenteExecption;
import ifrn.dsc.noticias.modelo.Usuario;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class NegocioUsuarioImpl implements NegocioUsuario {

	@EJB
	UsuarioDAO daoUsuario;
	
	@Override
	public void cadastraUsuario(Usuario novo) throws LoginExistenteExecption {
		daoUsuario.salvar(novo);
	}

	@Override
	public Usuario autenticar(String login, String senha) {
		return daoUsuario.getUsuarioByLoginESenha(login, senha); 
	}
}
