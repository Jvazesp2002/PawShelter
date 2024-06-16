package com.daw2.proyectoFinal.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.daw2.proyectoFinal.model.MascotaGuar;
import com.daw2.proyectoFinal.model.MascotaResc;
import com.daw2.proyectoFinal.model.Rol;
import com.daw2.proyectoFinal.model.Usuario;
import com.daw2.proyectoFinal.repository.MascotaGuarRepository;
import com.daw2.proyectoFinal.repository.MascotaRescRespository;
import com.daw2.proyectoFinal.repository.UsuarioRepository;
import com.daw2.proyectoFinal.services.UsuarioService;

@Component
public class Initializer implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private MascotaGuarRepository mascotaGuarRepository;

	@Autowired
	private MascotaRescRespository mascotaRescRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UsuarioService usuarioService;

	@Override
	public void run(String... args) {
		if (usuarioService.obtenerUsuarioPorId(1L) == null) {
			Usuario usuario1 = new Usuario();
			Usuario admin = new Usuario();

			usuario1.setNombre("usuarioejemplo");
			usuario1.setApellidos("1234");
			usuario1.setEmail("voluntario@gmail.com");
			usuario1.setContrasena(passwordEncoder.encode("1234"));
			usuario1.getRoles().add(Rol.VOLUNTARIO);
			usuarioRepository.save(usuario1);

			admin.setNombre("admin");
			admin.setApellidos("admin");
			admin.setEmail("admin@gmail.com");
			admin.setContrasena(passwordEncoder.encode("admin"));
			admin.getRoles().add(Rol.ADMINISTRADOR);
			usuarioRepository.save(admin);
			
			MascotaGuar mascota1 = new MascotaGuar();
			mascota1.setName("Firulais");
			mascota1.setAge(2);
			mascota1.setBreed("Labrador");
			mascota1.setStayDays(30);
			mascotaGuarRepository.save(mascota1);

			MascotaGuar mascota2 = new MascotaGuar();
			mascota2.setName("Luna");
			mascota2.setAge(3);
			mascota2.setBreed("Golden Retriever");
			mascota2.setStayDays(45);
			mascotaGuarRepository.save(mascota2);

			MascotaGuar mascota3 = new MascotaGuar();
			mascota3.setName("Rocky");
			mascota3.setAge(1);
			mascota3.setBreed("Bulldog");
			mascota3.setStayDays(20);
			mascotaGuarRepository.save(mascota3);

			MascotaGuar mascota4 = new MascotaGuar();
			mascota4.setName("Max");
			mascota4.setAge(4);
			mascota4.setBreed("Poodle");
			mascota4.setStayDays(60);
			mascotaGuarRepository.save(mascota4);

			MascotaGuar mascota5 = new MascotaGuar();
			mascota5.setName("Bella");
			mascota5.setAge(5);
			mascota5.setBreed("Beagle");
			mascota5.setStayDays(50);
			mascotaGuarRepository.save(mascota5);

			MascotaGuar mascota6 = new MascotaGuar();
			mascota6.setName("Charlie");
			mascota6.setAge(2);
			mascota6.setBreed("Boxer");
			mascota6.setStayDays(25);
			mascotaGuarRepository.save(mascota6);

			MascotaGuar mascota7 = new MascotaGuar();
			mascota7.setName("Lucy");
			mascota7.setAge(6);
			mascota7.setBreed("Dachshund");
			mascota7.setStayDays(70);
			mascotaGuarRepository.save(mascota7);

			MascotaGuar mascota8 = new MascotaGuar();
			mascota8.setName("Duke");
			mascota8.setAge(1);
			mascota8.setBreed("Rottweiler");
			mascota8.setStayDays(15);
			mascotaGuarRepository.save(mascota8);

			MascotaGuar mascota9 = new MascotaGuar();
			mascota9.setName("Sadie");
			mascota9.setAge(3);
			mascota9.setBreed("Pug");
			mascota9.setStayDays(40);
			mascotaGuarRepository.save(mascota9);

			MascotaGuar mascota10 = new MascotaGuar();
			mascota10.setName("Cooper");
			mascota10.setAge(7);
			mascota10.setBreed("Shih Tzu");
			mascota10.setStayDays(80);
			mascotaGuarRepository.save(mascota10);

			MascotaGuar mascota11 = new MascotaGuar();
			mascota11.setName("Molly");
			mascota11.setAge(2);
			mascota11.setBreed("Cocker Spaniel");
			mascota11.setStayDays(35);
			mascotaGuarRepository.save(mascota11);

			MascotaGuar mascota12 = new MascotaGuar();
			mascota12.setName("Buster");
			mascota12.setAge(4);
			mascota12.setBreed("Doberman");
			mascota12.setStayDays(55);
			mascotaGuarRepository.save(mascota12);

			MascotaGuar mascota13 = new MascotaGuar();
			mascota13.setName("Bailey");
			mascota13.setAge(5);
			mascota13.setBreed("Maltese");
			mascota13.setStayDays(65);
			mascotaGuarRepository.save(mascota13);

			MascotaResc adopta1 = new MascotaResc();
			adopta1.setEdad(2);
			adopta1.setRaza("Labrador");
			adopta1.setVacunado("Sí");
			mascotaRescRepository.save(adopta1);

			MascotaResc adopta2 = new MascotaResc();
			adopta2.setEdad(3);
			adopta2.setRaza("Golden Retriever");
			adopta2.setVacunado("Sí");
			mascotaRescRepository.save(adopta2);

			MascotaResc adopta3 = new MascotaResc();
			adopta3.setEdad(1);
			adopta3.setRaza("Bulldog");
			adopta3.setVacunado("No");
			mascotaRescRepository.save(adopta3);

			MascotaResc adopta4 = new MascotaResc();
			adopta4.setEdad(4);
			adopta4.setRaza("Poodle");
			adopta4.setVacunado("Sí");
			mascotaRescRepository.save(adopta4);

			MascotaResc adopta5 = new MascotaResc();
			adopta5.setEdad(5);
			adopta5.setRaza("Beagle");
			adopta5.setVacunado("No");
			mascotaRescRepository.save(adopta5);

			MascotaResc adopta6 = new MascotaResc();
			adopta6.setEdad(2);
			adopta6.setRaza("Boxer");
			adopta6.setVacunado("Sí");
			mascotaRescRepository.save(adopta6);

			MascotaResc adopta7 = new MascotaResc();
			adopta7.setEdad(6);
			adopta7.setRaza("Dachshund");
			adopta7.setVacunado("Sí");
			mascotaRescRepository.save(adopta7);

			MascotaResc adopta8 = new MascotaResc();
			adopta8.setEdad(1);
			adopta8.setRaza("Rottweiler");
			adopta8.setVacunado("No");
			mascotaRescRepository.save(adopta8);

			MascotaResc adopta9 = new MascotaResc();
			adopta9.setEdad(3);
			adopta9.setRaza("Pug");
			adopta9.setVacunado("Sí");
			mascotaRescRepository.save(adopta9);

			MascotaResc adopta10 = new MascotaResc();
			adopta10.setEdad(7);
			adopta10.setRaza("Shih Tzu");
			adopta10.setVacunado("Sí");
			mascotaRescRepository.save(adopta10);

			MascotaResc adopta11 = new MascotaResc();
			adopta11.setEdad(2);
			adopta11.setRaza("Cocker Spaniel");
			adopta11.setVacunado("Sí");
			mascotaRescRepository.save(adopta11);

			MascotaResc adopta12 = new MascotaResc();
			adopta12.setEdad(4);
			adopta12.setRaza("Doberman");
			adopta12.setVacunado("No");
			mascotaRescRepository.save(adopta12);

			MascotaResc adopta13 = new MascotaResc();
			adopta13.setEdad(5);
			adopta13.setRaza("Maltese");
			adopta13.setVacunado("Sí");
			mascotaRescRepository.save(adopta13);

		}
	}
}