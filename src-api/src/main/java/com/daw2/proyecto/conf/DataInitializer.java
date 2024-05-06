package com.daw2.proyecto.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.daw2.proyecto.model.Role;
import com.daw2.proyecto.model.User;
import com.daw2.proyecto.repository.UserRepository;
import com.daw2.proyecto.service.UserService;

@Component
public class DataInitializer implements CommandLineRunner {

	@Autowired
	private UserService UserService;

	@Autowired
	private UserRepository UserRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) {

		User User1 = new User();
		User User2 = new User();
		User admin = new User();

		if (UserService.findUserById(1L) == null) {

			User1.setName("Userejemplo");
			User1.setSurname("1234");
			User1.setEmail("Userejemplo@gmail.com");
			User1.setPass(passwordEncoder.encode("1234"));
			User1.getRoles().add(Role.ROLE_USER);
			UserRepository.save(User1);

			User1.setName("voluntarioejemplo");
			User1.setSurname("1234");
			User1.setEmail("voluntario@gmail.com");
			User1.setPass(passwordEncoder.encode("1234"));
			User1.getRoles().add(Role.ROLE_VOLUNTEER);
			UserRepository.save(User2);

			admin.setName("admin");
			admin.setSurname("admin");
			admin.setEmail("admin@gmail.com");
			admin.setPass(passwordEncoder.encode("admin"));
			admin.getRoles().add(Role.ROLE_ADMIN);
			UserRepository.save(admin);

		}
	}

}
