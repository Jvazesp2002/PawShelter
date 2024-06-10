package com.daw2.proyectoFinal.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.daw2.proyectoFinal.model.MascotaRescue;
import com.daw2.proyectoFinal.repository.MascotaRescRepository;
import com.daw2.proyectoFinal.services.MascotaRescService;

public class MascotaRescServiceImpl implements MascotaRescService {

	@Autowired
	private MascotaRescRepository mascotaRepository;

	@Override
	public MascotaRescue crearMascota(MascotaRescue mascota) {
		return mascotaRepository.save(mascota);
	}

	@Override
	public MascotaRescue obtenerMascotaPorId(Long id) {
		Optional<MascotaRescue> optionalMascota = mascotaRepository.findById(id);
		return optionalMascota.orElse(null);
	}

	@Override
	public List<MascotaRescue> obtenerTodasLasMascotas() {
		return mascotaRepository.findAll();
	}

	@Override
	public boolean eliminarMascota(Long id) {
		if (mascotaRepository.existsById(id)) {
			mascotaRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public MascotaRescue actualizarMascota(MascotaRescue mascota) {
		return mascotaRepository.save(mascota);
	}

}
