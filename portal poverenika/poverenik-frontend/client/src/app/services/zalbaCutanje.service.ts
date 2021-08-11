import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user';

declare const Xonomy: any;

@Injectable({
	providedIn: 'root'
})
export class ZalbaCutanjeService {
  private headers = new HttpHeaders({'Content-Type': 'application/xml'});

	constructor(
		private http: HttpClient
	) { }

	public createZalbaCutanje(zahtev:any):Observable<any> {
        return this.http.post<any>("http://localhost:8082/api/zalbecutanje/addText",zahtev, {headers: this.headers});
    }
	public getUsersZalbe():Observable<any> {
        return this.http.get("http://localhost:8082/api/zalbe/getUsersZalbe", {headers: this.headers, responseType: 'text'});
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
		  'zalbacutanje':{
			  dislayName:"zahtev",
			  attributes: {
				"xsi:schemaLocation": {
					isInvisible: true,
				  },
				"datum":{
					isInvisible: true
					// displayName: "datum",
					// hasText: true,
					// asker: Xonomy.askCalendar
				},
				"mesto": {
					displayName: "mesto",
					hasText: true,
					validate: function (jsElement) {
						if (jsElement.value===""){
						  Xonomy.warnings.push({
							htmlID: jsElement.htmlID,
							text: "Morate uneti mesto podnosenja zahteva."
						  });
						}
					},
					asker: Xonomy.askString,
				},
				"br_predmeta": {
					displayName: "br_predmeta",
					hasText: true,
					validate: function (jsElement) {
						if (jsElement.value===""){
						  Xonomy.warnings.push({
							htmlID: jsElement.htmlID,
							text: "Morate uneti id zahteva za koji podnosite zalbu."
						  });
						}
					},
					asker: Xonomy.askString,
				},
			  },
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
				displayName: "razlog_zlabe",
				hasText: true,
				validate: function (jsElement) {
					if (jsElement.getText()===""){
					  Xonomy.warnings.push({
						htmlID: jsElement.htmlID,
						text: "Morate uneti razlog zalbe ('nije postupio', 'nije postupio u celosti', 'u zakonskom roku')."
					  });
					}
				},
				asker: Xonomy.askString
				// validate: function (jsElement) {
				// 	if (jsElement.getText()===""){
				// 	  Xonomy.warnings.push({
				// 		htmlID: jsElement.htmlID,
				// 		text: "Morate uneti razlog zalbe."
				// 	  });
				// 	}
				// },
				// asker: Xonomy.askPickerList,
				// askerParameter: ["nije postupio", "nije postupio u celosti", "u zakonskom roku"],
			},	
			"datum_zahteva":{
				isInvisible: true
				// displayName: "datum",
				// hasText: true,
				// asker: Xonomy.askCalendar
			},
			"podaci_o_zahtevu_i_info": {
				displayName: "podaci_o_zahtevu_i_info",
				hasText: true,
				asker: Xonomy.askString
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
			"drugi_kontakt_podaci": {
				displayName: "drugi_kontakt_podaci",
				hasText: true,
				asker: Xonomy.askString
			},
		}
	}
}