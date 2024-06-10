package com.daw2.proyectoFinal.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.daw2.proyectoFinal.model.MascotaGuar;
import com.daw2.proyectoFinal.repository.MascotaGuarRepository;
import com.daw2.proyectoFinal.services.MascotaGuarService;

public class MascotaGuarServiceImpl implements MascotaGuarService {

	@Autowired
	private MascotaGuarRepository mascotaRepository;

	@Override
	public MascotaGuar crearMascota(MascotaGuar mascota) {
		return mascotaRepository.save(mascota);
	}

	@Override
	public MascotaGuar obtenerMascotaPorId(Long id) {
		Optional<MascotaGuar> optionalMascota = mascotaRepository.findById(id);
		return optionalMascota.orElse(null);
	}

	@Override
	public List<MascotaGuar> obtenerTodasLasMascotas() {
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
	public MascotaGuar actualizarMascota(MascotaGuar mascota) {
		return mascotaRepository.save(mascota);
	}

}
