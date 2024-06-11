package com.daw2.proyectoFinal.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw2.proyectoFinal.model.MascotaResc;
import com.daw2.proyectoFinal.repository.MascotaRescRespository;

@Service
public class MascotaRescServiceImpl {

	@Autowired
	private MascotaRescRespository mascotaRescRepository;

	public List<MascotaResc> findAll() {
		return mascotaRescRepository.findAll();
	}

	public MascotaResc save(MascotaResc mascotaResc) {
		return mascotaRescRepository.save(mascotaResc);
	}

	public void deleteById(Long id) {
		mascotaRescRepository.deleteById(id);
	}
}