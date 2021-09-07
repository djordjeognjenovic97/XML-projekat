import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ZahtevService } from 'src/app/services/zahtev.service';

declare const Xonomy: any;

@Component({
  selector: 'app-add-zahtev',
  templateUrl: './add-zahtev.component.html',
  styleUrls: ['./add-zahtev.component.scss']
})
export class AddZahtevComponent implements OnInit {

  constructor(
    private zahtevService: ZahtevService,
    private toastr: ToastrService,
    private router: Router) { }

  ngOnInit(): void {
  }

  ngAfterViewInit() {
    let element = document.getElementById("zahtev");
    let specification = this.zahtevService.ZahtevSpecification;
    let xmlString = '<?xml version="1.0" encoding="UTF-8"?><zahtev xmlns="https://github.com/djordjeognjenovic97/XML-projekat/zahtev" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="https://github.com/djordjeognjenovic97/XML-projekat file:/C:/Users/TehnoCentar/Desktop/zahtevcir.xsd" xmlns:pred="http://www.ftn.uns.ac.rs/rdf/examples/predicate/" stanje=""><id property="pred:id"></id><naziv>Z A H T E V za pristup informaciji od javnog značaja</naziv><organ><naziv property="pred:naziv"></naziv><sediste></sediste></organ><sadrzaj><tipovi_zahteva></tipovi_zahteva><opis_informacije></opis_informacije></sadrzaj><mesto_podnosenja_zahteva property="pred:mesto"></mesto_podnosenja_zahteva><datum_podnosenja_zahteva property="pred:datum"></datum_podnosenja_zahteva><trazilac_informacije email=""><ime></ime><prezime></prezime><adresa><mesto></mesto><ulica></ulica><br_ulice></br_ulice></adresa><drugi_kontakt_podaci></drugi_kontakt_podaci></trazilac_informacije></zahtev>'; 
    //<organ><naziv></naziv><sediste></sediste></organ><sadrzaj><tipovi_zahteva><dostavljanje_kopije></dostavljanje_kopije></tipovi_zahteva><opis_informacije></opis_informacije></sadrzaj><trazilac_informacije><ime></ime><prezime></prezime><adresa><mesto></mesto><ulica></ulica><br_ulice></br_ulice></adresa><drugi_kontakt_podaci></drugi_kontakt_podaci></trazilac_informacije>
    Xonomy.render(xmlString, element, specification);
  }
  send(){
    if (Xonomy.warnings.length) {
      this.toastr.error("Podaci nisu ispravni/uneseni.Molimo vas proverite ih još jednom.");
      return;
    }
    let zahtev =  Xonomy.harvest();
    this.zahtevService.createZahtev(zahtev).subscribe(
      res => {
          this.toastr.success('Uspešno ste kreirali zahtev!')
          this.router.navigate(['']);
        },
      err=> {
          this.toastr.error('Neuspešno ste kreirali zahtev. Proverite unesene podatke da li su ispravni!')
      });
  }

  natrag(){
    this.router.navigate(['']);
  }
}
