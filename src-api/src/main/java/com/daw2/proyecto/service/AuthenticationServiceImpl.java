package com.daw2.proyecto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.daw2.proyecto.model.Role;
import com.daw2.proyecto.model.User;
import com.daw2.proyecto.payload.request.LoginRequest;
import com.daw2.proyecto.payload.request.SignupRequest;
import com.daw2.proyecto.payload.response.JwtResponse;
import com.daw2.proyecto.repository.UserRepository;

import lombok.Builder;

@Builder
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private UserRepository userRepository;

	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;

	public AuthenticationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
			JwtService jwtService, AuthenticationManager authenticationManager) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
		this.authenticationManager = authenticationManager;
	}

	@Override
	public JwtResponse signup(SignupRequest request) {
		if (userRepository.existsByEmail(request.getEmail())) {
			throw new IllegalArgumentException("Email ya está en uso.");
		}

		User user = new User();
		user.setName(request.getNombre());
		user.setEmail(request.getEmail());
		user.setPass(passwordEncoder.encode(request.getContrasena()));
		user.getRoles().add(Role.ROLE_USER);
		userRepository.save(user);
		String jwt = jwtService.generateToken(user);

		JwtResponse.UserResponse userResponse = new JwtResponse.UserResponse(user, jwt);

		return JwtResponse.builder().user(userResponse).build();
	}

	@Override
	public JwtResponse signin(LoginRequest request) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getContrasena()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		Optional<User> optionalUser = userRepository.findByEmail(request.getEmail());

		User user = optionalUser.orElseThrow(() -> new IllegalArgumentException("Email o contraseña inválidos."));
		String jwt = jwtService.generateToken(user);

		JwtResponse.UserResponse userResponse = new JwtResponse.UserResponse(user, jwt);

		return JwtResponse.builder().user(userResponse).build();
	}
}
