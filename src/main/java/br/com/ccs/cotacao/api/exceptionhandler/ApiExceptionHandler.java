package br.com.ccs.cotacao.api.exceptionhandler;

import br.com.ccs.cotacao.domain.exceptions.CotacaoSeriveException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(CotacaoSeriveException.class)
	public ResponseEntity<Object> CotacaoSeriveExceptionHandler(CotacaoSeriveException e) {
		return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
	}

}
