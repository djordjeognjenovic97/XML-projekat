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
        return this.http.post<any>("http://localhost:8080/api/zahtevi/addZahtev",zahtev, {headers: this.headers});
    }
	public ZahtevSpecification = {
		elements: {
		  'zahtev':{
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
					asker: Xonomy.askString
				},
			  },
			},
			"naziv": {
				displayName: "naziv",
				hasText: true,
				asker: Xonomy.askString
			  },
			"sediste": {
				displayName: "sediste",
				hasText: true,
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
				  actionParameter: '<dostavljanje_kopije><Nacin_dostave></Nacin_dostave></dostavljanje_kopije>',
				  hideIf: function (jsElement) {
					return jsElement.hasChildElement("dostavljanje_kopije")
				  }
				}
			  ]
			},
			'Nacin_dostave': {
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
					actionParameter: '<Dostava_postom><Dostava_postom>',
					hideIf: function (jsElement) { 
					  return (jsElement.hasChildElement("Dostava_postom") || jsElement.hasChildElement("Dostava_elektronskom_postom") ||
					  jsElement.hasChildElement("Dostava_faksom") || jsElement.hasChildElement("Posebna_dostava"))
					}
				  },
				  {
					caption: 'Dostava elektronskom postom',
					action: Xonomy.newElementChild,
					actionParameter: '<Dostava_elektronskom_postom></Dostava_elektronskom_postom>',
					hideIf: function (jsElement) {
					  return (jsElement.hasChildElement("Dostava_postom") || jsElement.hasChildElement("Dostava_elektronskom_postom") ||
					  jsElement.hasChildElement("Dostava_faksom") || jsElement.hasChildElement("Posebna_dostava"))
					}
				  },
				  {
					caption: 'Dostava faksom',
					action: Xonomy.newElementChild,
					actionParameter: '<Dostava_faksom></Dostava_faksom>',
					hideIf: function (jsElement) {
					  return (jsElement.hasChildElement("Dostava_postom") || jsElement.hasChildElement("Dostava_elektronskom_postom") ||
					  jsElement.hasChildElement("Dostava_faksom") || jsElement.hasChildElement("Posebna_dostava"))
					}
				  },
				  {
					caption: 'Na drugi nacin',
					action: Xonomy.newElementChild,
					actionParameter: '<Posebna_dostava><Nacin_posebne_dostave></Nacin_posebne_dostave></Posebna_dostava>',
					hideIf: function (jsElement) {
					  return (jsElement.hasChildElement("Dostava_postom") || jsElement.hasChildElement("Dostava_elektronskom_postom") ||
					  jsElement.hasChildElement("Dostava_faksom") || jsElement.hasChildElement("Posebna_dostava"))
					}
				  }
				]
			},
			"Nacin_posebne_dostave": {
				displayName: "Nacin_posebne_dostave",
				hasText: true,
				asker: Xonomy.askString
			},
			"opis_informacije": {
				displayName: "opis_informacije",
				hasText: true,
				asker: Xonomy.askString
			},
			"ime": {
				displayName: "ime",
				hasText: true,
				asker: Xonomy.askString
			},
			"prezime": {
				displayName: "prezime",
				hasText: true,
				asker: Xonomy.askString
			},
			"mesto": {
				displayName: "mesto",
				hasText: true,
				asker: Xonomy.askString
			},
			"ulica": {
				displayName: "ulica",
				hasText: true,
				asker: Xonomy.askString
			},
			"br_ulice": {
				displayName: "br_ulice",
				hasText: true,
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