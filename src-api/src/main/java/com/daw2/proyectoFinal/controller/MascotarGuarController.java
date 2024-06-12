package com.daw2.proyectoFinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/guarderia")
public class MascotarGuarController {
	@Autowired
	private MascotaGuarServiceImpl service;

	@GetMapping
	public List<MascotaGuar> getAllMascotaGuars() {
		return service.findAll();
	}

	@PostMapping
	public MascotaGuar createMascotaGuar(@RequestBody MascotaGuar mascotaGuar) {
		return service.save(mascotaGuar);
	}

	@PutMapping("/{id}")
	public MascotaGuar updateMascotaGuar(@PathVariable Long id, @RequestBody MascotaGuar mascotaGuar) {
		mascotaGuar.setId(id);
		return service.save(mascotaGuar);
	}

	@DeleteMapping("/{id}")
	public void deleteMascotaGuar(@PathVariable Long id) {
		service.deleteById(id);
	}
}
