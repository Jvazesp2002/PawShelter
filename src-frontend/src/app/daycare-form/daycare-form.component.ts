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
    name: '',
    age:  0,
    breed: '',
    stayDays: 0
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
    if (token) {
      const newTarea = {
        name: this.mascota.name,
        age: this.mascota.age,
        breed: this.mascota.breed,
        stayDays: this.mascota.stayDays,
      }
      this.mascotaService.createMascotaGuarderia(newTarea, token).subscribe({
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
      console.error('Algo ocurrió.');
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
