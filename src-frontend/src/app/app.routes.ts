import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { roleoGuard, userGuard } from './roleo.guard';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { VolunteerDashboardComponent } from './volunteer-dashboard/volunteer-dashboard.component';


export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'home', component: HomeComponent },
  { path: 'adminDash', component: AdminDashboardComponent, canMatch: [roleoGuard] },
  { path: 'userDash', component: UserDashboardComponent, canMatch: [userGuard] },
  { path: 'volunteerDash', component: VolunteerDashboardComponent, canMatch: [userGuard] },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
];
