package ifrn.dsc.noticias.ejb;

import ifrn.dsc.noticias.modelo.Noticia;

import java.util.List;

import javax.ejb.Local;

@Local
public interface NoticiaDAO {
	
	public List<Noticia> getAllNoticias();
	
	public Noticia getNoticia(int idNoticia);
	
	public void salvar(Noticia noticia);
	
	public void remover(Noticia noticia);
	
	public void atualiza(Noticia alterada);
}
