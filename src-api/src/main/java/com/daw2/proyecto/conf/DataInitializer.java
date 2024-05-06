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
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) {

		User user1 = new User();
		User user2 = new User();
		User admin = new User();

			user1.setName("Userejemplo");
			user1.setSurname("1234");
			user1.setEmail("userejemplo@gmail.com");
			user1.setPass(passwordEncoder.encode("1234"));
			user1.getRoles().add(Role.ROLE_USER);
			userRepository.save(user1);

			user2.setName("voluntarioejemplo");
			user2.setSurname("1234");
			user2.setEmail("voluntario@gmail.com");
			user2.setPass(passwordEncoder.encode("1234"));
			user2.getRoles().add(Role.ROLE_VOLUNTEER);
			userRepository.save(user2);

			admin.setName("admin");
			admin.setSurname("admin");
			admin.setEmail("admin@gmail.com");
			admin.setPass(passwordEncoder.encode("admin"));
			admin.getRoles().add(Role.ROLE_ADMIN);
			userRepository.save(admin);

	}
}
