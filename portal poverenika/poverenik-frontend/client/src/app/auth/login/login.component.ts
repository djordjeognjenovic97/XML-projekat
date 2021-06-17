import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { ToastrService } from 'ngx-toastr';
import { AuthenticationService } from 'src/app/services/authentication.service';

declare var require: any

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  logForm: FormGroup;


  constructor(
    private fBuilder:FormBuilder,
    private router:Router,
    private authenticationService: AuthenticationService,
    private toastr: ToastrService
  ) {
    this.logForm = this.fBuilder.group({
      email: ["", [Validators.required, Validators.email]],
      password: ["", [Validators.required,Validators.minLength(3)]]
    });
   }

  ngOnInit():void {}

  logIn(){
    //_declaration:
      //{ _attributes: { version: '1.0', encoding: 'utf-8' } },
    const auth: any = { 
    User: { 
      Email: { _text: '' }, Lozinka: { _text: '' } } };
    auth.User.Email = this.logForm.value.email;
    auth.User.Lozinka = this.logForm.value.password;

    var convert = require('xml-js');
    var authXML = convert.js2xml(auth, {compact: true, ignoreComment: true});

		this.authenticationService.login(authXML).subscribe(
			result => {
        this.toastr.success('Successful login!');
        //OVAKO DOBIJEM TOKEN
        localStorage.setItem('email',auth.username);
        var convert = require('xml-js');
        localStorage.setItem('user', result);
        const item = localStorage.getItem('user');
		    const decodedItem =JSON.parse(convert.xml2json(result,{compact: true, ignoreComment: true}));
        localStorage.setItem('accessToken', decodedItem.UserToken.accessToken._text);
        const jwt: JwtHelperService = new JwtHelperService();
        const info = jwt.decodeToken(decodedItem.UserToken.accessToken._text);
        localStorage.setItem('uloga', info['uloga']);
        console.log(info['uloga']);
				this.router.navigate(['']);
			},
			error => {
				this.toastr.error('Unsuccessful login! Check username and password.');
			}
		);
	}

}
