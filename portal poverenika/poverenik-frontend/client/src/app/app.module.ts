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
import { ListaZalbeComponent } from './zalbeGradjanin/lista-zalbe/lista-zalbe.component';
import { AddZalbaCutanjeComponent } from './zalbeGradjanin/add-zalba-cutanje/add-zalba-cutanje.component';
import { AddZalbaOdbijenComponent } from './zalbeGradjanin/add-zalba-odbijen/add-zalba-odbijen.component';
import { ListaResenjaComponent } from './resenjaGradjanin/lista-resenja/lista-resenja.component';
import { ListaZalbaCutanjeComponent } from './zalbeGradjanin/lista-zalba-cutanje/lista-zalba-cutanje.component';
import { ListaZalbaOdbijenComponent } from './zalbeGradjanin/lista-zalba-odbijen/lista-zalba-odbijen.component';
import { ListaZalbaOdbijenPoverenikComponent } from './zalbePoverenik/lista-zalba-odbijen-poverenik/lista-zalba-odbijen-poverenik.component';
import { ListaZalbaCutanjePoverenikComponent } from './zalbePoverenik/lista-zalba-cutanje-poverenik/lista-zalba-cutanje-poverenik.component';
import { ListaResenjaPoverenikComponent } from './resenjaPoverenik/lista-resenja-poverenik/lista-resenja-poverenik.component';
import { AddResenjaPoverenikComponent } from './resenjaPoverenik/add-resenja-poverenik/add-resenja-poverenik.component';
import { ListaIzvestajaPoverenikComponent } from './izvestajiPoverenik/lista-izvestaja-poverenik/lista-izvestaja-poverenik.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    NavbarComponent,
    HomeComponent,
    ListaZalbeComponent,
    AddZalbaCutanjeComponent,
    AddZalbaOdbijenComponent,
    ListaResenjaComponent,
    ListaZalbaCutanjeComponent,
    ListaZalbaOdbijenComponent,
    ListaZalbaOdbijenPoverenikComponent,
    ListaZalbaCutanjePoverenikComponent,
    ListaResenjaPoverenikComponent,
    AddResenjaPoverenikComponent,
    ListaIzvestajaPoverenikComponent
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
