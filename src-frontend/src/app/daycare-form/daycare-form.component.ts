import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { HeaderRegistradoComponent } from '../layout/header-registrado/header-registrado.component';

@Component({
  selector: 'app-daycare-form',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink, HeaderRegistradoComponent],
  templateUrl: './daycare-form.component.html',
  styleUrl: './daycare-form.component.css'
})
export class DaycareFormComponent {
  mascota = {
    nombre: '',
    edad: '',
    raza: '',
    dias: ''
  };

  constructor(
    private route: ActivatedRoute,
    private router: Router,
  ) { }
  irAUserDash() {
    this.router.navigate(['/userDash']);
  }
}
