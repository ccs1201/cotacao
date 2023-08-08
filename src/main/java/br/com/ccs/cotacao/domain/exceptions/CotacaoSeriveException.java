package br.com.ccs.cotacao.domain.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CotacaoSeriveException extends RuntimeException {

	private final HttpStatus httpStatus;
	public CotacaoSeriveException(HttpStatus httpStatus, String message) {
		super(message);
		this.httpStatus = httpStatus;
	}

	public CotacaoSeriveException(HttpStatus httpStatus, String message, Throwable cause) {
		super(message, cause);
		this.httpStatus = httpStatus;
	}

	public CotacaoSeriveException(HttpStatus httpStatus, Throwable cause) {
		super(cause);
		this.httpStatus = httpStatus;
	}

	protected CotacaoSeriveException(HttpStatus httpStatus, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.httpStatus = httpStatus;
	}

}
