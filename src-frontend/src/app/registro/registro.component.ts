import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-registro',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './registro.component.html',
  styleUrl: './registro.component.css'
})
export class RegistroComponent {
  email: string = '';
  password: string = '';
  nombre: string = '';
  apellidos: string = '';

  constructor() {}

  register() {
    console.log(this.email);
    console.log(this.password);
    console.log(this.nombre);
    console.log(this.apellidos);
  }
}

