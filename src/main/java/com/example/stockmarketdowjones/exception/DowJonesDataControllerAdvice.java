package com.example.stockmarketdowjones.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;


@ControllerAdvice
public class DowJonesDataControllerAdvice extends ResponseEntityExceptionHandler {
 
    @Autowired
    private MessageSource messages;
 
    @ExceptionHandler({ FileNotFoundException.class })
    public ResponseEntity<Object> handleFileNotFound(RuntimeException ex, WebRequest request) {
        logger.error("404 Status Code", ex);
        GenericResponse bodyOfResponse = new GenericResponse(
		messages.getMessage("message.dowjonesdata.notfound", null, request.getLocale()), "404 Not Found");
         
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
 
    @ExceptionHandler({ StorageException.class })
    public ResponseEntity<Object> handleStorage(RuntimeException ex, WebRequest request) {
        logger.error("400 Status Code", ex);
        GenericResponse bodyOfResponse = new GenericResponse(
		messages.getMessage("message.file.storage.error", null, request.getLocale()), "400 Bad Request");
        							
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }  

 
    @ExceptionHandler({ DataAlreadyExistsException.class })
    public ResponseEntity<Object> handleDataAlreadyExists(RuntimeException ex, WebRequest request) {
        logger.error("422 Status Code", ex);
        GenericResponse bodyOfResponse = new GenericResponse(
		messages.getMessage("message.data.alreadyexists", null, request.getLocale()), "422 Unprocessable Entity");
         
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY, request);
    }
    
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ResponseEntity<Object> handleMaxSizeException(MaxUploadSizeExceededException ex, WebRequest request) {
        logger.error("417 Status Code", ex);
        GenericResponse bodyOfResponse = new GenericResponse(
		messages.getMessage("message.file.toolarge", null, request.getLocale()), "417 Expectation Failed");

        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.EXPECTATION_FAILED, request);
	}
}










