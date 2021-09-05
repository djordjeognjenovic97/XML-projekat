import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TemplejtService {
  private headers = new HttpHeaders({'Content-Type': 'application/xml;charset=utf-8'});

	constructor(
		private http: HttpClient
	) { }

  	public getZahtevHTML(id:String):Observable<any> {
        return this.http.get("http://localhost:8080/api/zahtevi/htmlOblik/"+id, {headers: this.headers, responseType: 'text'});
    }
    public getIzvestajHTML(id:String):Observable<any> {
      return this.http.get("http://localhost:8080/api/izvestaji/htmlOblik/"+id, {headers: this.headers, responseType: 'text'});
    }
    public getObavestenjeHTML(id:String):Observable<any> {
        return this.http.get("http://localhost:8080/api/obavestenja/htmlOblik/"+id, {headers: this.headers, responseType: 'text'});
    }
    public getResenjeHTML(id:String):Observable<any> {
        return this.http.get("http://localhost:8080/api/resenja/htmlOblik/"+id, {headers: this.headers, responseType: 'text'});
    }
}
