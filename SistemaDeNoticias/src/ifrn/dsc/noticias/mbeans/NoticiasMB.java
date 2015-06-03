package ifrn.dsc.noticias.mbeans;

import ifrn.dsc.noticias.modelo.Noticia;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="noticiasMB")
public class NoticiasMB {
	private List<Noticia> noticias;
	
	public NoticiasMB() {
		super();
		noticias = new ArrayList<Noticia>();
	}

	public List<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}
}
