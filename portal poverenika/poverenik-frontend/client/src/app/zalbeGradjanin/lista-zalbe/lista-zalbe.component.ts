import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ZalbaService } from 'src/app/services/zalba.service';

declare var require: any

@Component({
  selector: 'app-lista-zalbe',
  templateUrl: './lista-zalbe.component.html',
  styleUrls: ['./lista-zalbe.component.scss']
})
export class ListaZalbeComponent implements OnInit {


  zalbe: String[] |undefined;

  constructor(
    private toastr: ToastrService,
    private router:Router,
    private zalbaService: ZalbaService
  ) { }

  ngOnInit(): void {
    this.zalbaService.getUsersZalbe().subscribe(
      res => {
        console.log("ABRAKADABRA");
        var convert = require('xml-js');
        this.zalbe=[];
        const decodedItem =JSON.parse(convert.xml2json(res,{compact: true, ignoreComment: true}));
        for(var i  in decodedItem.idList.ids){
          console.log("var");
          console.log(decodedItem.idList.ids[i]._text);
          this.zalbe.push(decodedItem.idList.ids[i]._text);
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
