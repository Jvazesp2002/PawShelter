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
export class AdoptionListComponent implements OnInit{
  dogs: MascotaAdop[] = [];


  constructor(private adopcioService: AdopcionService) { }

  ngOnInit(): void {
    this.loadDogs();
  }

  loadDogs(): void {
    this.adopcioService.getListaAdopcion().subscribe((data: MascotaAdop[]) => {
      this.dogs = data;
    });
  }
}
