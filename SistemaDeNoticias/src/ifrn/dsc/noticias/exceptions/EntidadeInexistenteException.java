package ifrn.dsc.noticias.exceptions;

public class EntidadeInexistenteException extends Exception {
	private static final long serialVersionUID = 1334907642008432177L;

	public EntidadeInexistenteException() {
		super();
	}

	public EntidadeInexistenteException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EntidadeInexistenteException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntidadeInexistenteException(String message) {
		super(message);
	}

	public EntidadeInexistenteException(Throwable cause) {
		super(cause);
	}

}
