
import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { ToastrService } from 'ngx-toastr';
import { AuthenticationService } from '../services/authentication.service';

declare var require: any

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  role: any;

  constructor(
    private router: Router,
    private authenticationService: AuthenticationService,
    private toastr: ToastrService) { }

  ngOnInit(): void {
  }

  kreirajZalbaCutanje() {
    this.router.navigateByUrl('/kreirajZalbaCutanje');
  }
  kreirajZalbaOdbijen() {
    this.router.navigateByUrl('/kreirajZalbaOdbijen');
  }
  zalbeCutanjeGradjanin() {
    this.router.navigateByUrl('/zalbec-gradjanin');
  }
  zalbeOdbijeniceGradjanin() {
    this.router.navigateByUrl('/zalbeo-gradjanin');
  }
  resenjaGradjanin() {
    this.router.navigateByUrl('/resenja-gradjanin');
  }
  zalbeCutanjePoverenik() {
    this.router.navigateByUrl('/zalbec-poverenik');
  }
  zalbeOdbijenicePoverenik() {
    this.router.navigateByUrl('/zalbeo-poverenik');
  }
  resenjaPoverenik() {
    this.router.navigateByUrl('/resenja-poverenik');
  }
  izvestajiPoverenik() {
    this.router.navigateByUrl('/izvestaji-poverenik');
  }
  getRole(): string {

    let item: string = localStorage.getItem('user');


		if (!item) {
			this.role = undefined;
			return this.role;
		}
    const jwt: JwtHelperService = new JwtHelperService();
    var convert = require('xml-js');
    const decodedItem =JSON.parse(convert.xml2json(item,{compact: true, ignoreComment: true}));
    const info = jwt.decodeToken(decodedItem.UserToken.accessToken._text);
    this.role=info['uloga'];
    //console.log(localStorage.getItem('uloga'));
    return this.role;
  }

  goToHome() {
    this.router.navigate(['']);
  }

  goToLogIn() {
    //localStorage.removeItem('user');
    //localStorage.removeItem('uloga');
    this.router.navigate(['/login']);
  }

  goToRegistration() {
    this.router.navigate(['/registration']);
  }

  goToProfile() {
    this.router.navigateByUrl('/profil');
  }

  logOut() {
    //this.authenticationService.logout().subscribe(
		//	result => {
        localStorage.removeItem('user');
        localStorage.removeItem('accessToken');
        localStorage.removeItem('uloga');
				this.toastr.success('You have been successfully logged out!');
				this.router.navigate(['login']);
		//	},
		//	error => {
		//		this.toastr.error('Some error. Try again.');
		//	}
		//);
  }

}
