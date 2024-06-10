package com.daw2.proyectoFinal.services;

import java.util.List;

import com.daw2.proyectoFinal.model.MascotaAdop;

public interface MascotaService {
	MascotaAdop crearMascota(MascotaAdop mascota);

	MascotaAdop obtenerMascotaPorId(Long id);

	List<MascotaAdop> obtenerTodasLasMascotas();

	MascotaAdop actualizarMascota(MascotaAdop mascota);

	boolean eliminarMascota(Long id);
}
