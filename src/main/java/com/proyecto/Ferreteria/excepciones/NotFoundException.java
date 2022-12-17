package com.proyecto.Ferreteria.excepciones;

public class NotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotFoundException(Long id) {
		    super("Could not found " + id);
		  }
}
