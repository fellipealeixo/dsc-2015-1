package ifrn.dsc.noticias.exceptions;

public class ViolacaoDeAutoriaException extends Exception {
	private static final long serialVersionUID = 8335844696202954435L;

	public ViolacaoDeAutoriaException() {
		super();
	}

	public ViolacaoDeAutoriaException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ViolacaoDeAutoriaException(String message, Throwable cause) {
		super(message, cause);
	}

	public ViolacaoDeAutoriaException(String message) {
		super(message);
	}

	public ViolacaoDeAutoriaException(Throwable cause) {
		super(cause);
	}

}
