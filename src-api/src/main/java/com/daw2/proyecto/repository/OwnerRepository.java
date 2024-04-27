package com.daw2.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daw2.proyecto.model.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long>{

	public Owner findByName(final String name);

}