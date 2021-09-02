import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user';

declare const Xonomy: any;

@Injectable({
	providedIn: 'root'
})
export class ZalbaOdbijenService {
  private headers = new HttpHeaders({'Content-Type': 'application/xml'});

	constructor(
		private http: HttpClient
	) { }

	public createZalbaOdbijen(zalba:any):Observable<any> {
    return this.http.post<any>("http://localhost:8082/api/zalbenaodluku/addText",zalba, {headers: this.headers});
}
public getUsersZalbeOdbijen():Observable<any> {
    return this.http.get("http://localhost:8082/api/zalbenaodluku/getUsersZalbenaodluku", {headers: this.headers, responseType: 'text'});
}
public getAllZalbaOdbijen():Observable<any> {
  return this.http.get("http://localhost:8082/api/zalbenaodluku/getAllZalbenaodluku", {headers: this.headers, responseType: 'text'});
}
public getSearchZalbaOdbijen(content:String):Observable<any> {
  return this.http.get("http://localhost:8082/api/zalbenaodluku/getSearchZalbenaodluku/"+content, {headers: this.headers, responseType: 'text'});
}
public getSearchMetadataZalbaOdbijen(content:any):Observable<any> {
  return this.http.post("http://localhost:8082/api/zalbenaodluku/getSearchMetadataZalbenaodluku",content,{headers: this.headers, responseType: 'text'});
}
public skiniXHTML(id:String):Observable<any> {
    return this.http.post<any>("http://localhost:8082/api/zalbe/skiniXHTML"+id, {headers: this.headers});
}
public skiniPDF(id:String):Observable<any> {
    return this.http.post<any>("http://localhost:8082/api/zalbe/skiniPDF"+id, {headers: this.headers});
}
public skiniRDF(id:String):Observable<any> {
    return this.http.post<any>("http://localhost:8082/api/zalbe/skiniRDF"+id, {headers: this.headers});
}
public skiniJSON(id:String):Observable<any> {
    return this.http.post<any>("http://localhost:8082/api/zalbe/skiniJSON"+id, {headers: this.headers});
}
	public ZalbaOdbijenSpecification = {
		validate: function (jsElement) {
			let elementSpec = this.elements[jsElement.name];
			if (elementSpec.validate) elementSpec.validate(jsElement);
			for (let i = 0; i < jsElement.attributes.length; i++) {
			  let jsAttribute = jsElement.attributes[i];
			  let attributeSpec = elementSpec.attributes[jsAttribute.name];
			  if (attributeSpec.validate) attributeSpec.validate(jsAttribute);
			};
			for (let i = 0; i < jsElement.children.length; i++) {
			  let jsChild = jsElement.children[i];
			  if (jsChild.type == "element") {
				this.validate(jsChild);
			  }
			}
		},
		elements: {
      'zalbaOdbijen':{
        dislayName:"zalbaOdbijen",
        attributes: {
        "xsi:schemaLocation": {
          isInvisible: true,
          },
        "stanje":{
          isInvisible: true
        }
        },
      },
      "naziv_organa": {
        displayName: "naziv_organa",
        hasText: true,
        validate: function (jsElement) {
          if (jsElement.getText()===""){
            Xonomy.warnings.push({
            htmlID: jsElement.htmlID,
            text: "Morate uneti naziv organa."
            });
          }
        },
        asker: Xonomy.askString
        },
      "razlog_zalbe": {
        displayName: "razlog_zalbe",
        hasText: true,
        validate: function (jsElement) {
          if (jsElement.getText()===""){
            Xonomy.warnings.push({
            htmlID: jsElement.htmlID,
            text: "Morate uneti razlog zalbe."
            });
          }
        },
        asker: Xonomy.askString
        },
        "datum_zahteva": {
          displayName: "datum_zahteva",
          hasText: true,
          validate: function (jsElement) {
            if (jsElement.getText()===""){
              Xonomy.warnings.push({
              htmlID: jsElement.htmlID,
              text: "Morate uneti datum originalnog zahteva u formatu YYYY-MM-DD"
              });
            }
          },
          asker: Xonomy.askString
        },
        "drugi_podaci_za_kontakt": {
          displayName: "drugi_podaci_za_kontakt",
          hasText: true,
          validate: function (jsElement) {
            if (jsElement.getText()===""){
              Xonomy.warnings.push({
              htmlID: jsElement.htmlID,
              text: "Morate uneti ostale podatke za kontakt"
              });
            }
          },
          asker: Xonomy.askString
        },
      "ime": {
        displayName: "ime",
        hasText: true,
        validate: function (jsElement) {
          if (jsElement.getText()===""){
            Xonomy.warnings.push({
            htmlID: jsElement.htmlID,
            text: "Morate uneti ime podnosioca zalbe."
            });
          }
        },
        asker: Xonomy.askString
      },
      "prezime": {
        displayName: "prezime",
        hasText: true,
        validate: function (jsElement) {
          if (jsElement.getText()===""){
            Xonomy.warnings.push({
            htmlID: jsElement.htmlID,
            text: "Morate uneti prezime podnosioca zalbe."
            });
          }
        },
        asker: Xonomy.askString
      },
      "mesto": {
        displayName: "mesto",
        hasText: true,
        validate: function (jsElement) {
          if (jsElement.getText()===""){
            Xonomy.warnings.push({
            htmlID: jsElement.htmlID,
            text: "Morate uneti mesto."
            });
          }
        },
        asker: Xonomy.askString
      },
      "ulica": {
        displayName: "ulica",
        hasText: true,
        validate: function (jsElement) {
          if (jsElement.getText()===""){
            Xonomy.warnings.push({
            htmlID: jsElement.htmlID,
            text: "Morate uneti ulicu podnosioca zalbe."
            });
          }
        },
        asker: Xonomy.askString
      },
      "br_ulice": {
        displayName: "br_ulice",
        hasText: true,
        validate: function (jsElement) {
          if (jsElement.getText()===""){
            Xonomy.warnings.push({
            htmlID: jsElement.htmlID,
            text: "Morate uneti broj ulice podnosioca zalbe."
            });
          }
        },
        asker: Xonomy.askString
      },
      "datum": {
        displayName: "datum",
        hasText: true,
        validate: function (jsElement) {
          if (jsElement.getText()===""){
            Xonomy.warnings.push({
            htmlID: jsElement.htmlID,
            text: "Morate uneti datum u formatu YYYY-MM-DD"
            });
          }
        },
        asker: Xonomy.askString
      },
      "datum_predmeta": {
        displayName: "datum_predmeta",
        hasText: true,
        validate: function (jsElement) {
          if (jsElement.getText()===""){
            Xonomy.warnings.push({
            htmlID: jsElement.htmlID,
            text: "Morate uneti datum predmeta u formatu YYYY-MM-DD"
            });
          }
        },
        asker: Xonomy.askString
      },
      "broj_predmeta": {
        displayName: "broj_predmeta",
        hasText: true,
        validate: function (jsElement) {
          if (jsElement.getText()===""){
            Xonomy.warnings.push({
            htmlID: jsElement.htmlID,
            text: "Morate uneti broj predmeta zahteva zbog kojeg podnosite zalbu"
            });
          }
        },
        asker: Xonomy.askString
      },
    }
  }
}
