package com.daw2.proyecto.payload.request;


public class LoginRequest {
    private String email;
    private String password;

    /**
     * Constructor por defecto.
     */
    public LoginRequest() {
    }

    /**
     * Constructor que toma el correo electrónico y la contraseña de la solicitud.
     *
     * @param email      El correo electrónico proporcionado en la solicitud.
     * @param contrasena La contraseña proporcionada en la solicitud.
     */
    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * Obtiene el correo electrónico de la solicitud.
     *
     * @return El correo electrónico de la solicitud.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico de la solicitud.
     *
     * @param email El correo electrónico de la solicitud.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene la contraseña de la solicitud.
     *
     * @return La contraseña de la solicitud.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña de la solicitud.
     *
     * @param contrasena La contraseña de la solicitud.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}