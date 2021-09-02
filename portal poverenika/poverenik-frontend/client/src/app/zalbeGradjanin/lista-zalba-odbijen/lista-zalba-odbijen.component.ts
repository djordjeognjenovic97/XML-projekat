import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ZalbaOdluka } from 'src/app/models/zalbaOdbijen';
import { ZalbaOdbijenService } from 'src/app/services/zalbaOdbijen.service';

declare var require: any

@Component({
  selector: 'app-lista-zalba-odbijen',
  templateUrl: './lista-zalba-odbijen.component.html',
  styleUrls: ['./lista-zalba-odbijen.component.scss']
})
export class ListaZalbaOdbijenComponent implements OnInit {

  zalbe: ZalbaOdluka[] |undefined;

  constructor(
    private toastr: ToastrService,
    private router:Router,
    private zalbaService: ZalbaOdbijenService
  ) { }

  ngOnInit(): void {
    this.zalbaService.getUsersZalbeOdbijen().subscribe(
      res => {
        console.log(res);
        console.log("ABRAKADABRA");
        var convert = require('xml-js');
        this.zalbe=[];
        const decodedItem =JSON.parse(convert.xml2json(res,{compact: true, ignoreComment: true}));
        if(decodedItem.listaZalbanaodlukuDTO.lista.constructor==[].constructor){
          for(var i  in decodedItem.listaZalbanaodlukuDTO.lista){
            this.zalbe.push(new ZalbaOdluka(decodedItem.listaZalbanaodlukuDTO.lista[i].id._text,
              decodedItem.listaZalbanaodlukuDTO.lista[i].mesto._text,decodedItem.listaZalbanaodlukuDTO.lista[i].datum._text));
          }
        }else{
          this.zalbe.push(new ZalbaOdluka(decodedItem.listaZalbanaodlukuDTO.lista.id._text,
            decodedItem.listaZalbanaodlukuDTO.lista.mesto._text,decodedItem.listaZalbanaodlukuDTO.lista.datum._text));
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
