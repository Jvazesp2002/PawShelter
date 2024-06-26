package com.daw2.proyectoFinal.servicesImpl;

import java.util.Optional;

import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.daw2.proyectoFinal.dtos.request.LoginRequest;
import com.daw2.proyectoFinal.dtos.request.RegistroRequest;
import com.daw2.proyectoFinal.dtos.response.JwtAuthenticationResponse;
import com.daw2.proyectoFinal.model.Rol;
import com.daw2.proyectoFinal.model.Usuario;
import com.daw2.proyectoFinal.repository.UsuarioRepository;
import com.daw2.proyectoFinal.services.AuthenticationService;
import com.daw2.proyectoFinal.services.JwtService;

/**
 * Implementación del servicio de autenticación que proporciona funcionalidades para
 * registro (signup) e inicio de sesión (signin) de usuarios.
 */
@Builder
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    /**
     * Inyección del repositorio de usuario.
     */
    @Autowired
    private UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    /**
     * Constructor de la clase AuthenticationServiceImpl.
     *
     * @param usuarioRepository     Repositorio de usuarios para acceder a los datos de los usuarios.
     * @param passwordEncoder       Codificador de contraseñas para codificar las contraseñas de los usuarios.
     * @param jwtService            Servicio JWT para generar tokens de autenticación.
     * @param authenticationManager Administrador de autenticación para autenticar a los usuarios.
     */
    public AuthenticationServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, JwtService jwtService,
                                     AuthenticationManager authenticationManager) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    /**
     * Registra a un nuevo usuario en el sistema.
     *
     * @param request Objeto RegistroRequest con los datos del usuario a registrar.
     * @return Objeto JwtAuthenticationResponse con el token de autenticación generado.
     * @throws IllegalArgumentException Si el email proporcionado ya está en uso.
     */
    @Override
    public JwtAuthenticationResponse signup(RegistroRequest request) {
        if (usuarioRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email ya está en uso.");
        }

        Usuario user = new Usuario();
        user.setNombre(request.getNombre());
        user.setEmail(request.getEmail());
        user.setContrasena(passwordEncoder.encode(request.getContrasena()));
        user.getRoles().add(Rol.USUARIO);
        usuarioRepository.save(user);
        String jwt = jwtService.generateToken(user);

        JwtAuthenticationResponse.UserResponse userResponse = new JwtAuthenticationResponse.UserResponse(
                user,
                jwt
        );

        return JwtAuthenticationResponse.builder()
                .user(userResponse)
                .build();
    }


    /**
     * Inicia sesión para un usuario existente.
     *
     * @param request Objeto LoginRequest con las credenciales del usuario.
     * @return Objeto JwtAuthenticationResponse con el token de autenticación generado.
     * @throws IllegalArgumentException Si el email o la contraseña proporcionados son inválidos.
     */
    @Override
    public JwtAuthenticationResponse signin(LoginRequest request) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getContrasena()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        Optional<Usuario> optionalUser = usuarioRepository.findByEmail(request.getEmail());

        Usuario user = optionalUser.orElseThrow(() -> new IllegalArgumentException("Email o contraseña inválidos."));
        String jwt = jwtService.generateToken(user);

        JwtAuthenticationResponse.UserResponse userResponse = new JwtAuthenticationResponse.UserResponse(
                user,
                jwt
        );

        return JwtAuthenticationResponse.builder()
                .user(userResponse)
                .build();
    }

}

