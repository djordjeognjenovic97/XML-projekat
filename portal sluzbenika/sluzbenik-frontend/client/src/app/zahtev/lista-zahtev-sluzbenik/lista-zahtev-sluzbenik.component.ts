import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Zahtev } from 'src/app/models/zahtev';
import { ZahtevService } from 'src/app/services/zahtev.service';

declare var require: any

@Component({
  selector: 'app-lista-zahtev-sluzbenik',
  templateUrl: './lista-zahtev-sluzbenik.component.html',
  styleUrls: ['./lista-zahtev-sluzbenik.component.scss']
})
export class ListaZahtevSluzbenikComponent implements OnInit {

  zahtevi: Zahtev[] |undefined;
  regForm1:FormGroup;
  regForm2:FormGroup;

  constructor(
    private toastr: ToastrService,
    private router:Router,
    private zahtevService: ZahtevService,
  	private fBuilder: FormBuilder,
  ) {
    this.regForm1 = this.fBuilder.group({
			podatak: [""]
      });
    this.regForm2 = this.fBuilder.group({
			idDokumenta: [""],
      mesto: [""],
      datum: [""],
      nazivOrgana: [""],
      });
   }

  ngOnInit(): void {
    this.regForm1.reset();
    this.regForm2.reset();
    this.zahtevService.getAllZahtevi().subscribe(
      res => {
        console.log(res);
        console.log("ABRAKADABRA");
        var convert = require('xml-js');
        this.zahtevi=[];
        const decodedItem =JSON.parse(convert.xml2json(res,{compact: true, ignoreComment: true}));
        if(decodedItem.listaZahtevaDTO.lista.constructor==[].constructor){
          for(var i  in decodedItem.listaZahtevaDTO.lista){
            this.zahtevi.push(new Zahtev(decodedItem.listaZahtevaDTO.lista[i].id._text,
              decodedItem.listaZahtevaDTO.lista[i].mesto._text,decodedItem.listaZahtevaDTO.lista[i].datum._text,
              decodedItem.listaZahtevaDTO.lista[i].nazivOrgana._text,
              decodedItem.listaZahtevaDTO.lista[i].stanje._text));
          }
        }else{
          this.zahtevi.push(new Zahtev(decodedItem.listaZahtevaDTO.lista.id._text,
            decodedItem.listaZahtevaDTO.lista.mesto._text,decodedItem.listaZahtevaDTO.lista.datum._text,
            decodedItem.listaZahtevaDTO.lista.nazivOrgana._text,
              decodedItem.listaZahtevaDTO.lista.stanje._text));
        }
        console.log(this.zahtevi);
      }
      );
  }
  XHTML(c:String) {
    this.zahtevService.skiniXHTML(c).subscribe(
      data=>{
        var blob = new Blob([data], { type:"application/html"});
        var url = window.URL.createObjectURL(blob);
        var link = document.createElement('a');
        link.href = url;
        link.download = "zahtev"+c+".html";
        link.click();
        this.toastr.success('Uspesno preuzet dokument.');
      },
      error=>{
        console.log(error);
        this.toastr.error("Neuspesno preuzet dokument.Pokusajte ponovo.");
      }
    );
  }
  prikazi(c:String){
     this.router.navigate(['prikaz/zahtev/'+c]);
  }
  PDF(c:String) {
    this.zahtevService.skiniPDF(c).subscribe(
      data=>{
        var blob = new Blob([data], { type:"application/pdf"});
        var url = window.URL.createObjectURL(blob);
        var link = document.createElement('a');
        link.href = url;
        link.download = "zahtev"+c+".pdf";
        link.click();
        this.toastr.success('Uspesno preuzet dokument.');
      },
      error=>{
        console.log(error);
        this.toastr.error("Neuspesno preuzet dokument.Pokusajte ponovo.");
      }
    );
  }
  RDF(c:String) {
    this.zahtevService.skiniRDF(c).subscribe(
      data=>{
        var blob = new Blob([data], { type:"application/xml"});
        var url = window.URL.createObjectURL(blob);
        var link = document.createElement('a');
        link.href = url;
        link.download = "zahtev"+c+".xml";
        link.click();
        this.toastr.success('Uspesno preuzet dokument.');
      },
      error=>{
        console.log(error);
        this.toastr.error("Neuspesno preuzet dokument.Pokusajte ponovo.");
      }
    );
  }
  JSON(c:String) {
    this.zahtevService.skiniJSON(c).subscribe(
      data=>{
        var blob = new Blob([data], { type:"application/json"});
        var url = window.URL.createObjectURL(blob);
        var link = document.createElement('a');
        link.href = url;
        link.download = "zahtev"+c+".json";
        link.click();
        this.toastr.success('Uspesno preuzet dokument.');
      },
      error=>{
        console.log(error);
        this.toastr.error("Neuspesno preuzet dokument.Pokusajte ponovo.");
      }
    );
  }
    odbijZahtev(c:String) {
    this.zahtevService.odbijZahtev(c).subscribe(
      data=>{
        this.toastr.success('Uspesno odbijen zahtev.');
        this.router.navigate(['']);
      },
      error=>{
        console.log(error);
        this.toastr.error("Neuspesno odbijen zahtev.");
      }
    );
  }
  prihvatiZahtev(c:String) {
    this.router.navigateByUrl(('/kreirajObavestenje/'+c));
  }
	regIn1(){
    this.zahtevService.getSearchZahtevi(this.regForm1.value.podatak).subscribe(
      res => {
        var convert = require('xml-js');
        this.zahtevi=[];
        const decodedItem =JSON.parse(convert.xml2json(res,{compact: true, ignoreComment: true}));
        if(decodedItem.listaZahtevaDTO.lista.constructor==[].constructor){
          for(var i  in decodedItem.listaZahtevaDTO.lista){
            this.zahtevi.push(new Zahtev(decodedItem.listaZahtevaDTO.lista[i].id._text,
              decodedItem.listaZahtevaDTO.lista[i].mesto._text,decodedItem.listaZahtevaDTO.lista[i].datum._text,
              decodedItem.listaZahtevaDTO.lista[i].nazivOrgana._text,
              decodedItem.listaZahtevaDTO.lista[i].stanje._text));
          }
        }else{
          this.zahtevi.push(new Zahtev(decodedItem.listaZahtevaDTO.lista.id._text,
            decodedItem.listaZahtevaDTO.lista.mesto._text,decodedItem.listaZahtevaDTO.lista.datum._text,
            decodedItem.listaZahtevaDTO.lista.nazivOrgana._text,
              decodedItem.listaZahtevaDTO.lista.stanje._text));
        }
      }
      );
  }
  regIn2(){
        const search: any = { 
    Query: { 
      IdDokumenta: { _text: '' }, Mesto: { _text: '' }, Datum: { _text: '' }, NazivOrgana: { _text: '' } } };
    search.Query.IdDokumenta = this.regForm2.value.idDokumenta;
    search.Query.Mesto = this.regForm2.value.mesto;
    search.Query.Datum = this.regForm2.value.datum;
    search.Query.NazivOrgana = this.regForm2.value.nazivOrgana;

    var convert = require('xml-js');
    var searchXML = convert.js2xml(search, {compact: true, ignoreComment: true});

    this.zahtevService.getSearchMetadataZahtevi(searchXML).subscribe(
      res => {
        //console.log(res);
        var convert = require('xml-js');
        this.zahtevi=[];
        const decodedItem =JSON.parse(convert.xml2json(res,{compact: true, ignoreComment: true}));
        if(decodedItem.listaZahtevaDTO.lista.constructor==[].constructor){
          for(var i  in decodedItem.listaZahtevaDTO.lista){
            this.zahtevi.push(new Zahtev(decodedItem.listaZahtevaDTO.lista[i].id._text,
              decodedItem.listaZahtevaDTO.lista[i].mesto._text,decodedItem.listaZahtevaDTO.lista[i].datum._text,
              decodedItem.listaZahtevaDTO.lista[i].nazivOrgana._text,
              decodedItem.listaZahtevaDTO.lista[i].stanje._text));
          }
        }else{
          this.zahtevi.push(new Zahtev(decodedItem.listaZahtevaDTO.lista.id._text,
            decodedItem.listaZahtevaDTO.lista.mesto._text,decodedItem.listaZahtevaDTO.lista.datum._text,
            decodedItem.listaZahtevaDTO.lista.nazivOrgana._text,
              decodedItem.listaZahtevaDTO.lista.stanje._text));
        }
      }
      );
  }
}
