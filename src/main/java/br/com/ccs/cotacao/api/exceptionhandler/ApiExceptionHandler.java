package br.com.ccs.cotacao.api.exceptionhandler;

import br.com.ccs.cotacao.domain.exceptions.CotacaoSeriveException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(CotacaoSeriveException.class)
	public ResponseEntity<Object> cotacaoSeriveExceptionHandler(CotacaoSeriveException e) {
		return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
		return new ResponseEntity<>(e.getRootCause().getMessage(), HttpStatus.CONFLICT);
	}
	@ExceptionHandler(JpaObjectRetrievalFailureException.class)
	public ResponseEntity<Object> handleJpaObjectRetrievalFailureException(JpaObjectRetrievalFailureException e) {
		return new ResponseEntity<>(e.getCause().getMessage(), HttpStatus.NOT_FOUND);
	}



}
