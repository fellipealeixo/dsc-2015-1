package ifrn.dsc.noticias.mbeans;

import ifrn.dsc.noticias.ejb.FachadaSistema;
import ifrn.dsc.noticias.modelo.Noticia;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="noticiasMB")
@ApplicationScoped
public class NoticiasMB {
	
	@EJB
	private FachadaSistema fachada;
	
	private List<Noticia> noticias;
	
	public NoticiasMB() {
		super();
	}
	
	@PostConstruct
	public void init() {
		this.noticias = fachada.getAllNoticias();
	}

	public List<Noticia> getNoticias() {
		this.noticias = fachada.getAllNoticias();
		return noticias;
	}

	public boolean isComNoticias() {
		return !noticias.isEmpty();
	}
	
	public boolean isSemNoticias() {
		return noticias.isEmpty();
	}
}
