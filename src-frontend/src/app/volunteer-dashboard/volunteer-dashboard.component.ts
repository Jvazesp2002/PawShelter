import { Component } from '@angular/core';
import { HeaderRegistradoComponent } from '../layout/header-registrado/header-registrado.component';
import { RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-volunteer-dashboard',
  standalone: true,
  imports: [RouterLink, RouterLinkActive, HeaderRegistradoComponent],
  templateUrl: './volunteer-dashboard.component.html',
  styleUrl: './volunteer-dashboard.component.css'
})
export class VolunteerDashboardComponent {

}
