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

    public getAllResenje():Observable<any> {
        return this.http.get("http://localhost:8080/api/resenja/getAllResenje", {headers: this.headers, responseType: 'text'});
    }
    public getSearchResenje(content:String):Observable<any> {
        return this.http.get("http://localhost:8080/api/resenja/getSearchResenje/"+content, {headers: this.headers, responseType: 'text'});
    }
    public getSearchMetadataResenje(content:any):Observable<any> {
    return this.http.post("http://localhost:8080/api/resenja/getSearchMetadataResenje",content,{headers: this.headers, responseType: 'text'});
    }
	public skiniXHTML(id:String):Observable<any> {
        return this.http.get("http://localhost:8080/api/resenja/skiniHTML/"+id, {headers: this.headers, responseType: 'arraybuffer'});
    }
	public skiniPDF(id:String):Observable<any> {
        return this.http.get("http://localhost:8080/api/resenja/skiniPDF/"+id, {headers: this.headers, responseType: 'arraybuffer'});
    }
	public skiniRDF(id:String):Observable<any> {
        return this.http.get("http://localhost:8080/api/resenja/skiniRDF/"+id, {headers: this.headers, responseType: 'arraybuffer'});
    }
	public skiniJSON(id:String):Observable<any> {
        return this.http.get("http://localhost:8080/api/resenja/skiniJSON/"+id, {headers: this.headers, responseType: 'arraybuffer'});
    }
}