import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Resenje } from 'src/app/models/resenje';
import { ResenjeService } from 'src/app/services/resenje.service';

declare var require: any

@Component({
  selector: 'app-lista-resenja',
  templateUrl: './lista-resenja.component.html',
  styleUrls: ['./lista-resenja.component.scss']
})
export class ListaResenjaComponent implements OnInit {


  resenja: Resenje[] |undefined;

  constructor(
    private toastr: ToastrService,
    private router:Router,
    private resenjeService: ResenjeService
  ) { }

  ngOnInit(): void {
    this.resenjeService.getUsersResenje().subscribe(
      res => {
        console.log(res);
        console.log("ABRAKADABRA");
        var convert = require('xml-js');
        this.resenja=[];
        const decodedItem =JSON.parse(convert.xml2json(res,{compact: true, ignoreComment: true}));
        if(decodedItem.listaResenjeDTO.lista.constructor==[].constructor){
          for(var i  in decodedItem.listaResenjeDTO.lista){
            this.resenja.push(new Resenje(decodedItem.listaResenjeDTO.lista[i].id._text,
              decodedItem.listaResenjeDTO.lista[i].datum._text,decodedItem.listaResenjeDTO.lista[i].email._text,
              decodedItem.listaResenjeDTO.lista[i].brP._text));
          }
        }else{
          this.resenja.push(new Resenje(decodedItem.listaResenjeDTO.lista[i].id._text,
            decodedItem.listaResenjeDTO.lista[i].datum._text,decodedItem.listaResenjeDTO.lista[i].email._text,
            decodedItem.listaResenjeDTO.lista[i].brP._text));
        }
        console.log(this.resenja);
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
}
