package com.daw2.proyecto.exceptions;

/**
 * Excepción personalizada para manejar errores durante la inicialización de datos en la aplicación.
 */
public class InicializarDatosException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Constructor que toma un mensaje descriptivo del error.
     *
     * @param message Mensaje descriptivo del error.
     */
    public InicializarDatosException(String message) {
        super(message);
        escribirEnConsola(message);
    }

    /**
     * Constructor que toma un mensaje descriptivo del error y la causa original.
     *
     * @param message Mensaje descriptivo del error.
     * @param cause   Causa original de la excepción.
     */
    public InicializarDatosException(String message, Throwable cause) {
        super(message, cause);
        escribirEnConsola(message);
    }

    /**
     * Método para escribir el mensaje en la consola.
     *
     * @param message Mensaje a imprimir en la consola.
     */
    private void escribirEnConsola(String message) {
        System.err.println(message);
    }
}
