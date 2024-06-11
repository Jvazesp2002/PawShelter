import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { GuarderiaService } from '../services/guarderia.service';
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
    private mascotaService: GuarderiaService
  ) { }
  irAUserDash() {
    this.router.navigate(['/userDash']);
  }

  crearMascota(): void {
    console.log(this.mascota);
    const token = localStorage.getItem('token');
    const newMascota = {
      nombre: this.mascota.nombre,
      edad: this.mascota.edad,
      raza: this.mascota.raza,
      dias: this.mascota.dias
    }
    this.mascotaService.createMascotaGuarderia(newMascota).subscribe({
      next: () => {
        this.openModalCerrar();
      },
      error: (error: any) => {
        console.error('Error al crear la mascota', error);
      },
      complete: () => {
        console.log('Petición para crear la mascota completada');
      }
    });
    {
      console.error('Error desconocido');
    }
  }

  isModalOpen = false;
  isModalCerrar = false;

  openModalCerrar() {
    this.isModalCerrar = true;
  }

  closeModalCerrar() {
    this.isModalCerrar = false;
  }
}
