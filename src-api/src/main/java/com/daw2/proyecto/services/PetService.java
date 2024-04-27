package com.daw2.proyecto.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.daw2.proyecto.model.Pet;

public interface PetService {
    Pet crearPet(Pet pet);
    Pet obtenerPetPorId(Long id);
    List<Pet> obtenerTodosLosPets();
    Pet actualizarPet(Pet pet);
    boolean eliminarPet(Long id);
    UserDetailsService userDetailsService();
}
