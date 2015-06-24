package ifrn.dsc.noticias.ejb;

import ifrn.dsc.noticias.exceptions.EntidadeInexistenteException;
import ifrn.dsc.noticias.exceptions.ViolacaoDeAutoriaException;
import ifrn.dsc.noticias.modelo.Noticia;
import ifrn.dsc.noticias.modelo.Usuario;

import java.util.List;

import javax.ejb.Local;

@Local
public interface NegocioNoticia {
	
	public List<Noticia> getAllNoticias();
	
	public Noticia getNoticia(int idNoticia);
	
	public void adicionaNoticia(Usuario autorNoticia, Noticia noticia);
	
	public void removeNoticia(Usuario usuarioLogado, int idNoticia) throws EntidadeInexistenteException, ViolacaoDeAutoriaException;
	
	public void alteraNoticia(Usuario usuarioLogado, Noticia alterada) throws ViolacaoDeAutoriaException;
}
