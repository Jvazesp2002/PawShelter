package com.daw2.proyectoFinal.services;

import java.util.List;

import com.daw2.proyectoFinal.model.MascotaGuar;

public interface MascotaGuarService {
	MascotaGuar crearMascota(MascotaGuar mascota);

	MascotaGuar obtenerMascotaPorId(Long id);

	List<MascotaGuar> obtenerTodasLasMascotas();

	MascotaGuar actualizarMascota(MascotaGuar mascota);

	boolean eliminarMascota(Long id);
}
