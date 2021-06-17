import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ZahtevService } from 'src/app/services/zahtev.service';

declare const Xonomy: any;

@Component({
  selector: 'app-add-zahtev',
  templateUrl: './add-zahtev.component.html',
  styleUrls: ['./add-zahtev.component.scss']
})
export class AddZahtevComponent implements OnInit {

  constructor(private zahtevService: ZahtevService, private router: Router) { }

  ngOnInit(): void {
  }

  ngAfterViewInit() {
    let element = document.getElementById("zahtev");
    let specification = this.zahtevService.ZahtevSpecification;
    let xmlString = '<?xml version="1.0" encoding="UTF-8"?><zahtev xmlns="https://github.com/djordjeognjenovic97/XML-projekat" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="https://github.com/djordjeognjenovic97/XML-projekat file:/C:/Users/TehnoCentar/Desktop/zahtevcir.xsd" datum="" mesto=""><naziv>Z A H T E V za pristup informaciji od javnog značaja</naziv><organ><naziv></naziv><sediste></sediste></organ><sadrzaj><tipovi_zahteva></tipovi_zahteva><opis_informacije></opis_informacije></sadrzaj><trazilac_informacije><ime></ime><prezime></prezime><adresa><mesto></mesto><ulica></ulica><br_ulice></br_ulice></adresa><drugi_kontakt_podaci></drugi_kontakt_podaci></trazilac_informacije></zahtev>'; 
    //<organ><naziv></naziv><sediste></sediste></organ><sadrzaj><tipovi_zahteva><dostavljanje_kopije></dostavljanje_kopije></tipovi_zahteva><opis_informacije></opis_informacije></sadrzaj><trazilac_informacije><ime></ime><prezime></prezime><adresa><mesto></mesto><ulica></ulica><br_ulice></br_ulice></adresa><drugi_kontakt_podaci></drugi_kontakt_podaci></trazilac_informacije>
    Xonomy.render(xmlString, element, specification);
  }
  send(){

  }

  natrag(){
    this.router.navigate(['']);
  }
}
