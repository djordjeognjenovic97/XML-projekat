import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user';

declare const Xonomy: any;

@Injectable({
	providedIn: 'root'
})
export class ResenjeService {
  private headers = new HttpHeaders({'Content-Type': 'application/xml'});

	constructor(
		private http: HttpClient
	) { }

	public getUsersResenja():Observable<any> {
        return this.http.get("http://localhost:8080/api/zahtevi/getUsersZahtevi", {headers: this.headers, responseType: 'text'});
    }
	public skiniXHTML(id:String):Observable<any> {
        return this.http.post<any>("http://localhost:8080/api/zahtevi/skiniXHTML"+id, {headers: this.headers});
    }
	public skiniPDF(id:String):Observable<any> {
        return this.http.post<any>("http://localhost:8080/api/zahtevi/skiniPDF"+id, {headers: this.headers});
    }
	public skiniRDF(id:String):Observable<any> {
        return this.http.post<any>("http://localhost:8080/api/zahtevi/skiniRDF"+id, {headers: this.headers});
    }
	public skiniJSON(id:String):Observable<any> {
        return this.http.post<any>("http://localhost:8080/api/zahtevi/skiniJSON"+id, {headers: this.headers});
    }
}