import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Izjasnjenje } from '../models/izjasnjenje';
import { IzjasnjenjeService } from '../services/izjasnjenje.service';

declare var require: any

@Component({
  selector: 'app-izjasnjenje',
  templateUrl: './izjasnjenje.component.html',
  styleUrls: ['./izjasnjenje.component.scss']
})
export class IzjasnjenjeComponent implements OnInit {
  izjasnjenja: Izjasnjenje[] |undefined;
  regForm1:FormGroup;

  constructor(
    private toastr: ToastrService,
    private router:Router,
    private izjasnjenjeService: IzjasnjenjeService,
  	private fBuilder: FormBuilder,
  ) {
    this.regForm1 = this.fBuilder.group({
			podatak: [""]
      });
  }

  ngOnInit(): void {
    this.izjasnjenjeService.getAllIzjasnjenja().subscribe(
      res => {
        console.log(res);
        console.log("ABRAKADABRA");
        var convert = require('xml-js');
        this.izjasnjenja=[];
        const decodedItem =JSON.parse(convert.xml2json(res,{compact: true, ignoreComment: true}));
        if(decodedItem.listaIzjasnjenjaDTO.lista.constructor==[].constructor){
          for(var i  in decodedItem.listaIzjasnjenjaDTO.lista){
            this.izjasnjenja.push(new Izjasnjenje(decodedItem.listaIzjasnjenjaDTO.lista[i].id._text,"",
              decodedItem.listaIzjasnjenjaDTO.lista[i].mail._text));
          }
        }else{
          this.izjasnjenja.push(new Izjasnjenje(decodedItem.listaIzjasnjenjaDTO.lista.id._text,"",
            decodedItem.listaIzjasnjenjaDTO.lista.mesto._text));
        }
        console.log(this.izjasnjenja);
      }
      );
  }
  regIn1(id){
    this.izjasnjenjeService.izjasniSe(new Izjasnjenje(id,this.regForm1.value.podatak,"")).subscribe(
      res => {
          this.toastr.success('Uspesno ste se izjasnili!');
          this.router.navigate(['']);
        }
      );
  }
}
