package com.daw2.proyectoFinal.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.daw2.proyectoFinal.dtos.UsuarioDTO;
import com.daw2.proyectoFinal.model.Usuario;

public interface UsuarioService {
    Usuario crearUsuario(Usuario usuario);
    Usuario obtenerUsuarioPorId(Long id);
    List<Usuario> obtenerTodosLosUsuarios();
    Usuario actualizarUsuario(Usuario usuario);
    boolean eliminarUsuario(Long id);
    UserDetailsService userDetailsService();
    List<UsuarioDTO> obtenerTodos();
}

