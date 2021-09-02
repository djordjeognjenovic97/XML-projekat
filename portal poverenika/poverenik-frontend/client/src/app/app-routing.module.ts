import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { SignupComponent } from './auth/signup/signup.component';
import { LoginGuard } from './guards/login.service';
import { RoleGuard } from './guards/role.service';
import { HomeComponent } from './home/home.component';
import { ListaIzvestajaPoverenikComponent } from './izvestajiPoverenik/lista-izvestaja-poverenik/lista-izvestaja-poverenik.component';
import { ListaResenjaComponent } from './resenjaGradjanin/lista-resenja/lista-resenja.component';
import { AddResenjaPoverenikComponent } from './resenjaPoverenik/add-resenja-poverenik/add-resenja-poverenik.component';
import { ListaResenjaPoverenikComponent } from './resenjaPoverenik/lista-resenja-poverenik/lista-resenja-poverenik.component';
import { AddZalbaCutanjeComponent } from './zalbeGradjanin/add-zalba-cutanje/add-zalba-cutanje.component';
import { AddZalbaOdbijenComponent } from './zalbeGradjanin/add-zalba-odbijen/add-zalba-odbijen.component';
import { ListaZalbaCutanjeComponent } from './zalbeGradjanin/lista-zalba-cutanje/lista-zalba-cutanje.component';
import { ListaZalbaOdbijenComponent } from './zalbeGradjanin/lista-zalba-odbijen/lista-zalba-odbijen.component';
import { ListaZalbaCutanjePoverenikComponent } from './zalbePoverenik/lista-zalba-cutanje-poverenik/lista-zalba-cutanje-poverenik.component';
import { ListaZalbaOdbijenPoverenikComponent } from './zalbePoverenik/lista-zalba-odbijen-poverenik/lista-zalba-odbijen-poverenik.component';


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
    path : 'zalbec-gradjanin',
    component : ListaZalbaCutanjeComponent,
    canActivate: [RoleGuard],
		data: {expectedRoles: 'ROLE_GRADJANIN'}
  },
  {
    path : 'zalbeo-gradjanin',
    component : ListaZalbaOdbijenComponent,
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
    path : 'zalbec-poverenik',
    component : ListaZalbaCutanjePoverenikComponent,
    canActivate: [RoleGuard],
		data: {expectedRoles: 'ROLE_POVERENIK'}
  },
  {
    path : 'zalbeo-poverenik',
    component : ListaZalbaOdbijenPoverenikComponent,
    canActivate: [RoleGuard],
		data: {expectedRoles: 'ROLE_POVERENIK'}
  },
  {
    path : 'resenja-poverenik',
    component : ListaResenjaPoverenikComponent,
    canActivate: [RoleGuard],
		data: {expectedRoles: 'ROLE_POVERENIK'}
  },
  {
    path : 'izvestaji-poverenik',
    component : ListaIzvestajaPoverenikComponent,
    canActivate: [RoleGuard],
		data: {expectedRoles: 'ROLE_POVERENIK'}
  },
  {
    path : 'add-resenje/:id',
    component : AddResenjaPoverenikComponent,
    canActivate: [RoleGuard],
		data: {expectedRoles: 'ROLE_POVERENIK'}
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
