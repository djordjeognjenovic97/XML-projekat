import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ZalbaCutanje } from 'src/app/models/zalbaCutanje';
import { ZalbaCutanjeService } from 'src/app/services/zalbaCutanje.service';

declare var require: any

@Component({
  selector: 'app-lista-zalba-cutanje',
  templateUrl: './lista-zalba-cutanje.component.html',
  styleUrls: ['./lista-zalba-cutanje.component.scss']
})
export class ListaZalbaCutanjeComponent implements OnInit {

  zalbe: ZalbaCutanje[] |undefined;

  constructor(
    private toastr: ToastrService,
    private router:Router,
    private zalbaService: ZalbaCutanjeService
  ) { }

  ngOnInit(): void {
    this.zalbaService.getUsersZalbe().subscribe(
      res => {
        console.log(res);
        console.log("ABRAKADABRA");
        var convert = require('xml-js');
        this.zalbe=[];
        const decodedItem =JSON.parse(convert.xml2json(res,{compact: true, ignoreComment: true}));
        if(decodedItem.listaZalbacutanjeDTO.lista.constructor==[].constructor){
          for(var i  in decodedItem.listaZalbacutanjeDTO.lista){
            this.zalbe.push(new ZalbaCutanje(decodedItem.listaZalbacutanjeDTO.lista[i].id._text,
              decodedItem.listaZalbacutanjeDTO.lista[i].mesto._text,decodedItem.listaZalbacutanjeDTO.lista[i].datum._text,
              decodedItem.listaZalbacutanjeDTO.lista[i].stanje._text));
          }
        }else{
          this.zalbe.push(new ZalbaCutanje(decodedItem.listaZalbacutanjeDTO.lista.id._text,
            decodedItem.listaZalbacutanjeDTO.lista.mesto._text,decodedItem.listaZalbacutanjeDTO.lista.datum._text,
            decodedItem.listaZalbacutanjeDTO.lista.stanje._text));
        }
        console.log(this.zalbe);
      }
      );
  }
  XHTML(c:String) {
    this.zalbaService.skiniXHTML(c).subscribe(
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
    this.zalbaService.skiniPDF(c).subscribe(
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
    this.zalbaService.skiniRDF(c).subscribe(
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
    this.zalbaService.skiniJSON(c).subscribe(
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
