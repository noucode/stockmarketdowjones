package com.example.stockmarketdowjones.exception;


public class StorageException extends RuntimeException {
	private static final long serialVersionUID = 98361438798096656L;

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}


