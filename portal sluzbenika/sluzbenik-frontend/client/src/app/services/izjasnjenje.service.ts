import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

declare const Xonomy: any;

@Injectable({
	providedIn: 'root'
})
export class IzjasnjenjeService {
  private headers = new HttpHeaders({'Content-Type': 'application/xml'});

	constructor(
		private http: HttpClient
	) { }

	public izjasniSe(id:string,sadrzaj:string):Observable<any> {
        return this.http.get("http://localhost:8080/api/izjasnjenje/izjasniSe/"+sadrzaj+"/"+id, {headers: this.headers});
    }
	public getAllIzjasnjenja():Observable<any> {
        return this.http.get("http://localhost:8080/api/izjasnjenje/pogledajIzjasnjenja", {headers: this.headers, responseType: 'text'});
    }
}