import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
	providedIn: 'root'
})
export class AuthenticationService {
  private headers = new HttpHeaders({'Content-Type': 'application/xml'});

	constructor(
		private http: HttpClient
	) { }

	public registerUser(user:any):Observable<any> {
        return this.http.post<any>("http://localhost:8082/auth/sign-up",user, {headers: this.headers});
    }
	login(auth: any): Observable<any> {
		return this.http.post('http://localhost:8082/auth/log-in', auth, {headers: this.headers, responseType: 'text'});
	}
	isLoggedIn(): boolean {
		if (!localStorage.getItem('user')) {
				return false;
		}
		return true;
    }
}