import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Obavestenje } from 'src/app/models/obavestenje';
import { ObavestenjaService } from 'src/app/services/obavestenja.service';

declare var require: any

@Component({
  selector: 'app-lista-obavestenja-sluzbenik',
  templateUrl: './lista-obavestenja-sluzbenik.component.html',
  styleUrls: ['./lista-obavestenja-sluzbenik.component.scss']
})
export class ListaObavestenjaSluzbenikComponent implements OnInit {
  obavestenja: Obavestenje[] |undefined;
  regForm1:FormGroup;
  regForm2:FormGroup;

  constructor(
    private toastr: ToastrService,
    private router:Router,
    private obavestenjeService: ObavestenjaService,
  	private fBuilder: FormBuilder,
  ) {
    this.regForm1 = this.fBuilder.group({
			podatak: [""]
      });
    this.regForm2 = this.fBuilder.group({
			brojPredmeta: [""],
      imePodnosioca: [""],
      prezimePodnosioca: [""],
      datum: [""],
      nazivOrgana: [""],
      });
   }

  ngOnInit(): void {
    this.regForm1.reset();
    this.regForm2.reset();
    this.obavestenjeService.getAllObavestenja().subscribe(
      res => {
        console.log(res);
        console.log("ABRAKADABRA");
        var convert = require('xml-js');
        this.obavestenja=[];
        const decodedItem =JSON.parse(convert.xml2json(res,{compact: true, ignoreComment: true}));
        if(decodedItem.listaObavestenjaDTO.lista.constructor==[].constructor){
          for(var i  in decodedItem.listaObavestenjaDTO.lista){
            this.obavestenja.push(new Obavestenje(decodedItem.listaObavestenjaDTO.lista[i].id._text,decodedItem.listaObavestenjaDTO.lista[i].datum._text,
              decodedItem.listaObavestenjaDTO.lista[i].nazivOrgana._text));
          }
        }else{
          this.obavestenja.push(new Obavestenje(decodedItem.listaObavestenjaDTO.lista.id._text,decodedItem.listaObavestenjaDTO.lista.datum._text,
            decodedItem.listaObavestenjaDTO.lista.nazivOrgana._text));
        }
        console.log(this.obavestenja);
      }
      );
  }
  XHTML(c:String) {
    this.obavestenjeService.skiniXHTML(c).subscribe(
      data=>{
        this.toastr.success('Uspesno preuzet dokument.');
        this.router.navigate(['']);
      },
      error=>{
        console.log(error);
        this.toastr.error("Neuspesno preuzet dokument.Pokusajte ponovo.");
      }
    );
  }
  PDF(c:String) {
    this.obavestenjeService.skiniPDF(c).subscribe(
      data=>{
        this.toastr.success('Uspesno preuzet dokument.');
        this.router.navigate(['']);
      },
      error=>{
        console.log(error);
        this.toastr.error("Neuspesno preuzet dokument.Pokusajte ponovo.");
      }
    );
  }
  RDF(c:String) {
    this.obavestenjeService.skiniRDF(c).subscribe(
      data=>{
        this.toastr.success('Uspesno preuzet dokument.');
        this.router.navigate(['']);
      },
      error=>{
        console.log(error);
        this.toastr.error("Neuspesno preuzet dokument.Pokusajte ponovo.");
      }
    );
  }
  JSON(c:String) {
    this.obavestenjeService.skiniJSON(c).subscribe(
      data=>{
        this.toastr.success('Uspesno preuzet dokument.');
        this.router.navigate(['']);
      },
      error=>{
        console.log(error);
        this.toastr.error("Neuspesno preuzet dokument.Pokusajte ponovo.");
      }
    );
  }
    odbijZahtev(c:String) {
    this.obavestenjeService.odbijZahtev(c).subscribe(
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
    this.obavestenjeService.getSearchObavestenja(this.regForm1.value.podatak).subscribe(
      res => {
        var convert = require('xml-js');
        this.obavestenja=[];
        const decodedItem =JSON.parse(convert.xml2json(res,{compact: true, ignoreComment: true}));
        if(decodedItem.listaObavestenjaDTO.lista.constructor==[].constructor){
          for(var i  in decodedItem.listaObavestenjaDTO.lista){
            this.obavestenja.push(new Obavestenje(decodedItem.listaObavestenjaDTO.lista[i].id._text,decodedItem.listaObavestenjaDTO.lista[i].datum._text,
              decodedItem.listaObavestenjaDTO.lista[i].nazivOrgana._text));
          }
        }else{
          this.obavestenja.push(new Obavestenje(decodedItem.listaObavestenjaDTO.lista.id._text,decodedItem.listaObavestenjaDTO.lista.datum._text,
            decodedItem.listaObavestenjaDTO.lista.nazivOrgana._text));
        }
      }
      );
  }
  regIn2(){
        const search: any = { 
    Query: { 
      BrojPredmeta: { _text: '' }, ImePodnosioca: { _text: '' }, PrezimePodnosioca: { _text: '' }, Datum: { _text: '' }, NazivOrgana: { _text: '' } } };
    search.Query.BrojPredmeta = this.regForm2.value.brojPredmeta;
    search.Query.ImePodnosioca = this.regForm2.value.imePodnosioca;
    search.Query.PrezimePodnosioca = this.regForm2.value.prezimePodnosioca;
    search.Query.Datum = this.regForm2.value.datum;
    search.Query.NazivOrgana = this.regForm2.value.nazivOrgana;

    var convert = require('xml-js');
    var searchXML = convert.js2xml(search, {compact: true, ignoreComment: true});

    this.obavestenjeService.getSearchMetadataObavestenja(searchXML).subscribe(
      res => {
        //console.log(res);
        var convert = require('xml-js');
        this.obavestenja=[];
        const decodedItem =JSON.parse(convert.xml2json(res,{compact: true, ignoreComment: true}));
        if(decodedItem.listaObavestenjaDTO.lista.constructor==[].constructor){
          for(var i  in decodedItem.listaObavestenjaDTO.lista){
            this.obavestenja.push(new Obavestenje(decodedItem.listaObavestenjaDTO.lista[i].id._text,decodedItem.listaObavestenjaDTO.lista[i].datum._text,
              decodedItem.listaObavestenjaDTO.lista[i].nazivOrgana._text));
          }
        }else{
          this.obavestenja.push(new Obavestenje(decodedItem.listaObavestenjaDTO.lista.id._text,decodedItem.listaObavestenjaDTO.lista.datum._text,
            decodedItem.listaObavestenjaDTO.lista.nazivOrgana._text));
        }
      }
      );
  }
}
