import { Component, OnInit } from '@angular/core';
import { HeaderRegistradoComponent } from '../layout/header-registrado/header-registrado.component';
import { AdopcionService } from '../services/adopcion.service';
import { MascotaAdop } from '../model/mascota-adop';
@Component({
  selector: 'app-adoption-list',
  standalone: true,
  imports: [HeaderRegistradoComponent],
  templateUrl: './adoption-list.component.html',
  styleUrl: './adoption-list.component.css'
})
export class AdoptionListComponent implements OnInit{
  dog: MascotaAdop[] = [];

  constructor(private adopcioService: AdopcionService) { }

  ngOnInit(): void {
    this.loadDogs();
  }

  loadDogs(): void {
    this.adopcioService.getListaAdopcion().subscribe((data: MascotaAdop[]) => {
      this.dog = data;
    });
  }
}
