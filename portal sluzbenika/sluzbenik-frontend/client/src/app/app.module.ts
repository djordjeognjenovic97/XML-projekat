import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './auth/login/login.component';
import { SignupComponent } from './auth/signup/signup.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Interceptor } from './interceptors/intercept.service';
import { NavbarComponent } from './navbar/navbar.component';
import { ToastrModule } from 'ngx-toastr';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import { HomeComponent } from './home/home.component';
import { AddZahtevComponent } from './zahtev/add-zahtev/add-zahtev.component';
import { ListaZahtevComponent } from './zahtev/lista-zahtev/lista-zahtev.component';
import { ListaObavestenjaComponent } from './obavestenja/lista-obavestenja/lista-obavestenja.component';
import { ListaZahtevSluzbenikComponent } from './zahtev/lista-zahtev-sluzbenik/lista-zahtev-sluzbenik.component';
import { AddObavestenjaComponent } from './obavestenja/add-obavestenja/add-obavestenja.component';
import { ListaObavestenjaSluzbenikComponent } from './obavestenja/lista-obavestenja-sluzbenik/lista-obavestenja-sluzbenik.component';
import { IzvestajComponent } from './izvestaj/izvestaj.component';
import { IzjasnjenjeComponent } from './izjasnjenje/izjasnjenje.component';
import { TemplejtComponent } from './templejt/templejt.component';
import { ListaResenjaSluzbenikComponent } from './lista-resenja-sluzbenik/lista-resenja-sluzbenik.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    NavbarComponent,
    HomeComponent,
    AddZahtevComponent,
    ListaZahtevComponent,
    ListaObavestenjaComponent,
    ListaZahtevSluzbenikComponent,
    AddObavestenjaComponent,
    ListaObavestenjaSluzbenikComponent,
    IzvestajComponent,
    IzjasnjenjeComponent,
    TemplejtComponent,
    ListaResenjaSluzbenikComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    ToastrModule.forRoot(),
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    BrowserAnimationsModule
  ],
  providers: [{provide: HTTP_INTERCEPTORS, useClass: Interceptor, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
