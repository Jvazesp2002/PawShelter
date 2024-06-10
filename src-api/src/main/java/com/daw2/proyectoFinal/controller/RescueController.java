package com.daw2.proyectoFinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daw2.proyectoFinal.model.MascotaGuar;
import com.daw2.proyectoFinal.services.MascotaGuarService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/rescue")
@RequiredArgsConstructor
public class RescueController {
	@Autowired
	private MascotaGuarService mascotaService;

	// Endpoint para obtener todos los mascotas
	@GetMapping
	public ResponseEntity<List<MascotaGuar>> obtenerTodosLosMascotas() {
		List<MascotaGuar> mascotas = mascotaService.obtenerTodasLasMascotas();
		return new ResponseEntity<>(mascotas, HttpStatus.OK);

	}
}