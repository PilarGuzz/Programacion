package com.jacaranda.notas;

public class BlocException extends RuntimeException {
	
	public static final String MENSAJE = "Se ha producido una excepcion al trabajar en el bloc";

	public BlocException() {
		super();
	}

	public BlocException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BlocException(String message, Throwable cause) {
		super(message, cause);
	}

	public BlocException(String message) {
		super(message);
	}

	public BlocException(Throwable cause) {
		super(cause);
	}
	

}
