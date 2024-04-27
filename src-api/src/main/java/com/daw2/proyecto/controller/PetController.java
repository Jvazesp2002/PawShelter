package com.daw2.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daw2.proyecto.model.Pet;
import com.daw2.proyecto.services.PetService;

@RestController
@RequestMapping("/api/Pets")
public class PetController {

    @Autowired
    private PetService petService;

    // Endpoint para obtener todos los Pets
    @GetMapping
    public ResponseEntity<List<Pet>> obtenerTodosLosPets() {
        List<Pet> pets = petService.obtenerTodosLosPets();
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    // Endpoint para obtener un Pet por ID
    @GetMapping("/{id}")
    public ResponseEntity<Pet> obtenerPetPorId(@PathVariable Long id) {
        Pet pet = petService.obtenerPetPorId(id);
        if (pet != null) {
            return new ResponseEntity<>(pet, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para crear un nuevo Pet
    @PostMapping
    public ResponseEntity<Pet> crearPet(@RequestBody Pet pet) {
        Pet nuevoPet = petService.crearPet(pet);
        return new ResponseEntity<>(nuevoPet, HttpStatus.CREATED);
    }

    // Endpoint para actualizar un Pet existente
    @PutMapping("/{id}")
    public ResponseEntity<Pet> actualizarPet(@PathVariable Long id, @RequestBody Pet updatedPet) {
        Pet pet = petService.obtenerPetPorId(id);
        if (pet != null) {
            updatedPet.setPetId(id);
            Pet updatedPetDb = petService.actualizarPet(updatedPet);
            return new ResponseEntity<>(updatedPetDb, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para eliminar un Pet por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminarPet(@PathVariable Long id) {
        boolean eliminado = petService.eliminarPet(id);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

