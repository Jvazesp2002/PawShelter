import { Component, OnInit } from '@angular/core';
import { HeaderRegistradoComponent } from '../layout/header-registrado/header-registrado.component';
import { AdopcionService } from '../services/adopcion.service';
import { MascotaAdop } from '../model/mascota-adop';
import { NgFor } from '@angular/common';
@Component({
  selector: 'app-adoption-list',
  standalone: true,
  imports: [HeaderRegistradoComponent, NgFor],
  templateUrl: './adoption-list.component.html',
  styleUrl: './adoption-list.component.css'
})
export class AdoptionListComponent implements OnInit {
  dogs: MascotaAdop[] = [];


  constructor(private adopcioService: AdopcionService) { }

  ngOnInit(): void {
    this.loadDogs();
  }

  loadDogs(): void {
    const token = localStorage.getItem('token');
    if (token) {
      this.adopcioService.getListaAdopcion(token).subscribe({
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

  adoptar(id: number) {
    const token = localStorage.getItem('token');
    if (token) {
      this.adopcioService.deleteMascotaAdopcion(id, token).subscribe({
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
