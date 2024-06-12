import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { roleoGuard, userGuard } from './roleo.guard';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { VolunteerDashboardComponent } from './volunteer-dashboard/volunteer-dashboard.component';
import { DaycareFormComponent } from './daycare-form/daycare-form.component';
import { AdoptionListComponent } from './adoption-list/adoption-list.component';
import { AdminDaycareComponent } from './admin-daycare/admin-daycare.component';
import { DaycareListComponent } from './daycare-list/daycare-list.component';


export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'home', component: HomeComponent },
  { path: 'adminDash', component: AdminDashboardComponent, canMatch: [roleoGuard] },
  { path: 'userDash', component: UserDashboardComponent, canMatch: [userGuard] },
  { path: 'volunteerDash', component: VolunteerDashboardComponent, canMatch: [userGuard] },
  { path: 'listadoGuarderia', component: DaycareListComponent, canMatch: [userGuard] },
  { path: 'guarderia', component: DaycareFormComponent, canMatch: [userGuard] },
  { path: 'adopcion', component: AdoptionListComponent, canMatch: [userGuard] },
  { path: 'guarderiaAdmin', component: AdminDaycareComponent, canMatch: [roleoGuard] },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
];
