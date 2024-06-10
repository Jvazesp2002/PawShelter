package com.daw2.proyectoFinal.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.daw2.proyectoFinal.model.Rol;
import com.daw2.proyectoFinal.model.Usuario;
import com.daw2.proyectoFinal.repository.UsuarioRepository;

@Component
public class DataInitializer implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;


	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) {

		Usuario usuario1 = new Usuario();
		Usuario usuario2 = new Usuario();
		Usuario admin = new Usuario();


			usuario1.setNombre("usuarioejemplo");
			usuario1.setApellidos("1234");
			usuario1.setEmail("usuarioejemplo@gmail.com");
			usuario1.setContrasena(passwordEncoder.encode("1234"));
			usuario1.getRoles().add(Rol.USUARIO);
			usuarioRepository.save(usuario1);

			usuario2.setNombre("usuariovoluntario");
			usuario2.setApellidos("123");
			usuario2.setEmail("voluntario@gmail.com");
			usuario2.setContrasena(passwordEncoder.encode("1234"));
			usuario2.getRoles().add(Rol.VOLUNTARIO);
			usuarioRepository.save(usuario2);

			admin.setNombre("admin");
			admin.setApellidos("admin");
			admin.setEmail("admin@gmail.com");
			admin.setContrasena(passwordEncoder.encode("admin"));
			admin.getRoles().add(Rol.ADMINISTRADOR);
			usuarioRepository.save(admin);

	}

}
