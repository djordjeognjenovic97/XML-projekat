import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Izvestaj } from '../models/izvestaj';
import { IzvestajService } from '../services/izvestaj.service';

declare var require: any

@Component({
  selector: 'app-izvestaj',
  templateUrl: './izvestaj.component.html',
  styleUrls: ['./izvestaj.component.scss']
})
export class IzvestajComponent implements OnInit {

  izvestaji: Izvestaj[] |undefined;
  regForm1:FormGroup;

  constructor(
    private toastr: ToastrService,
    private router:Router,
    private izvestajService: IzvestajService,
  	private fBuilder: FormBuilder,
  ) {
    this.regForm1 = this.fBuilder.group({
			datum: [""]
      });
   }

  ngOnInit(): void {
    this.regForm1.reset();
    this.izvestajService.getAllIzvestaji().subscribe(
      res => {
        console.log(res);
        console.log("ABRAKADABRA");
        var convert = require('xml-js');
        this.izvestaji=[];
        const decodedItem =JSON.parse(convert.xml2json(res,{compact: true, ignoreComment: true}));
        if(decodedItem.listaIzvestajaDTO.lista.constructor==[].constructor){
          for(var i  in decodedItem.listaIzvestajaDTO.lista){
            this.izvestaji.push(new Izvestaj(decodedItem.listaIzvestajaDTO.lista[i].id._text
              ,decodedItem.listaIzvestajaDTO.lista[i].datum._text
        ));
          }
        }else{
          this.izvestaji.push(new Izvestaj(decodedItem.listaIzvestajaDTO.lista.id._text,
            decodedItem.listaIzvestajaDTO.lista.datum._text));
        }
        console.log(this.izvestaji);
      }
      );
  }
  XHTML(c:String) {
    this.izvestajService.skiniXHTML(c).subscribe(
      data=>{
        var blob = new Blob([data], { type:"application/html"});
        var url = window.URL.createObjectURL(blob);
        var link = document.createElement('a');
        link.href = url;
        link.download = "izvestaj"+c+".html";
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
     this.router.navigate(['prikaz/izvestaj/'+c]);
  }
  PDF(c:String) {
    this.izvestajService.skiniPDF(c).subscribe(
      data=>{
        var blob = new Blob([data], { type:"application/pdf"});
        var url = window.URL.createObjectURL(blob);
        var link = document.createElement('a');
        link.href = url;
        link.download = "izvestaj"+c+".pdf";
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
    this.izvestajService.skiniRDF(c).subscribe(
      data=>{
        var blob = new Blob([data], { type:"application/xml"});
        var url = window.URL.createObjectURL(blob);
        var link = document.createElement('a');
        link.href = url;
        link.download = "izvestaj"+c+".xml";
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
    this.izvestajService.skiniJSON(c).subscribe(
      data=>{
        var blob = new Blob([data], { type:"application/json"});
        var url = window.URL.createObjectURL(blob);
        var link = document.createElement('a');
        link.href = url;
        link.download = "izvestaj"+c+".json";
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
    this.izvestajService.getSearchIzvestaji(this.regForm1.value.podatak).subscribe(
      res => {
        var convert = require('xml-js');
        this.izvestaji=[];
        const decodedItem =JSON.parse(convert.xml2json(res,{compact: true, ignoreComment: true}));
        if(decodedItem.listaIzvestajaDTO.lista.constructor==[].constructor){
          for(var i  in decodedItem.listaIzvestajaDTO.lista){
            this.izvestaji.push(new Izvestaj(decodedItem.listaIzvestajaDTO.lista[i].id._text,
              decodedItem.listaIzvestajaDTO.lista[i].datum._text,
              ));
          }
        }else{
          this.izvestaji.push(new Izvestaj(decodedItem.listaIzvestajaDTO.lista.id._text,
            decodedItem.listaIzvestajaDTO.lista.datum._text));
        }
      }
      );
  }
  generisiIzvestaj(){
    this.izvestajService.generateIzvestaj().subscribe(
      res => {
          this.toastr.success('Uspesno ste se generisali i poslali izvestaj!');
          this.router.navigate(['']);
        },
      error => {
				this.toastr.error('Problem sa generisanjem izvestaja. Pokusajte ponovo');
			}
      );
  }
}

