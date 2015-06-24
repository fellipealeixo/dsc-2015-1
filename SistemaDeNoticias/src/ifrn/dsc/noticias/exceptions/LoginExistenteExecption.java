package ifrn.dsc.noticias.exceptions;

public class LoginExistenteExecption extends Exception {
	private static final long serialVersionUID = 5959996381979366246L;

	public LoginExistenteExecption() {
		super();
	}

	public LoginExistenteExecption(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public LoginExistenteExecption(String message, Throwable cause) {
		super(message, cause);
	}

	public LoginExistenteExecption(String message) {
		super(message);
	}

	public LoginExistenteExecption(Throwable cause) {
		super(cause);
	}
}
