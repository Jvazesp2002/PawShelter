package com.daw2.proyecto.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.daw2.proyecto.model.Rol;
import com.daw2.proyecto.model.Usuario;
import com.daw2.proyecto.repository.UsuarioRepository;
import com.daw2.proyecto.services.UsuarioService;

@Component
public class DataInitializer implements CommandLineRunner {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) {

		Usuario usuario1 = new Usuario();
		Usuario admin = new Usuario();

		if (usuarioService.obtenerUsuarioPorId(1L) == null) {

			usuario1.setNombre("usuarioejemplo");
			usuario1.setApellidos("1234");
			usuario1.setEmail("usuarioejemplo@gmail.com");
			usuario1.setContrasena(passwordEncoder.encode("1234"));
			usuario1.getRoles().add(Rol.USUARIO);
			usuarioRepository.save(usuario1);
			
			usuario1.setNombre("usuarioejemplo2");
			usuario1.setApellidos("1234");
			usuario1.setEmail("usuarioejemplo@gmail.com");
			usuario1.setContrasena(passwordEncoder.encode("1234"));
			usuario1.getRoles().add(Rol.VOLUNTARIO);
			usuarioRepository.save(usuario1);

			admin.setNombre("admin");
			admin.setApellidos("admin");
			admin.setEmail("admin@gmail.com");
			admin.setContrasena(passwordEncoder.encode("admin"));
			admin.getRoles().add(Rol.ADMINISTRADOR);
			usuarioRepository.save(admin);
		}
	}
}