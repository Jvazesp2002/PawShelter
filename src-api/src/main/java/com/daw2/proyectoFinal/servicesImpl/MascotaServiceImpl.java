package com.daw2.proyectoFinal.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.daw2.proyectoFinal.model.MascotaAdop;
import com.daw2.proyectoFinal.repository.MascotaRepository;
import com.daw2.proyectoFinal.services.MascotaService;

public class MascotaServiceImpl implements MascotaService{

	 @Autowired
	    private MascotaRepository mascotaRepository;

	    @Override
	    public MascotaAdop crearMascota(MascotaAdop mascota) {
	        return mascotaRepository.save(mascota);
	    }

	    @Override
	    public MascotaAdop obtenerMascotaPorId(Long id) {
	        Optional<MascotaAdop> optionalMascota = mascotaRepository.findById(id);
	        return optionalMascota.orElse(null);
	    }

	    @Override
	    public List<MascotaAdop> obtenerTodasLasMascotas() {
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
	    public MascotaAdop actualizarMascota(MascotaAdop mascota) {
	        return mascotaRepository.save(mascota);
	    }

}
