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

  	public getZalbanaodlukuHTML(id:String):Observable<any> {
        return this.http.get("http://localhost:8082/api/zalbenaodluku/htmlOblik/"+id, {headers: this.headers, responseType: 'text'});
    }
    public getZalbacutanjeHTML(id:String):Observable<any> {
      return this.http.get("http://localhost:8082/api/zalbecutanje/htmlOblik/"+id, {headers: this.headers, responseType: 'text'});
    }
    public getResenjeHTML(id:String):Observable<any> {
        return this.http.get("http://localhost:8082/api/resenja/htmlOblik/"+id, {headers: this.headers, responseType: 'text'});
    }
}
