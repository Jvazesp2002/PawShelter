package com.daw2.proyectoFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daw2.proyectoFinal.model.MascotaAdop;

@Repository
public interface MascotaRepository extends JpaRepository<MascotaAdop, Long>{

}
