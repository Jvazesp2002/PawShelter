package com.daw2.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daw2.proyecto.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long>{

	public Pet findByName(final String name);
}