import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { MascotaGuarderiaServiceService } from '../services/mascota-guarderia-service.service';

@Component({
  selector: 'app-daycare-form',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink],
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
    private mascotaService: MascotaGuarderiaServiceService
  ) { }
  irAUserDash() {
    this.router.navigate(['/userDash']);
  }

  crearMascota(): void {
    console.log(this.mascota);
    const token = localStorage.getItem('token');
    if (token) {
      const newMascota = {
        nombre: this.mascota.nombre,
        edad: this.mascota.edad,
        raza: this.mascota.raza,
        dias: this.mascota.dias
      }
      this.mascotaService.crearPet(newMascota, token).subscribe({
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
    } else {
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
