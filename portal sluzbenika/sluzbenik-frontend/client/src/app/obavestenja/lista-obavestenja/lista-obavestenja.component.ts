import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Obavestenje } from 'src/app/models/obavestenje';
import { ObavestenjaService } from 'src/app/services/obavestenja.service';

declare var require: any

@Component({
  selector: 'app-lista-obavestenja',
  templateUrl: './lista-obavestenja.component.html',
  styleUrls: ['./lista-obavestenja.component.scss']
})
export class ListaObavestenjaComponent implements OnInit {
  obavestenja: Obavestenje[] |undefined;

  constructor(
    private toastr: ToastrService,
    private router:Router,
    private obavestenjeService: ObavestenjaService
  ) { }

  ngOnInit(): void {
    this.obavestenjeService.getUsersObavestenja().subscribe(
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
        var blob = new Blob([data], { type:"application/html"});
        var url = window.URL.createObjectURL(blob);
        var link = document.createElement('a');
        link.href = url;
        link.download = "obavestenje"+c+".html";
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
     this.router.navigate(['prikaz/obavestenje/'+c]);
  }
  PDF(c:String) {
    this.obavestenjeService.skiniPDF(c).subscribe(
      data=>{
        var blob = new Blob([data], { type:"application/pdf"});
        var url = window.URL.createObjectURL(blob);
        var link = document.createElement('a');
        link.href = url;
        link.download = "obavestenje"+c+".pdf";
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
    this.obavestenjeService.skiniRDF(c).subscribe(
      data=>{
        var blob = new Blob([data], { type:"application/xml"});
        var url = window.URL.createObjectURL(blob);
        var link = document.createElement('a');
        link.href = url;
        link.download = "obavestenje"+c+".xml";
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
    this.obavestenjeService.skiniJSON(c).subscribe(
      data=>{
        var blob = new Blob([data], { type:"application/json"});
        var url = window.URL.createObjectURL(blob);
        var link = document.createElement('a');
        link.href = url;
        link.download = "obavestenje"+c+".json";
        link.click();
        this.toastr.success('Uspesno preuzet dokument.');
      },
      error=>{
        console.log(error);
        this.toastr.error("Neuspesno preuzet dokument.Pokusajte ponovo.");
      }
    );
  }
}
