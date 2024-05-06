package com.daw2.proyecto.payload.response;

import com.daw2.proyecto.model.User;

public class JwtResponse {
	private UserResponse user;

	public JwtResponse(UserResponse user) {
		this.user = user;
	}

	public UserResponse getUser() {
		return user;
	}

	public void setUser(UserResponse user) {
		this.user = user;
	}

	public static JwtAuthenticationResponseBuilder builder() {
		return new JwtAuthenticationResponseBuilder();
	}

	public static class JwtAuthenticationResponseBuilder {
		private UserResponse user;

		public JwtAuthenticationResponseBuilder user(UserResponse user) {
			this.user = user;
			return this;
		}

		public JwtResponse build() {
			return new JwtResponse(user);
		}
	}

	public static class UserResponse {
		private String email;
		private String name;
		private String rol;
		private String token;

		public UserResponse(User user, String token) {
			this.email = user.getEmail();
			this.name = user.getName();
			this.rol = user.getRoles().toString();
			this.token = token;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getRol() {
			return rol;
		}

		public void setRol(String rol) {
			this.rol = rol;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}
	}
}
