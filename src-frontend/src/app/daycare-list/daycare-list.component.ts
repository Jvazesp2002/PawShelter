import { Component, OnInit } from '@angular/core';
import { MascotaGuar } from '../model/mascota-guar';
import { GuarderiaService } from '../services/guarderia.service';
import { HeaderRegistradoComponent } from '../layout/header-registrado/header-registrado.component';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-daycare-list',
  standalone: true,
  imports: [HeaderRegistradoComponent, NgFor],
  templateUrl: './daycare-list.component.html',
  styleUrl: './daycare-list.component.css'
})
export class DaycareListComponent implements OnInit{
  dogs: MascotaGuar[] = [];


  constructor(private guarderiaservice: GuarderiaService) { }

  ngOnInit(): void {
    this.loadDogs();
  }

  loadDogs(): void {
    this.guarderiaservice.getMascotasGuarderia().subscribe((data: MascotaGuar[]) => {
      this.dogs = data;
    });
  }
}
