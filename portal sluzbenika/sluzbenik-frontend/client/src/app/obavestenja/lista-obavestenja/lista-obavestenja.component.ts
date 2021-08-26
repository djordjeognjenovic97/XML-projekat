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

}
