import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Izvestaj } from 'src/app/models/izvestaj';
import { IzvestajService } from 'src/app/services/izvestaj.service';

declare var require: any


@Component({
  selector: 'app-lista-izvestaja-poverenik',
  templateUrl: './lista-izvestaja-poverenik.component.html',
  styleUrls: ['./lista-izvestaja-poverenik.component.scss']
})
export class ListaIzvestajaPoverenikComponent implements OnInit {

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
    this.izvestajService.skiniPDF(c).subscribe(
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
    this.izvestajService.skiniRDF(c).subscribe(
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
    this.izvestajService.skiniJSON(c).subscribe(
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
}
