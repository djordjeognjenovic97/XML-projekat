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

	public generateIzvestaj():Observable<any> {
        return this.http.get("http://localhost:8080/api/izvestaji/generate", {headers: this.headers, responseType: 'text'});
    }
	public getAllIzvestaji():Observable<any> {
        return this.http.get("http://localhost:8080/api/izvestaji/getAllIzvestaji", {headers: this.headers, responseType: 'text'});
    }
    public getSearchIzvestaji(content:String):Observable<any> {
        return this.http.get("http://localhost:8080/api/izvestaji/getSearchIzvestaji/"+content, {headers: this.headers, responseType: 'text'});
    }
	public skiniXHTML(id:String):Observable<any> {
        return this.http.get("http://localhost:8080/api/izvestaji/skiniHTML/"+id, {headers: this.headers, responseType: 'arraybuffer'});
    }
	public skiniPDF(id:String):Observable<any> {
        return this.http.get("http://localhost:8080/api/izvestaji/skiniPDF/"+id, {headers: this.headers, responseType: 'arraybuffer'});
    }
	public skiniRDF(id:String):Observable<any> {
        return this.http.get("http://localhost:8080/api/izvestaji/skiniRDF/"+id, {headers: this.headers, responseType: 'arraybuffer'});
    }
	public skiniJSON(id:String):Observable<any> {
        return this.http.get("http://localhost:8080/api/izvestaji/skiniJSON/"+id, {headers: this.headers, responseType: 'arraybuffer'});
    }
}