package com.daw2.proyectoFinal.exceptions;

import com.daw2.proyectoFinal.util.LogUtil;

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
        LogUtil.escribirEnLog(message, "src/main/resources/mylog.txt");
    }

    /**
     * Constructor que toma un mensaje descriptivo del error y la causa original.
     *
     * @param message Mensaje descriptivo del error.
     * @param cause   Causa original de la excepción.
     */
    public InicializarDatosException(String message, Throwable cause) {
        super(message, cause);
        LogUtil.escribirEnLog(message, "src/main/resources/mylog.txt");
    }
}

