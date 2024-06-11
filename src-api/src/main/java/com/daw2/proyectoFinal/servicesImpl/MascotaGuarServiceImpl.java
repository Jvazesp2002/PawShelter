package com.daw2.proyectoFinal.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw2.proyectoFinal.model.MascotaGuar;
import com.daw2.proyectoFinal.repository.MascotaGuarRepository;

@Service
public class MascotaGuarServiceImpl {

	@Autowired
	private MascotaGuarRepository mascotaGuarRepository;
	
	public List<MascotaGuar> findAll(){
		return mascotaGuarRepository.findAll();
	}
    public MascotaGuar save(MascotaGuar mascotaGuar) {
        return mascotaGuarRepository.save(mascotaGuar);
    }

    public void deleteById(Long id) {
        mascotaGuarRepository.deleteById(id);
    }
}
