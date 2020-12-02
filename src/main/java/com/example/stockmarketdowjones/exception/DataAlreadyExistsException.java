package com.example.stockmarketdowjones.exception;

public class DataAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = 98361438798096656L;
	
    public DataAlreadyExistsException(String message) {
        super(message);
    }

    public DataAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

}

