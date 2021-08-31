import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { SignupComponent } from './auth/signup/signup.component';
import { LoginGuard } from './guards/login.service';
import { RoleGuard } from './guards/role.service';
import { HomeComponent } from './home/home.component';
import { IzjasnjenjeComponent } from './izjasnjenje/izjasnjenje.component';
import { IzvestajComponent } from './izvestaj/izvestaj.component';
import { AddObavestenjaComponent } from './obavestenja/add-obavestenja/add-obavestenja.component';
import { ListaObavestenjaSluzbenikComponent } from './obavestenja/lista-obavestenja-sluzbenik/lista-obavestenja-sluzbenik.component';
import { ListaObavestenjaComponent } from './obavestenja/lista-obavestenja/lista-obavestenja.component';
import { AddZahtevComponent } from './zahtev/add-zahtev/add-zahtev.component';
import { ListaZahtevSluzbenikComponent } from './zahtev/lista-zahtev-sluzbenik/lista-zahtev-sluzbenik.component';
import { ListaZahtevComponent } from './zahtev/lista-zahtev/lista-zahtev.component';

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
    path : 'kreirajZahtev',
    component : AddZahtevComponent,
    canActivate: [RoleGuard],
		data: {expectedRoles: 'ROLE_GRADJANIN'}
  },
  {
    path : 'zahtevi',
    component : ListaZahtevComponent,
    canActivate: [RoleGuard],
		data: {expectedRoles: 'ROLE_GRADJANIN'}
  },
  {
    path : 'zahteviSluzbenik',
    component : ListaZahtevSluzbenikComponent,
    canActivate: [RoleGuard],
		data: {expectedRoles: 'ROLE_SLUZBENIK'}
  },
  {
    path : 'kreirajObavestenje/:idZahtev',
    component : AddObavestenjaComponent,
    canActivate: [RoleGuard],
		data: {expectedRoles: 'ROLE_SLUZBENIK'}
  },
  {
    path : 'obavestenja',
    component : ListaObavestenjaComponent,
    canActivate: [RoleGuard],
		data: {expectedRoles: 'ROLE_GRADJANIN'}
  },
  {
    path : 'obavestenjaSluzbenik',
    component : ListaObavestenjaSluzbenikComponent,
    canActivate: [RoleGuard],
		data: {expectedRoles: 'ROLE_SLUZBENIK'}
  },
  {
    path : 'izvestaji',
    component : IzvestajComponent,
    canActivate: [RoleGuard],
		data: {expectedRoles: 'ROLE_SLUZBENIK'}
  },
    {
    path : 'izjasnjenja',
    component : IzjasnjenjeComponent,
    canActivate: [RoleGuard],
		data: {expectedRoles: 'ROLE_SLUZBENIK'}
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
