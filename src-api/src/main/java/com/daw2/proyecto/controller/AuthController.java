package com.daw2.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daw2.proyecto.payload.request.LoginRequest;
import com.daw2.proyecto.payload.request.SignupRequest;
import com.daw2.proyecto.payload.response.JwtResponse;
import com.daw2.proyecto.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping("/signup")
	public ResponseEntity<JwtResponse> signup(@RequestBody SignupRequest request) {
		JwtResponse response = authenticationService.signup(request);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/signin")
	public ResponseEntity<JwtResponse> signin(@RequestBody LoginRequest request) {
		JwtResponse response = authenticationService.signin(request);
		return ResponseEntity.ok(response);
	}
}
