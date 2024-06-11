package com.daw2.proyectoFinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daw2.proyectoFinal.model.MascotaGuar;
import com.daw2.proyectoFinal.servicesImpl.MascotaGuarServiceImpl;

@RestController
@RequestMapping("/api/guarderia")
public class MascotarGuarController {
	@Autowired
	private MascotaGuarServiceImpl service;

	@GetMapping
	public List<MascotaGuar> getAllMascotaGuars() {
		return service.findAll();
	}

	@PostMapping
	public MascotaGuar createMascotaGuar(@RequestBody MascotaGuar dogVaccination) {
		return service.save(dogVaccination);
	}

	@PutMapping("/{id}")
	public MascotaGuar updateMascotaGuar(@PathVariable Long id, @RequestBody MascotaGuar dogVaccination) {
		dogVaccination.setId(id);
		return service.save(dogVaccination);
	}

	@DeleteMapping("/{id}")
	public void deleteMascotaGuar(@PathVariable Long id) {
		service.deleteById(id);
	}
}
