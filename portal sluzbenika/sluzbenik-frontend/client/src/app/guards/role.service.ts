import { Injectable } from '@angular/core';
import { Router, ActivatedRouteSnapshot, CanActivate } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { AuthenticationService } from '../services/authentication.service';

@Injectable({
	providedIn: 'root'
})
export class RoleGuard implements CanActivate {

	constructor(
		public auth: AuthenticationService,
		public router: Router
	) { }

	canActivate(route: ActivatedRouteSnapshot): boolean {
		const expectedRoles: string = route.data.expectedRoles;
		const role = localStorage.getItem('uloga');
		const jwt: JwtHelperService = new JwtHelperService();


		if (expectedRoles !== role) {
			this.router.navigate(['']);
			return false;
		}
		return true;
	}
}