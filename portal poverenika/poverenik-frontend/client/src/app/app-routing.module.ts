import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { SignupComponent } from './auth/signup/signup.component';
import { LoginGuard } from './guards/login.service';
import { RoleGuard } from './guards/role.service';
import { HomeComponent } from './home/home.component';
import { ListaResenjaComponent } from './resenjaGradjanin/lista-resenja/lista-resenja.component';
import { AddZalbaCutanjeComponent } from './zalbeGradjanin/add-zalba-cutanje/add-zalba-cutanje.component';
import { AddZalbaOdbijenComponent } from './zalbeGradjanin/add-zalba-odbijen/add-zalba-odbijen.component';
import { ListaZalbeComponent } from './zalbeGradjanin/lista-zalbe/lista-zalbe.component';

const routes: Routes = [
  {
    path : '',
    component : HomeComponent
  },
  {
    path : 'login',
    component : LoginComponent,
		canActivate: [LoginGuard]
  },
  {
    path : 'kreirajZalbaCutanje',
    component : AddZalbaCutanjeComponent,
    canActivate: [RoleGuard],
		data: {expectedRoles: 'ROLE_GRADJANIN'}
  },
  {
    path : 'kreirajZalbaOdbijen',
    component : AddZalbaOdbijenComponent,
    canActivate: [RoleGuard],
		data: {expectedRoles: 'ROLE_GRADJANIN'}
  },
  {
    path : 'zalbe-gradjanin',
    component : ListaZalbeComponent,
    canActivate: [RoleGuard],
		data: {expectedRoles: 'ROLE_GRADJANIN'}
  },
  {
    path : 'resenja-gradjanin',
    component : ListaResenjaComponent,
    canActivate: [RoleGuard],
		data: {expectedRoles: 'ROLE_GRADJANIN'}
  },
  {
    path : 'registration',
    component : SignupComponent,
		canActivate: [LoginGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {onSameUrlNavigation: 'reload'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
