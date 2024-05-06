package com.daw2.proyecto.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.daw2.proyecto.model.User;
import com.daw2.proyecto.payload.UserDto;
import com.daw2.proyecto.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository UserRepository;

	@Override
	public User createUser(User User) {
		return UserRepository.save(User);
	}

	@Override
	public User findUserById(Long id) {
		Optional<User> optionalUser = UserRepository.findById(id);
		return optionalUser.orElse(null);
	}

	@Override
	public List<User> findAllUsers() {
		return UserRepository.findAll();
	}

	@Override
	public boolean deleteUser(Long id) {
		if (UserRepository.existsById(id)) {
			UserRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public User updateUser(User User) {
		return UserRepository.save(User);
	}

	@Override
	public UserDetailsService userDetailsService() {
		return new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String nombre) {
				return UserRepository.findByEmail(nombre)
						.orElseThrow(() -> new UsernameNotFoundException("User no encontrado"));
			}
		};
	}

	@Override
	public List<UserDto> findAll() {
		List<UserDto> Users = UserRepository.findAll().stream().map(
				User -> new UserDto(User.getName(), User.getSurname(), User.getEmail(), User.getRoles().toString()))
				.collect(Collectors.toList());
		return Users;
	}
}
