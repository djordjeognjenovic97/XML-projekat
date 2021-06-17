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

	// canActivate(route: ActivatedRouteSnapshot): boolean {
	// 	const expectedRoles: string = route.data.expectedRoles;
	// 	const item = localStorage.getItem('user');
	// 	const jwt: JwtHelperService = new JwtHelperService();


	// 	const decodedItem = JSON.parse(item!);
    // 	const info = jwt.decodeToken(decodedItem.accessToken);
    // 	//this.role=info['uloga'];
	//     const roles: string[] = expectedRoles.split('|', 2);

	// 	if (roles.indexOf(info['uloga']) === -1) {
	// 		this.router.navigate(['']);
	// 		return false;
	// 	}
	// 	return true;
	// }
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