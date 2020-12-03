package com.example.stockmarketdowjones.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;


@RestControllerAdvice
public class DowJonesDataControllerAdvice {
    private static final Logger logger = LoggerFactory.getLogger(DowJonesDataControllerAdvice.class);
	
    @ExceptionHandler(StorageException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleStorage(StorageException exc) {
        logger.error("400 Status Code", exc.getMessage());
    	return exc.getMessage();
    }
    
    @ExceptionHandler(FileNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleFileNotFound(FileNotFoundException exc) {
        logger.error("404 Status Code", exc.getMessage());        
    	return exc.getMessage();
    }
    
    @ExceptionHandler(DataAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public String handleDataAlreadyExists(DataAlreadyExistsException exc) {
        logger.error("422 Status Code", exc.getMessage());
         
    	return exc.getMessage();
    }
    
	@ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
	public String handleMaxSizeException(MaxUploadSizeExceededException exc) {
        logger.error("417 Status Code", exc.getMessage());

    	return exc.getMessage();
	}
    
    
}








