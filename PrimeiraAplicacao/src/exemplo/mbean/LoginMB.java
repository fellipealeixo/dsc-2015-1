package exemplo.mbean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import exemplo.ejb.Autenticador;

@ManagedBean(name="login")
@SessionScoped
public class LoginMB {
	private String loginVal, senhaVal;
	
	@EJB
	private Autenticador ejb;
	
	public LoginMB() {
		super();
	}

	public String getLoginVal() {
		return loginVal;
	}

	public void setLoginVal(String loginVal) {
		this.loginVal = loginVal;
	}

	public String getSenhaVal() {
		return senhaVal;
	}

	public void setSenhaVal(String senhaVal) {
		this.senhaVal = senhaVal;
	}
	
	public String autenticar() {
		if (ejb.autenticar(loginVal, senhaVal)) {
			return "sucesso.xhtml";
		}
		return "falha.xhtml";
	}
}
