package com.daw2.proyectoFinal.services;

import java.util.List;

import com.daw2.proyectoFinal.model.MascotaRescue;
public interface MascotaRescService {
	MascotaRescue crearMascota(MascotaRescue mascota);

	MascotaRescue obtenerMascotaPorId(Long id);

	List<MascotaRescue> obtenerTodasLasMascotas();

	MascotaRescue actualizarMascota(MascotaRescue mascota);

	boolean eliminarMascota(Long id);
}
