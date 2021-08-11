import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ZahtevService } from 'src/app/services/zahtev.service';

declare var require: any

@Component({
  selector: 'app-lista-zahtev-sluzbenik',
  templateUrl: './lista-zahtev-sluzbenik.component.html',
  styleUrls: ['./lista-zahtev-sluzbenik.component.scss']
})
export class ListaZahtevSluzbenikComponent implements OnInit {

  zahtevi: String[] |undefined;

  constructor(
    private toastr: ToastrService,
    private router:Router,
    private zahtevService: ZahtevService
  ) { }

  ngOnInit(): void {
    this.zahtevService.getAllZahtevi().subscribe(
      res => {
        console.log(res);
        console.log("ABRAKADABRA");
        var convert = require('xml-js');
        this.zahtevi=[];
        const decodedItem =JSON.parse(convert.xml2json(res,{compact: true, ignoreComment: true}));
        for(var i  in decodedItem.idList.id){
          console.log("var");
          console.log(decodedItem.idList.id[i]._text);
          this.zahtevi.push(decodedItem.idList.id[i]._text);
        }
        console.log(this.zahtevi);
      }
      );
  }
  XHTML(c:String) {
    this.zahtevService.skiniXHTML(c).subscribe(
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
    this.zahtevService.skiniPDF(c).subscribe(
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
    this.zahtevService.skiniRDF(c).subscribe(
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
    this.zahtevService.skiniJSON(c).subscribe(
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

}
