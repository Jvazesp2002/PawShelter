import { Component } from '@angular/core';
import { HeaderRegistradoComponent } from '../layout/header-registrado/header-registrado.component';

@Component({
  selector: 'app-volunteer-dashboard',
  standalone: true,
  imports: [HeaderRegistradoComponent],
  templateUrl: './volunteer-dashboard.component.html',
  styleUrl: './volunteer-dashboard.component.css'
})
export class VolunteerDashboardComponent {

}
