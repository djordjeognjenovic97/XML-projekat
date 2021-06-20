import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { SignupComponent } from './auth/signup/signup.component';
import { LoginGuard } from './guards/login.service';
import { RoleGuard } from './guards/role.service';
import { HomeComponent } from './home/home.component';
import { ListaObavestenjaComponent } from './obavestenja/lista-obavestenja/lista-obavestenja.component';
import { AddZahtevComponent } from './zahtev/add-zahtev/add-zahtev.component';
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
    path : 'obavestenja',
    component : ListaObavestenjaComponent,
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
