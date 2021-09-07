import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Resenje } from 'src/app/models/resenje';
import { ResenjeService } from 'src/app/services/resenje.service';

declare var require: any

@Component({
  selector: 'app-lista-resenja-poverenik',
  templateUrl: './lista-resenja-poverenik.component.html',
  styleUrls: ['./lista-resenja-poverenik.component.scss']
})
export class ListaResenjaPoverenikComponent implements OnInit {

  resenje: Resenje[] |undefined;
  regForm1:FormGroup;
  regForm2:FormGroup;

  constructor(private toastr: ToastrService,
    private router:Router,
    private resenjeService: ResenjeService,
  	private fBuilder: FormBuilder) {
      this.regForm1 = this.fBuilder.group({
			podatak: [""]
      });
    this.regForm2 = this.fBuilder.group({
			brojPredmeta: [""],
      imePoverenika: [""],
      prezimePoverenika: [""],
      datum: [""],
      gradjanin: [""],
      nazivOptuzenog: [""]
      });}

  ngOnInit(): void {
    this.regForm1.reset();
    this.regForm2.reset();
    this.resenjeService.getAllResenje().subscribe(
      res => {
        console.log(res);
        console.log("ABRAKADABRA");
        var convert = require('xml-js');
        this.resenje=[];
        const decodedItem =JSON.parse(convert.xml2json(res,{compact: true, ignoreComment: true}));
        if(decodedItem.listaResenjeDTO.lista.constructor==[].constructor){
          for(var i  in decodedItem.listaResenjeDTO.lista){
            this.resenje.push(new Resenje(decodedItem.listaResenjeDTO.lista[i].id._text,
              decodedItem.listaResenjeDTO.lista[i].datum._text,decodedItem.listaResenjeDTO.lista[i].email._text,
              decodedItem.listaResenjeDTO.lista[i].brP._text));
          }
        }else{
          this.resenje.push(new Resenje(decodedItem.listaResenjeDTO.lista[i].id._text,
            decodedItem.listaResenjeDTO.lista[i].datum._text,decodedItem.listaResenjeDTO.lista[i].email._text,
            decodedItem.listaResenjeDTO.lista[i].brP._text));
        }
        console.log(this.resenje);
      }
      );
  }

  XHTML(c:String) {
    this.resenjeService.skiniXHTML(c).subscribe(
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
    this.resenjeService.skiniPDF(c).subscribe(
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
    this.resenjeService.skiniRDF(c).subscribe(
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
    this.resenjeService.skiniJSON(c).subscribe(
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
	regIn1(){
    this.resenjeService.getSearchResenje(this.regForm1.value.podatak).subscribe(
      res => {
        var convert = require('xml-js');
        this.resenje=[];
        const decodedItem =JSON.parse(convert.xml2json(res,{compact: true, ignoreComment: true}));
        if(decodedItem.listaResenjeDTO.lista.constructor==[].constructor){
          for(var i  in decodedItem.listaResenjeDTO.lista){
            this.resenje.push(new Resenje(decodedItem.listaResenjeDTO.lista[i].id._text,
              decodedItem.listaResenjeDTO.lista[i].datum._text,decodedItem.listaResenjeDTO.lista[i].email._text,
              decodedItem.listaResenjeDTO.lista[i].brP._text));
          }
        }else{
          this.resenje.push(new Resenje(decodedItem.listaResenjeDTO.lista[i].id._text,
            decodedItem.listaResenjeDTO.lista[i].datum._text,decodedItem.listaResenjeDTO.lista[i].email._text,
            decodedItem.listaResenjeDTO.lista[i].brP._text));
        }
      }
      );
  }
  regIn2(){
        const search: any = {
    Query: {
      BrojPredmeta: { _text: '' }, ImePoverenika: { _text: '' }, PrezimePoverenika: { _text: '' }, Datum: { _text: '' }, Mesto: { _text: '' } } };
    search.Query.BrojPredmeta = this.regForm2.value.brojPredmeta;
    search.Query.ImePoverenika = this.regForm2.value.imePoverenika;
    search.Query.PrezimePoverenika = this.regForm2.value.prezimePoverenika;
    search.Query.Datum = this.regForm2.value.datum;
    search.Query.Gradjanin = this.regForm2.value.gradjanin;
    search.Query.NazivOptuzenog = this.regForm2.value.nazivOptuzenog;

    var convert = require('xml-js');
    var searchXML = convert.js2xml(search, {compact: true, ignoreComment: true});

    this.resenjeService.getSearchMetadataResenje(searchXML).subscribe(
      res => {
        //console.log(res);
        var convert = require('xml-js');
        this.resenje=[];
        const decodedItem =JSON.parse(convert.xml2json(res,{compact: true, ignoreComment: true}));
        if(decodedItem.listaResenjeDTO.lista.constructor==[].constructor){
          for(var i  in decodedItem.listaResenjeDTO.lista){
            this.resenje.push(new Resenje(decodedItem.listaResenjeDTO.lista[i].id._text,
              decodedItem.listaResenjeDTO.lista[i].datum._text,decodedItem.listaResenjeDTO.lista[i].email._text,
              decodedItem.listaResenjeDTO.lista[i].brP._text));
          }
        }else{
          this.resenje.push(new Resenje(decodedItem.listaResenjeDTO.lista[i].id._text,
            decodedItem.listaResenjeDTO.lista[i].datum._text,decodedItem.listaResenjeDTO.lista[i].email._text,
            decodedItem.listaResenjeDTO.lista[i].brP._text));
        }
      }
      );
  }

}
