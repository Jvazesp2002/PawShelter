package com.daw2.proyecto.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.daw2.proyecto.model.User;
import com.daw2.proyecto.payload.UserDto;

public interface UserService {
    User createUser(User User);
    User findUserById(Long id);
    List<User> findAllUsers();
    User updateUser(User User);
    boolean deleteUser(Long id);
    UserDetailsService userDetailsService();
    List<UserDto> findAll();
}
