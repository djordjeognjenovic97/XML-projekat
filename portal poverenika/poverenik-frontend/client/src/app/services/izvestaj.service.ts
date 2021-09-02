import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user';

declare const Xonomy: any;

@Injectable({
	providedIn: 'root'
})
export class IzvestajService {
  private headers = new HttpHeaders({'Content-Type': 'application/xml'});

	constructor(
		private http: HttpClient
	) { }

	public getAllIzvestaji():Observable<any> {
        return this.http.get("http://localhost:8082/api/izvestaji/getAllIzvestaji", {headers: this.headers, responseType: 'text'});
    }
    public getSearchIzvestaji(content:String):Observable<any> {
        return this.http.get("http://localhost:8082/api/izvestaji/getSearchIzvestaji/"+content, {headers: this.headers, responseType: 'text'});
    }
    	public skiniXHTML(id:String):Observable<any> {
        return this.http.post<any>("http://localhost:8082/api/zahtevi/skiniXHTML"+id, {headers: this.headers});
    }
	public skiniPDF(id:String):Observable<any> {
        return this.http.post<any>("http://localhost:8082/api/zahtevi/skiniPDF"+id, {headers: this.headers});
    }
	public skiniRDF(id:String):Observable<any> {
        return this.http.post<any>("http://localhost:8082/api/zahtevi/skiniRDF"+id, {headers: this.headers});
    }
	public skiniJSON(id:String):Observable<any> {
        return this.http.post<any>("http://localhost:8082/api/zahtevi/skiniJSON"+id, {headers: this.headers});
    }
}