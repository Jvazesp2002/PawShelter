import { Component, OnInit } from '@angular/core';
import { HeaderRegistradoComponent } from '../layout/header-registrado/header-registrado.component';
import { MascotaGuar } from '../model/mascota-guar';
import { GuarderiaService } from '../services/guarderia.service';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-admin-daycare',
  standalone: true,
  imports: [HeaderRegistradoComponent, NgFor],
  templateUrl: './admin-daycare.component.html',
  styleUrl: './admin-daycare.component.css'
})
export class AdminDaycareComponent implements OnInit{
  dogs: MascotaGuar[] = [];


  constructor(private guarderiaservice: GuarderiaService) { }

  ngOnInit(): void {
    this.loadDogs();
  }

  loadDogs(): void {
    const token = localStorage.getItem('token');
    if (token) {
      this.guarderiaservice.getMascotasGuarderia(token).subscribe({
        next: (data: any[]) => {
          this.dogs = data;
        },
        error: (error) => {
          console.error('Error al obtener la lista de mascotas:', error);
        },
        complete: () => {
          console.log('Petición para obtener la lista de mascotas completa');
          console.log(this.dogs);
        }
      });
    } else {
      console.error('No se encontró el token de autenticación.');
    }
  }
  eliminar(id: number) {
    const token = localStorage.getItem('token');
    if (token) {
      this.guarderiaservice.deleteMascotaGuarderia(id, token).subscribe({
        next: (response) => {
          console.log('Usuario borrado exitosamente:', response);
          // Actualizar la lista de usuarios después de borrar uno
          this.loadDogs();
        },
        error: (error) => {
          console.error('Error al borrar usuario:', error);
        },
        complete: () => {
          console.log('La petición para borrar usuario ha finalizado');
        }
      });
    }
  }
}
