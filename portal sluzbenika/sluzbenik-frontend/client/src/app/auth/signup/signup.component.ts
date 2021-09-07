import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { User } from 'src/app/models/user';
import { AuthenticationService } from 'src/app/services/authentication.service';

declare var require: any

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {
  regForm:FormGroup;
  user:User=new User(1,"","","","");

  constructor(
    private fBuilder: FormBuilder,
    private router: Router,
    private toastr: ToastrService,
    private authService:AuthenticationService
    ) {
      this.regForm = this.fBuilder.group({
        email: ["", [Validators.required, Validators.email]],
        //username: ["", [Validators.required]],
        ime: ["", [Validators.required]],
        prezime: ["", [Validators.required]],
        password: ["", [Validators.required,Validators.minLength(6)]]
      });
     }
  
    ngOnInit():void {}
  
    regIn(){
      //this.user.email=this.regForm.value["email"];
      //this.user.username=this.regForm.value["username"];
      //this.user.firstname=this.regForm.value["ime"];
      //this.user.lastname=this.regForm.value["prezime"];
      //this.user.password=this.regForm.value["password"];
      const auth: any = { 
        Korisnik: {  _attributes:
          { xmlns: "https://github.com/djordjeognjenovic97/XML-projekat" },
          Ime: { _text: '' },Prezime: { _text: '' },Email: { _text: '' },
          Lozinka: { _text: '' }, Uloga: { _text: '' } } };
      auth.Korisnik.Ime = this.regForm.value["ime"];
      auth.Korisnik.Prezime = this.regForm.value["prezime"];
      auth.Korisnik.Lozinka = this.regForm.value["password"];
      auth.Korisnik.Email = this.regForm.value["email"];
      auth.Korisnik.Uloga = "ROLE_GRADJANIN";
    
      var convert = require('xml-js');
      var authXML = convert.js2xml(auth, {compact: true, ignoreComment: true});
      this.authService.registerUser(authXML).subscribe(
        data=>{
          this.toastr.success('Uspešna registracija. Sada se možete prijaviti.');
          this.regForm.reset();
          this.router.navigate(['/login']);
        },
        error=>{
          this.toastr.error("Neuspešna registracija. Email je već u upotrebi.");
        }
      )
    }
  }
