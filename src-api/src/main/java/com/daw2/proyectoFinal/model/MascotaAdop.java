package com.daw2.proyectoFinal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mascotas")
public class MascotaAdop {

	@Id
	private Long id;

	@Column(name = "Nombre")
	private String nombre;

	@Column(name = "Raza")
	private String raza;

	@Column(name = "Edad")
	private Integer edad;

	@Column(name = "Genero")
	private String genero;

	@Column(name = "Vacunado")
	private String vacunado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getVacunado() {
		return vacunado;
	}

	public void setVacunado(String vacunado) {
		this.vacunado = vacunado;
	}

}
