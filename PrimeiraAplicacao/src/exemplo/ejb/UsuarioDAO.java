package exemplo.ejb;

import javax.ejb.Remote;

import exemplo.entidade.Usuario;

@Remote
public interface UsuarioDAO {
	public Usuario getUsuario(String login, String senha);
}
