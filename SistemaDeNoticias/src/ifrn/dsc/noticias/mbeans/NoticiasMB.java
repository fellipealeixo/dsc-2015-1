package ifrn.dsc.noticias.mbeans;

import ifrn.dsc.noticias.modelo.Noticia;
import ifrn.dsc.noticias.negocio.GerenteNoticias;

import java.util.Collection;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="noticiasMB")
@ApplicationScoped
public class NoticiasMB {
	private GerenteNoticias gerente;
	
	private Collection<Noticia> noticias;
	
	public NoticiasMB() {
		super();		
		gerente = GerenteNoticias.getInstancia();
		noticias = gerente.getAllNoticias();
	}

	public Collection<Noticia> getNoticias() {
		this.noticias = gerente.getAllNoticias();
		return noticias;
	}

	public void setNoticias(Collection<Noticia> noticias) {
		this.noticias = noticias;
	}
	
	public boolean isComNoticias() {
		return !noticias.isEmpty();
	}
	
	public boolean isSemNoticias() {
		return noticias.isEmpty();
	}
}
