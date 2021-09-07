import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ZalbaOdluka } from 'src/app/models/zalbaOdbijen';
import { ZalbaOdbijenService } from 'src/app/services/zalbaOdbijen.service';

declare var require: any

@Component({
  selector: 'app-lista-zalba-odbijen-poverenik',
  templateUrl: './lista-zalba-odbijen-poverenik.component.html',
  styleUrls: ['./lista-zalba-odbijen-poverenik.component.scss']
})
export class ListaZalbaOdbijenPoverenikComponent implements OnInit {

  zalba: ZalbaOdluka[] |undefined;
  regForm1:FormGroup;
  regForm2:FormGroup;

  constructor(
    private toastr: ToastrService,
    private router:Router,
    private zalbaService: ZalbaOdbijenService,
  	private fBuilder: FormBuilder,) {
      this.regForm1 = this.fBuilder.group({
        podatak: [""]
        });
      this.regForm2 = this.fBuilder.group({
        brojPredmeta: [""],
        imePodnosioca: [""],
        prezimePodnosioca: [""],
        datum: [""],
        mesto: [""],
        });
     }

  ngOnInit(): void {
    this.regForm1.reset();
    this.regForm2.reset();
    this.zalbaService.getAllZalbaOdbijen().subscribe(
      res => {
        console.log(res);
        console.log("ABRAKADABRA");
        var convert = require('xml-js');
        this.zalba=[];
        const decodedItem =JSON.parse(convert.xml2json(res,{compact: true, ignoreComment: true}));
        if(decodedItem.listaZalbanaodlukuDTO.lista.constructor==[].constructor){
          for(var i  in decodedItem.listaZalbanaodlukuDTO.lista){
            this.zalba.push(new ZalbaOdluka(decodedItem.listaZalbanaodlukuDTO.lista[i].id._text,
              decodedItem.listaZalbanaodlukuDTO.lista[i].mesto._text,decodedItem.listaZalbanaodlukuDTO.lista[i].datum._text,
              decodedItem.listaZalbanaodlukuDTO.lista[i].stanje._text));
          }
        }else{
          this.zalba.push(new ZalbaOdluka(decodedItem.listaZalbanaodlukuDTO.lista.id._text,
            decodedItem.listaZalbanaodlukuDTO.lista.mesto._text,decodedItem.listaZalbanaodlukuDTO.lista.datum._text,
            decodedItem.listaZalbanaodlukuDTO.lista.stanje._text));
        }
        console.log(this.zalba);
      }
      );
  }
  XHTML(c:String) {
    this.zalbaService.skiniXHTML(c).subscribe(
      data=>{
        var blob = new Blob([data], { type:"application/html"});
        var url = window.URL.createObjectURL(blob);
        var link = document.createElement('a');
        link.href = url;
        link.download = "zalbanaodluku"+c+".html";
        link.click();
        this.toastr.success('Uspesno preuzet dokument.');
      },
      error=>{
        console.log(error);
        this.toastr.error("Neuspesno preuzet dokument.Pokusajte ponovo.");
      }
    );
  }
  PDF(c:String) {
    this.zalbaService.skiniPDF(c).subscribe(
      data=>{
        var blob = new Blob([data], { type:"application/pdf"});
        var url = window.URL.createObjectURL(blob);
        var link = document.createElement('a');
        link.href = url;
        link.download = "zalbanaodluku"+c+".pdf";
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
    this.zalbaService.skiniRDF(c).subscribe(
      data=>{
        var blob = new Blob([data], { type:"application/xml"});
        var url = window.URL.createObjectURL(blob);
        var link = document.createElement('a');
        link.href = url;
        link.download = "zalbanaodluku"+c+".xml";
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
    this.zalbaService.skiniJSON(c).subscribe(
      data=>{
        var blob = new Blob([data], { type:"application/json"});
        var url = window.URL.createObjectURL(blob);
        var link = document.createElement('a');
        link.href = url;
        link.download = "zalbanaodluku"+c+".json";
        link.click();
        this.toastr.success('Uspesno preuzet dokument.');
      },
      error=>{
        console.log(error);
        this.toastr.error("Neuspesno preuzet dokument.Pokusajte ponovo.");
      }
    );
  }
	regIn1(){
    this.zalbaService.getSearchZalbaOdbijen(this.regForm1.value.podatak).subscribe(
      res => {
        var convert = require('xml-js');
        this.zalba=[];
        const decodedItem =JSON.parse(convert.xml2json(res,{compact: true, ignoreComment: true}));
        if(decodedItem.listaZalbanaodlukuDTO.lista.constructor==[].constructor){
          for(var i  in decodedItem.listaZalbanaodlukuDTO.lista){
            this.zalba.push(new ZalbaOdluka(decodedItem.listaZalbanaodlukuDTO.lista[i].id._text,
              decodedItem.listaZalbanaodlukuDTO.lista[i].mesto._text,decodedItem.listaZalbanaodlukuDTO.lista[i].datum._text,
              decodedItem.listaZalbanaodlukuDTO.lista[i].stanje._text));
          }
        }else{
          this.zalba.push(new ZalbaOdluka(decodedItem.listaZalbanaodlukuDTO.lista.id._text,
            decodedItem.listaZalbanaodlukuDTO.lista.mesto._text, decodedItem.listaZalbanaodlukuDTO.lista.datum._text,
            decodedItem.listaZalbanaodlukuDTO.lista.stanje._text));
        }
      }
      );
  }
  regIn2(){
        const search: any = {
    Query: {
      BrojPredmeta: { _text: '' }, ImePodnosioca: { _text: '' }, PrezimePodnosioca: { _text: '' }, Datum: { _text: '' }, Mesto: { _text: '' } } };
    search.Query.BrojPredmeta = this.regForm2.value.brojPredmeta;
    search.Query.ImePodnosioca = this.regForm2.value.imePodnosioca;
    search.Query.PrezimePodnosioca = this.regForm2.value.prezimePodnosioca;
    search.Query.Datum = this.regForm2.value.datum;
    search.Query.Mesto = this.regForm2.value.mesto;

    var convert = require('xml-js');
    var searchXML = convert.js2xml(search, {compact: true, ignoreComment: true});

    this.zalbaService.getSearchMetadataZalbaOdbijen(searchXML).subscribe(
      res => {
        //console.log(res);
        var convert = require('xml-js');
        this.zalba=[];
        const decodedItem =JSON.parse(convert.xml2json(res,{compact: true, ignoreComment: true}));
        if(decodedItem.listaZalbanaodlukuDTO.lista.constructor==[].constructor){
          for(var i  in decodedItem.listaZalbanaodlukuDTO.lista){
            this.zalba.push(new ZalbaOdluka(decodedItem.listaZalbanaodlukuDTO.lista[i].id._text,
              decodedItem.listaZalbanaodlukuDTO.lista[i].mesto._text, decodedItem.listaZalbanaodlukuDTO.lista[i].datum._text,
              decodedItem.listaZalbanaodlukuDTO.lista[i].stanje._text));
          }
        }else{
          this.zalba.push(new ZalbaOdluka(decodedItem.listaZalbanaodlukuDTO.lista.id._text,
            decodedItem.listaZalbanaodlukuDTO.lista.mesto._text, decodedItem.listaZalbanaodlukuDTO.lista.datum._text,
            decodedItem.listaZalbanaodlukuDTO.lista.stanje._text));
        }
      }
      );
  }
    traziIzjasnjenje(id:String) {
    this.zalbaService.traziIzjasnjenje(id).subscribe(
      data=>{
        this.toastr.success('Uspesno poslat upit za izjasnjenjem.');
        this.router.navigate(['']);
      },
      error=>{
        console.log(error);
        this.toastr.error("Neuspesno poslat upit za izjasnjenjem.");
      }
    );
  }
  pogledajIzjasnjenje(id:String) {
    this.zalbaService.pogledajIzjasnjenje(id).subscribe(
      data=>{
        var convert = require('xml-js');
        const decodedItem =JSON.parse(convert.xml2json(data,{compact: true, ignoreComment: true}));
        this.toastr.success("IZJASNJENJE: "+decodedItem.izjasnjenjeDTO.sadrzaj._text);
      },
      error=>{
        console.log(error);
        this.toastr.error("Neuspesno pogledato izjasnjenje.");
      }
    );
  }
  kreirajResenje(id:String) {
      this.router.navigateByUrl('/add-resenje/'+id);
  }

}
