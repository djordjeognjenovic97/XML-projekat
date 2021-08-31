import { Component } from '@angular/core';
import {JwtHelperService } from '@auth0/angular-jwt'
import { Router } from '@angular/router';
import { stringify } from '@angular/compiler/src/util';
import { AuthenticationService } from './services/authentication.service';
import { ToastrService } from 'ngx-toastr';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent {
  title = 'client';
  public role: string | undefined;

  constructor(
    private router: Router,
    private authenticationService: AuthenticationService,
    private toastr: ToastrService
    ) {}

	checkRole() {
    //alert("dsds");
    // localStorage.removeItem('email');
    // localStorage.removeItem('user');
    // localStorage.removeItem('accessToken');
    // localStorage.removeItem('uloga');
		const item = localStorage.getItem('user');

		if (!item) {
      //this.router.navigate(['login']);
      //alert("ok");
			this.role = undefined;
			return;
		}

    const jwt: JwtHelperService = new JwtHelperService();
    const decodedItem = JSON.parse(item!);
    const info = jwt.decodeToken(decodedItem.accessToken);
    this.role=info['uloga'];
    //alert(this.role);
  }
  logout() {
		//this.authenticationService.logout().subscribe(
		//	result => {
        localStorage.removeItem('user');
        localStorage.removeItem('accessToken');
				this.toastr.success('You have been successfully logged out!');
				this.router.navigate(['login']);
		//	},
		//	error => {
		//		this.toastr.error('Some error. Try again.');
		//	}
		//);
	}
}
