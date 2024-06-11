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

import com.daw2.proyectoFinal.model.MascotaResc;
import com.daw2.proyectoFinal.servicesImpl.MascotaRescServiceImpl;

@RestController
@RequestMapping("/api/mascotaRescs")
public class MascotaRescController {
	@Autowired
	private MascotaRescServiceImpl service;

	@GetMapping
	public List<MascotaResc> getAllMascotaRescs() {
		return service.findAll();
	}

	@PostMapping
	public MascotaResc createMascotaResc(@RequestBody MascotaResc mascotaResc) {
		return service.save(mascotaResc);
	}

	@PutMapping("/{id}")
	public MascotaResc updateMascotaResc(@PathVariable Long id, @RequestBody MascotaResc mascotaResc) {
		mascotaResc.setId(id);
		return service.save(mascotaResc);
	}

	@DeleteMapping("/{id}")
	public void deleteMascotaResc(@PathVariable Long id) {
		service.deleteById(id);
	}
}
