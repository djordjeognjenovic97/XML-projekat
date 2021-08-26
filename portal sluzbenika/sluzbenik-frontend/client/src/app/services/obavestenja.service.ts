import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user';

declare const Xonomy: any;

@Injectable({
	providedIn: 'root'
})
export class ObavestenjaService {
  private headers = new HttpHeaders({'Content-Type': 'application/xml'});

	constructor(
		private http: HttpClient
	) { }

	public createObavestenje(obavestenje:any):Observable<any> {
        return this.http.post<any>("http://localhost:8080/api/obavestenja/addText",obavestenje, {headers: this.headers});
    }
	public getUsersObavestenja():Observable<any> {
        return this.http.get("http://localhost:8080/api/obavestenja/getUsersObavestenja", {headers: this.headers, responseType: 'text'});
    }
	public getAllObavestenja():Observable<any> {
        return this.http.get("http://localhost:8080/api/obavestenja/getAllObavestenja", {headers: this.headers, responseType: 'text'});
    }
	public getSearchObavestenja(content:String):Observable<any> {
        return this.http.get("http://localhost:8080/api/obavestenja/getSearchObavestenja/"+content, {headers: this.headers, responseType: 'text'});
    }
	public getSearchMetadataObavestenja(content:any):Observable<any> {
        return this.http.post("http://localhost:8080/api/obavestenja/getSearchMetadataObavestenja",content,{headers: this.headers, responseType: 'text'});
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
	public odbijZahtev(id:String):Observable<any> {
        return this.http.put<any>("http://localhost:8080/api/zahtevi/odbijZahtev/"+id, {headers: this.headers});
    }
	public ObavestenjeSpecification = {
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
		  'obavestenje':{
			  dislayName:"obavestenje",
			  attributes: {
				"xsi:schemaLocation": {
					isInvisible: true,
				  },
			  },
			},
			// "broj_predmeta":{
			// 	isInvisible: true
			// },
			"datum":{
				isInvisible: true
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
			"sediste_organa": {
				displayName: "sediste_organa",
				hasText: true,
				validate: function (jsElement) {
					if (jsElement.getText()===""){
					  Xonomy.warnings.push({
						htmlID: jsElement.htmlID,
						text: "Morate uneti sediste organa."
					  });
					}
				},
				asker: Xonomy.askString
			},
			"naslov": {
				displayName: "naslov",
				hasText: true,
				validate: function (jsElement) {
					if (jsElement.getText()===""){
					  Xonomy.warnings.push({
						htmlID: jsElement.htmlID,
						text: "Morate uneti naslov."
					  });
					}
				},
				asker: Xonomy.askString
			},
			"opis_trazene_informacije": {
				displayName: "opis_trazene_informacije",
				hasText: true,
				asker: Xonomy.askString
			},
			"datum_uvida": {
				displayName: "datum_uvida",
				hasText: true,
				validate: function (jsElement) {
					if (jsElement.getText()===""){
					  Xonomy.warnings.push({
						htmlID: jsElement.htmlID,
						text: "Morate uneti datum uvida u formatu YYYY-MM-DD"
					  });
					}
				},
				asker: Xonomy.askString
			},
			"broj_sati": {
				displayName: "broj_sati",
				hasText: true,
				validate: function (jsElement) {
					if (jsElement.getText()===""){
					  Xonomy.warnings.push({
						htmlID: jsElement.htmlID,
						text: "Morate uneti broj sati koliko ce trajati mogucnost uvida."
					  });
					}
				},
				asker: Xonomy.askString
			},
			"pocetak_akcije": {
				displayName: "pocetak_akcije",
				hasText: true,
				validate: function (jsElement) {
					if (jsElement.getText()===""){
					  Xonomy.warnings.push({
						htmlID: jsElement.htmlID,
						text: "Morate uneti pocetak uvida u formatu HH:MM"
					  });
					}
				},
				asker: Xonomy.askString
			},
			"kraj_akcije": {
				displayName: "kraj_akcije",
				hasText: true,
				validate: function (jsElement) {
					if (jsElement.getText()===""){
					  Xonomy.warnings.push({
						htmlID: jsElement.htmlID,
						text: "Morate uneti kraj_akcije uvida u formatu HH:MM"
					  });
					}
				},
				asker: Xonomy.askString
			},
			"broj_kancelarije": {
				displayName: "broj_kancelarije",
				hasText: true,
				validate: function (jsElement) {
					if (jsElement.getText()===""){
					  Xonomy.warnings.push({
						htmlID: jsElement.htmlID,
						text: "Morate uneti broj kancelarije."
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
						text: "Morate uneti ime podnosioca zahteva."
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
						text: "Morate uneti prezime podnosioca zahteva."
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
						text: "Morate uneti mesto podnosioca zahteva."
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
						text: "Morate uneti ulicu podnosioca zahteva."
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
						text: "Morate uneti broj ulice podnosioca zahteva."
					  });
					}
				},
				asker: Xonomy.askString
			},
			"izabrano": {
				displayName: "izabrano",
				hasText: true,
				validate: function (jsElement) {
					if (jsElement.getText()===""){
					  Xonomy.warnings.push({
						htmlID: jsElement.htmlID,
						text: "Morate uneti da/ne ako zelite/ ne zelite dostavu."
					  });
					}
				},
				asker: Xonomy.askString
			},
			"naziv": {
				displayName: "naziv",
				hasText: true,
				validate: function (jsElement) {
					if (jsElement.getText()===""){
					  Xonomy.warnings.push({
						htmlID: jsElement.htmlID,
						text: "Morate uneti kako ce te dostavu obaviti."
					  });
					}
				},
				asker: Xonomy.askString
			},
			"iznos_troskova": {
				displayName: "iznos_troskova",
				hasText: true,
				validate: function (jsElement) {
					if (jsElement.getText()===""){
					  Xonomy.warnings.push({
						htmlID: jsElement.htmlID,
						text: "Morate uneti koliko ce iznositi troskovi."
					  });
					}
				},
				asker: Xonomy.askString
			},
		}
	}
}