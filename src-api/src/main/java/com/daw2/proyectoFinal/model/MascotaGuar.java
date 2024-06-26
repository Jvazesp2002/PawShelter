package com.daw2.proyectoFinal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mascotas")
public class MascotaGuar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private int edad;
	private String raza;
	private int dias;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return nombre;
	}

	public void setName(String nombre) {
		this.nombre = nombre;
	}

	public int getAge() {
		return edad;
	}

	public void setAge(int edad) {
		this.edad = edad;
	}

	public String getBreed() {
		return raza;
	}

	public void setBreed(String raza) {
		this.raza = raza;
	}

	public int getStayDays() {
		return dias;
	}

	public void setStayDays(int dias) {
		this.dias = dias;
	}

}
