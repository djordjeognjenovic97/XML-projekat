import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ResenjeService } from 'src/app/services/resenje.service';

declare var require: any

@Component({
  selector: 'app-lista-resenja',
  templateUrl: './lista-resenja.component.html',
  styleUrls: ['./lista-resenja.component.scss']
})
export class ListaResenjaComponent implements OnInit {


  resenja: String[] |undefined;

  constructor(
    private toastr: ToastrService,
    private router:Router,
    private resenjeService: ResenjeService
  ) { }

  ngOnInit(): void {
    this.resenjeService.getUsersResenja().subscribe(
      res => {
        console.log("ABRAKADABRA");
        var convert = require('xml-js');
        this.resenja=[];
        const decodedItem =JSON.parse(convert.xml2json(res,{compact: true, ignoreComment: true}));
        for(var i  in decodedItem.idList.ids){
          console.log("var");
          console.log(decodedItem.idList.ids[i]._text);
          this.resenja.push(decodedItem.idList.ids[i]._text);
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
