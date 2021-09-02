import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ZalbaOdbijenService } from 'src/app/services/zalbaOdbijen.service';

declare const Xonomy: any;

@Component({
  selector: 'app-add-zalba-odbijen',
  templateUrl: './add-zalba-odbijen.component.html',
  styleUrls: ['./add-zalba-odbijen.component.scss']
})
export class AddZalbaOdbijenComponent implements OnInit {

  constructor(private zalbaOdbijenService: ZalbaOdbijenService,
    private toastr: ToastrService,
    private router: Router) { }

  ngOnInit(): void {
  }

  ngAfterViewInit() {
    let element = document.getElementById("zalbaodbijen");
    let specification = this.zalbaOdbijenService.ZalbaOdbijenSpecification;
    let xmlString = '<?xml version="1.0" encoding="UTF-8"?><zalbaodluka xmlns="https://github.com/djordjeognjenovic97/XML-projekat/zalbanaodlukucir" xmlns:pred="http://www.ftn.uns.ac.rs/rdf/examples/predicate/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="https://github.com/djordjeognjenovic97/XML-projekat/zalbanaodlukucir file:/C:/Users/Win10/Documents/GitHub/XML-projekat/portal%20poverenika/poverenik/src/main/resources/zalbanaodlukucir.xsd" stanje="kreirano"><podnosilac_zalbe email=""><ime property="pred:ime"></ime><prezime property="pred:prezime"></prezime><adresa><mesto></mesto><ulica></ulica><br_ulice></br_ulice></adresa></podnosilac_zalbe><naziv_organa></naziv_organa><datum_predmeta></datum_predmeta><broj_predmeta property="pred:broj_predmeta"></broj_predmeta><sadrzaj><datum_zahteva></datum_zahteva><razlog_zalbe></razlog_zalbe></sadrzaj><drugi_podaci_za_kontakt></drugi_podaci_za_kontakt><datum property="pred:datum"></datum><mesto property="pred:mesto"></mesto></zalbaodluka>';
    //<organ><naziv></naziv><sediste></sediste></organ><sadrzaj><tipovi_zahteva><dostavljanje_kopije></dostavljanje_kopije></tipovi_zahteva><opis_informacije></opis_informacije></sadrzaj><trazilac_informacije><ime></ime><prezime></prezime><adresa><mesto></mesto><ulica></ulica><br_ulice></br_ulice></adresa><drugi_kontakt_podaci></drugi_kontakt_podaci></trazilac_informacije>
    Xonomy.render(xmlString, element, specification);
  }

  send(){
    if (Xonomy.warnings.length) {
      this.toastr.error("Podaci nisu ispravni/uneseni.Molimo vas proverite ih jos jednom.");
      return;
    }
    let zalba =  Xonomy.harvest();
    this.zalbaOdbijenService.createZalbaOdbijen(zalba).subscribe(
      res => {
          this.toastr.success('Uspesno ste kreirali zalbu na odluku!')
          this.router.navigate(['']);
        },
      err=> {
          this.toastr.error('Neuspesno ste kreirali zalbu na odluku. Proverite podatke!')
      });
  }

  natrag(){
    this.router.navigate(['']);
  }

}
