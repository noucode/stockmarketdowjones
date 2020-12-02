package com.example.stockmarketdowjones.exception;


public class FileNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 98361438798096656L;

    public FileNotFoundException(String message) {
        super(message);
    }

    public FileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}


