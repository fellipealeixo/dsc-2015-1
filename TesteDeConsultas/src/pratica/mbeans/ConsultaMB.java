package pratica.mbeans;

import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@SessionScoped
public class ConsultaMB {
	private String consulta;
	private Object singleResult;
	private Object[] arrayObject;
	private List<Object> listObject;
	
	public ConsultaMB() {
		super();
	}

	public String getConsulta() {
		return consulta;
	}

	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}

	public Object getSingleResult() {
		return singleResult;
	}

	public void setSingleResult(Object singleResult) {
		this.singleResult = singleResult;
	}

	public Object[] getArrayObject() {
		return arrayObject;
	}

	public void setArrayObject(Object[] arrayObject) {
		this.arrayObject = arrayObject;
	}

	public List<Object> getListObject() {
		return listObject;
	}

	public void setListObject(List<Object> listObject) {
		this.listObject = listObject;
	}
	
	public String realizaConsulta() {
		
		return "consulta.jsp";
	}
}
