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

  public createResenje(resenje:any):Observable<any> {
    return this.http.post<any>("http://localhost:8082/api/resenja/addText",resenje, {headers: this.headers});
    }
	public getUsersResenje():Observable<any> {
        return this.http.get("http://localhost:8082/api/resenja/getUsersResenje", {headers: this.headers, responseType: 'text'});
    }
  public getAllResenje():Observable<any> {
      return this.http.get("http://localhost:8082/api/resenja/getAllResenje", {headers: this.headers, responseType: 'text'});
  }
  public getSearchResenje(content:String):Observable<any> {
      return this.http.get("http://localhost:8082/api/resenja/getSearchResenje/"+content, {headers: this.headers, responseType: 'text'});
  }
  public getSearchMetadataResenje(content:any):Observable<any> {
    return this.http.post("http://localhost:8082/api/resenja/getSearchMetadataResenje",content,{headers: this.headers, responseType: 'text'});
}
public skiniXHTML(id:String):Observable<any> {
  return this.http.get("http://localhost:8082/api/resenja/downloadHTML/"+id, {headers: this.headers, responseType: 'arraybuffer'});
}
public skiniPDF(id:String):Observable<any> {
  return this.http.get("http://localhost:8082/api/resenja/downloadPDF/"+id, {headers: this.headers, responseType: 'arraybuffer'});
}
public skiniRDF(id:String):Observable<any> {
  return this.http.get("http://localhost:8082/api/resenja/downloadRDF/"+id, {headers: this.headers, responseType: 'arraybuffer'});
}
public skiniJSON(id:String):Observable<any> {
  return this.http.get("http://localhost:8082/api/resenja/downloadJSON/"+id, {headers: this.headers, responseType: 'arraybuffer'});
}
    public ResenjeSpecification = {
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
        'resenje':{
          dislayName:"resenje",
          attributes: {
          "xsi:schemaLocation": {
            isInvisible: true,
            },
          "id":{
            isInvisible: true
          },
          "email_gradjanina":{
            isInvisible: true
          }
          },
        },
        "naziv_optuzenog": {
          displayName: "naziv_optuzenog",
          hasText: true,
          validate: function (jsElement) {
            if (jsElement.getText()===""){
              Xonomy.warnings.push({
              htmlID: jsElement.htmlID,
              text: "Morate uneti naziv optuzenog."
              });
            }
          },
          asker: Xonomy.askString
          },
          "sediste_optuzenog": {
            displayName: "sediste_optuzenog",
            hasText: true,
            validate: function (jsElement) {
              if (jsElement.getText()===""){
                Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: "Morate uneti sediste optuzenog."
                });
              }
            },
            asker: Xonomy.askString
            },
            "gradjanin": {
              displayName: "gradjanin",
              hasText: true,
              validate: function (jsElement) {
                if (jsElement.getText()===""){
                  Xonomy.warnings.push({
                  htmlID: jsElement.htmlID,
                  text: "Morate uneti gradjanina."
                  });
                }
              },
              asker: Xonomy.askString
            },
            "status": {
              displayName: "status",
              hasText: true,
              validate: function (jsElement) {
                if (jsElement.getText()===""){
                  Xonomy.warnings.push({
                  htmlID: jsElement.htmlID,
                  text: "Morate uneti status."
                  });
                }
              },
              asker: Xonomy.askString
            },
        "razlog": {
          displayName: "razlog",
          hasText: true,
          validate: function (jsElement) {
            if (jsElement.getText()===""){
              Xonomy.warnings.push({
              htmlID: jsElement.htmlID,
              text: "Morate uneti razlog."
              });
            }
          },
          asker: Xonomy.askString
          },
          "na_osnovu": {
            displayName: "na_osnovu",
            hasText: true,
            validate: function (jsElement) {
              if (jsElement.getText()===""){
                Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: "Morate uneti na osnovu cega je zalba."
                });
              }
            },
            asker: Xonomy.askString
            },
            "clan": {
              displayName: "clan",
              hasText: true,
              asker: Xonomy.askString
              },
              "stav": {
                displayName: "stav",
                hasText: true,
                asker: Xonomy.askString
                },
                "tacka": {
                  displayName: "tacka",
                  hasText: true,
                  asker: Xonomy.askString
                  },
                  "naziv_zakona": {
                    displayName: "naziv_zakona",
                    hasText: true,
                    asker: Xonomy.askString
                    },
                    "naziv_sluzbenog_glasnika": {
                      displayName: "naziv_sluzbenog_glasnika",
                      hasText: true,
                      asker: Xonomy.askString
                      },
                      "broj_slg": {
                        displayName: "broj_slg",
                        hasText: true,
                        asker: Xonomy.askString
                        },
          "datum_podnosenja": {
            displayName: "datum_podnosenja",
            hasText: true,
            validate: function (jsElement) {
              if (jsElement.getText()===""){
                Xonomy.warnings.push({
                htmlID: jsElement.htmlID,
                text: "Morate uneti datum podnosenja u formatu YYYY-MM-DD"
                });
              }
            },
            asker: Xonomy.askString
          },
          "rok_trajanja_mora_izvrsi_resenje": {
            displayName: "rok_trajanja_mora_izvrsi_resenje",
            hasText: true,
            asker: Xonomy.askString
          },
          "dokument_koji_se_trazi": {
            displayName: "dokument_koji_se_trazi",
            hasText: true,
            asker: Xonomy.askString
          },
          "rok_trajanja_provera": {
            displayName: "dokument_koji_se_trazi",
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
              text: "Morate uneti ime poverenika."
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
              text: "Morate uneti prezime poverenika."
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
        "datum_trazenja_informacija": {
          displayName: "datum_trazenja_informacija",
          hasText: true,
          validate: function (jsElement) {
            if (jsElement.getText()===""){
              Xonomy.warnings.push({
              htmlID: jsElement.htmlID,
              text: "Morate uneti datum trazenja informacija u formatu YYYY-MM-DD"
              });
            }
          },
          asker: Xonomy.askString
        },
        "datum_odgovora": {
          displayName: "datum_odgovora",
          hasText: true,
          validate: function (jsElement) {
            if (jsElement.getText()===""){
              Xonomy.warnings.push({
              htmlID: jsElement.htmlID,
              text: "Morate uneti datum odgovora u formatu YYYY-MM-DD"
              });
            }
          },
          asker: Xonomy.askString
        },
        "datum_izjasnjenja": {
          displayName: "datum_izjasnjenja",
          hasText: true,
          asker: Xonomy.askString
        },
        "broj_resenja": {
          displayName: "broj_resenja",
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
        "pasus": {
          displayName: "pasus",
          hasText: true,
          validate: function (jsElement) {
            if (jsElement.getText()===""){
              Xonomy.warnings.push({
              htmlID: jsElement.htmlID,
              text: "Morate uneti razlog odluke"
              });
            }
          },
          asker: Xonomy.askString
        },
      }
    }
}
