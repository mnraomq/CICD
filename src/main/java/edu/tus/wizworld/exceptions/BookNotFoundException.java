package edu.tus.wizworld.exceptions;


public class BookNotFoundException extends BookException {
	/**
     * Constructs a new runtime exception with the specified detail message.
     */
	public BookNotFoundException(String message) {
		super(message);
	}
}