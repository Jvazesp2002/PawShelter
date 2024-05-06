package com.daw2.proyecto.service;

import com.daw2.proyecto.payload.request.LoginRequest;
import com.daw2.proyecto.payload.request.SignupRequest;
import com.daw2.proyecto.payload.response.JwtResponse;

public interface AuthenticationService {
	JwtResponse signup(SignupRequest request);

	JwtResponse signin(LoginRequest request);
}
