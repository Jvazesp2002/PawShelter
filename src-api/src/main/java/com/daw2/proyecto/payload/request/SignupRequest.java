package com.daw2.proyecto.payload.request;

public class SignupRequest {
	private String nombre;
	private String email;
	private String contrasena;

	public SignupRequest(String nombre, String email, String contrasena) {
		this.nombre = nombre;
		this.email = email;
		this.contrasena = contrasena;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
}