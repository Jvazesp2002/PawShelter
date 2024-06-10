package com.daw2.proyectoFinal.servicesImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.daw2.proyectoFinal.dtos.UsuarioDTO;
import com.daw2.proyectoFinal.model.Usuario;
import com.daw2.proyectoFinal.repository.UsuarioRepository;
import com.daw2.proyectoFinal.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario obtenerUsuarioPorId(Long id) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        return optionalUsuario.orElse(null);
    }

    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public boolean eliminarUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

	@Override
	public UserDetailsService userDetailsService() {
		return new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String nombre) {
				return usuarioRepository.findByEmail(nombre)
						.orElseThrow(() -> new UsernameNotFoundException("User no encontrado"));
			}
		};
	}

	@Override
	public List<UsuarioDTO> obtenerTodos() {
		List<UsuarioDTO> Users = usuarioRepository.findAll().stream().map(
				User -> new UsuarioDTO(User.getNombre(), User.getApellidos(), User.getEmail(), User.getRoles().toString()))
				.collect(Collectors.toList());
		return Users;
	}
}
