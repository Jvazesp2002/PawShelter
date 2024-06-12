import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { JwtService } from '../services/jwt-service.service';
import { jwtDecode } from 'jwt-decode';
import { Router } from '@angular/router';
import { HeaderComponent } from '../layout/header/header.component';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule, HeaderComponent],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  email: string = '';
  password: string = '';
  nombre: string = '';
  token: string = '';

  constructor(private authService: AuthService, private jwtService: JwtService, private router: Router) { }

  login() {
    console.log(this.email);
    console.log(this.password);

    const credentials = {
      email: this.email,
      contrasena: this.password
    };

    this.authService.login(credentials).subscribe({
      next: (resp) => {
        console.log(resp);
        console.log(resp.user.token);
        this.token = resp.user.token;

        this.jwtService.saveToken(resp.user.token);
        window.localStorage["varemo"] = this.password;
        this.redirectUserByRole();
      },
      error: (error) => {
        console.error('Error de autenticación:', error);
      },
      complete: () => {
        console.log('He terminado la petición')
      }
    });
  }

  register() {
    console.log(this.nombre);
    console.log(this.email);
    console.log(this.password);

    const credentials = {
      nombre: this.nombre,
      email: this.email,
      contrasena: this.password
    };

    this.authService.register(credentials).subscribe({
      next: (resp) => {
        console.log(resp);
        console.log(resp.user.token);
        this.token = resp.user.token;

        this.jwtService.saveToken(resp.user.token);
        this.redirectUserByRole();
      },
      error: (error) => {
        console.error('Error de autenticación:', error);
      },
      complete: () => {
        console.log('He terminado la petición')
      }
    });
  }

  redirectUserByRole() {
    // Verificar si hay un token guardado en el almacenamiento local
    const token = localStorage.getItem('token');
    if (token) {
      try {
        // Decodificar el token
        const decodedToken: any = jwtDecode(token);
        // Verificar si el token contiene información de rol
        if (decodedToken && decodedToken.role && decodedToken.role.length > 0) {
          // Obtener el rol del usuario (asumimos que solo hay un rol en el token)
          const userRole = decodedToken.role[0].authority;
          // Redirigir al usuario a la página correspondiente según su rol
          if (userRole === 'ADMINISTRADOR') {
            window.location.href = '/adminDash';
          } else {
            window.location.href = '/userDash';
          }
          if (userRole === 'VOLUNTARIO') {
            window.location.href = '/volunteerDash';
          } else {
            window.location.href = '/userDash';
          }
        } else {
          console.error('El token no contiene información de rol.');
        }
      } catch (error) {
        console.error('Error al decodificar el token:', error);
      }
    }
  }
}
