package ifrn.dsc.noticias.ejb;

import ifrn.dsc.noticias.exceptions.EntidadeInexistenteException;
import ifrn.dsc.noticias.exceptions.ViolacaoDeAutoriaException;
import ifrn.dsc.noticias.modelo.Comentario;
import ifrn.dsc.noticias.modelo.Usuario;

import java.util.List;

import javax.ejb.Local;

@Local
public interface ComentarioDAO {
	public List<Comentario> getComentariosByNoticia(int idNoticia) throws EntidadeInexistenteException;
	public boolean inserirComentario(Usuario autorComentrio, int idNoticia, String comentario) throws EntidadeInexistenteException;
	public void removeComentario(Usuario usuarioLogado, int idComentario) throws EntidadeInexistenteException, ViolacaoDeAutoriaException;
}
