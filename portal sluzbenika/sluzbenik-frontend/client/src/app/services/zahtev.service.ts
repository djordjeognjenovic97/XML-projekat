import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user';

declare const Xonomy: any;

@Injectable({
	providedIn: 'root'
})
export class ZahtevService {
  private headers = new HttpHeaders({'Content-Type': 'application/xml'});

	constructor(
		private http: HttpClient
	) { }

	public createZahtev(zahtev:any):Observable<any> {
        return this.http.post<any>("http://localhost:8080/api/zahtevi/addText",zahtev, {headers: this.headers});
    }
	public getUsersZahtevi():Observable<any> {
        return this.http.get("http://localhost:8080/api/zahtevi/getUsersZahtevi", {headers: this.headers, responseType: 'text'});
    }
	public getAllZahtevi():Observable<any> {
        return this.http.get("http://localhost:8080/api/zahtevi/getAllZahtevi", {headers: this.headers, responseType: 'text'});
    }
	public getSearchZahtevi(content:String):Observable<any> {
        return this.http.get("http://localhost:8080/api/zahtevi/getSearchZahtevi/"+content, {headers: this.headers, responseType: 'text'});
    }
	public getSearchMetadataZahtevi(content:any):Observable<any> {
        return this.http.post("http://localhost:8080/api/zahtevi/getSearchMetadataZahtevi",content,{headers: this.headers, responseType: 'text'});
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
	public ZahtevSpecification = {
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
		  'zahtev':{
			  dislayName:"zahtev",
			  attributes: {
				"xsi:schemaLocation": {
					isInvisible: true,
				  },
				"stanje":{
					isInvisible: true
				}
			  },
			},
			"id":{
				isInvisible: true
			},
			"naziv": {
				displayName: "naziv",
				hasText: true,
				validate: function (jsElement) {
					if (jsElement.getText()===""){
					  Xonomy.warnings.push({
						htmlID: jsElement.htmlID,
						text: "Morate uneti naziv."
					  });
					}
				},
				asker: Xonomy.askString
			  },
			"sediste": {
				displayName: "sediste",
				hasText: true,
				validate: function (jsElement) {
					if (jsElement.getText()===""){
					  Xonomy.warnings.push({
						htmlID: jsElement.htmlID,
						text: "Morate uneti sediste."
					  });
					}
				},
				asker: Xonomy.askString
			},
			'tipovi_zahteva': {
				validate: function (jsElement:any) {
				  if (jsElement.children.length == 0) {
					Xonomy.warnings.push({
					  htmlID: jsElement.htmlID,
					  text: "Morate dodati zahtev"
					}
					);
				  }
				},
				title: 'Kliknite da dodate zahtev',
				menu: [
				{
				  caption: 'obavestenje da li poseduje trazenu informaciju',
				  action: Xonomy.newElementChild,
				  actionParameter: '<obavestenje_posedovanje></obavestenje_posedovanje>',
				  hideIf: function (jsElement) {
					return jsElement.hasChildElement("obavestenje_posedovanje")
				  }
				},
				{
				  caption: 'uvid u dokument koji sadrzi trazenu informaciju',
				  action: Xonomy.newElementChild,
				  actionParameter: '<uvid_dokument></uvid_dokument>',
				  hideIf: function (jsElement) {
					return jsElement.hasChildElement("uvid_dokument")
				  }
				},
				{
				  caption: 'kopiju dokumenta koji sadrzi trazenu informaciju',
				  action: Xonomy.newElementChild,
				  actionParameter: '<kopija_dokument></kopija_dokument>',
				  hideIf: function (jsElement) {
					return jsElement.hasChildElement("kopija_dokument")
				  }
				},
				{
				  caption: 'dostavljanje kopije dokumenta koji sadrzi trazenu informaciju',
				  action: Xonomy.newElementChild,
				  actionParameter: '<dostavljanje_kopije></dostavljanje_kopije>',
				  hideIf: function (jsElement) {
					return jsElement.hasChildElement("dostavljanje_kopije")
				  }
				}
			  ]
			},
			'dostavljanje_kopije': {
				validate: function (jsElement:any) {
				  if (jsElement.children.length == 0) {
					Xonomy.warnings.push({
					  htmlID: jsElement.htmlID,
					  text: "Morate dodati nacin dostavljanja kopije"
					}
					);
				  }
				},
				title: 'Kliknite da biste dodali nacin dostavljanja kopije',
				hasText: false,
				menu: [
				  {
					caption: 'Dostava postom',
					action: Xonomy.newElementChild,
					actionParameter: '<posta></posta>',
					hideIf: function (jsElement) { 
					  return (jsElement.hasChildElement("posta") || jsElement.hasChildElement("elektronska_posta") ||
					  jsElement.hasChildElement("faks") || jsElement.hasChildElement("drugi_nacin"))
					}
				  },
				  {
					caption: 'Dostava elektronskom postom',
					action: Xonomy.newElementChild,
					actionParameter: '<elektronska_posta></elektronska_posta>',
					hideIf: function (jsElement) {
					  return (jsElement.hasChildElement("posta") || jsElement.hasChildElement("elektronska_posta") ||
					  jsElement.hasChildElement("faks") || jsElement.hasChildElement("drugi_nacin"))
					}
				  },
				  {
					caption: 'Dostava faksom',
					action: Xonomy.newElementChild,
					actionParameter: '<faks></faks>',
					hideIf: function (jsElement) {
					  return (jsElement.hasChildElement("posta") || jsElement.hasChildElement("elektronska_posta") ||
					  jsElement.hasChildElement("faks") || jsElement.hasChildElement("drugi_nacin"))
					}
				  },
				  {
					caption: 'Na drugi nacin',
					action: Xonomy.newElementChild,
					actionParameter: '<drugi_nacin></drugi_nacin>',
					hideIf: function (jsElement) {
					  return (jsElement.hasChildElement("posta") || jsElement.hasChildElement("elektronska_posta") ||
					  jsElement.hasChildElement("faks") || jsElement.hasChildElement("drugi_nacin"))
					}
				  }
				]
			},
			"drugi_nacin": {
				displayName: "drugi_nacin",
				hasText: true,
				validate: function (jsElement) {
					if (jsElement.getText()===""){
					  Xonomy.warnings.push({
						htmlID: jsElement.htmlID,
						text: "Morate dodati drugi nacin dostave."
					  });
					}
				},
				asker: Xonomy.askString
			},
			"opis_informacije": {
				displayName: "opis_informacije",
				hasText: true,
				asker: Xonomy.askString
			},
			"datum":{
				isInvisible: true
				// displayName: "datum",
				// hasText: true,
				// asker: Xonomy.askCalendar
			},
			"ime": {
				displayName: "ime",
				hasText: true,
				validate: function (jsElement) {
					if (jsElement.getText()===""){
					  Xonomy.warnings.push({
						htmlID: jsElement.htmlID,
						text: "Morate uneti ime."
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
						text: "Morate uneti prezime."
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
						text: "Morate uneti ulicu."
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
						text: "Morate uneti broj ulice."
					  });
					}
				},
				asker: Xonomy.askString
			},
			"drugi_kontakt_podaci": {
				displayName: "drugi_kontakt_podaci",
				hasText: true,
				asker: Xonomy.askString
			},
		}
	}
}