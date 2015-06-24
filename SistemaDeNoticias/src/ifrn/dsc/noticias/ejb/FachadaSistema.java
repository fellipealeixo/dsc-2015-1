package ifrn.dsc.noticias.ejb;

import ifrn.dsc.noticias.exceptions.LoginExistenteExecption;
import ifrn.dsc.noticias.modelo.Noticia;
import ifrn.dsc.noticias.modelo.Usuario;

import java.util.List;

import javax.ejb.Local;

@Local
public interface FachadaSistema {
	
	public void cadastraUsuario(Usuario usuario) throws LoginExistenteExecption;

	public Usuario autenticar(String login, String senha1);

	public List<Noticia> getAllNoticias();

	public boolean adicionaNoticia(Usuario usuario, Noticia nova);

	public Noticia getNoticia(int noticia);

	public boolean removeNoticia(Usuario autorNoticia, int noticiaRemover);

}
