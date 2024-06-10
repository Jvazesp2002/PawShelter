import { Component } from '@angular/core';
import { HeaderRegistradoComponent } from '../layout/header-registrado/header-registrado.component';

@Component({
  selector: 'app-adoption-list',
  standalone: true,
  imports: [HeaderRegistradoComponent],
  templateUrl: './adoption-list.component.html',
  styleUrl: './adoption-list.component.css'
})
export class AdoptionListComponent {

}
