package com.daw2.proyectoFinal.services;

import java.util.List;

import com.daw2.proyectoFinal.model.Mascota;

public interface MascotaService {
	Mascota crearMascota(Mascota mascota);

	Mascota obtenerMascotaPorId(Long id);

	List<Mascota> obtenerTodasLasMascotas();

	Mascota actualizarMascota(Mascota mascota);

	boolean eliminarMascota(Long id);
}
