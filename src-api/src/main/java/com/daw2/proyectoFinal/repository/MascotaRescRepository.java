package com.daw2.proyectoFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daw2.proyectoFinal.model.MascotaGuar;
import com.daw2.proyectoFinal.model.MascotaRescue;

@Repository
public interface MascotaRescRepository extends JpaRepository<MascotaRescue, Long>{

}
