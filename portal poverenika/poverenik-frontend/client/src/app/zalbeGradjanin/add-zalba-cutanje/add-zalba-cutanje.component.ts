import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ZalbaCutanjeService } from 'src/app/services/zalbaCutanje.service';

declare const Xonomy: any;

@Component({
  selector: 'app-add-zalba-cutanje',
  templateUrl: './add-zalba-cutanje.component.html',
  styleUrls: ['./add-zalba-cutanje.component.scss']
})
export class AddZalbaCutanjeComponent implements OnInit {


  constructor(
    private zalbaCutanjeService: ZalbaCutanjeService,
    private toastr: ToastrService,
    private router: Router) { }

  ngOnInit(): void {
  }

  ngAfterViewInit() {
    let element = document.getElementById("zalbaCutanje");
    let specification = this.zalbaCutanjeService.ZalbaCutanjeSpecification;
    let xmlString = '<?xml version="1.0" encoding="UTF-8"?><zalbacutanje xmlns="https://github.com/djordjeognjenovic97/XML-projekat/zalbacutanjecir" xmlns:pred="http://www.ftn.uns.ac.rs/rdf/examples/predicate/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="https://github.com/djordjeognjenovic97/XML-projekat/zalbacutanjecir file:/C:/Users/Win10/Documents/GitHub/XML-projekat/portal%20poverenika/poverenik/src/main/resources/zalbacutanjecir.xsd" stanje="kreirano"><sadrzaj><naziv_organa></naziv_organa><razlog_zalbe></razlog_zalbe><datum_orginalnog_zahteva></datum_orginalnog_zahteva><podaci_o_zahtevu></podaci_o_zahtevu></sadrzaj><podnosilac_zalbe email=""><ime property="pred:ime"></ime><prezime property="pred:prezime"></prezime><adresa><mesto></mesto><ulica></ulica><br_ulice></br_ulice></adresa></podnosilac_zalbe><broj_predmeta property="pred:broj_predmeta"></broj_predmeta><datum property="pred:datum"></datum><mesto property="pred:mesto"></mesto></zalbacutanje>';
    //<organ><naziv></naziv><sediste></sediste></organ><sadrzaj><tipovi_zahteva><dostavljanje_kopije></dostavljanje_kopije></tipovi_zahteva><opis_informacije></opis_informacije></sadrzaj><trazilac_informacije><ime></ime><prezime></prezime><adresa><mesto></mesto><ulica></ulica><br_ulice></br_ulice></adresa><drugi_kontakt_podaci></drugi_kontakt_podaci></trazilac_informacije>
    Xonomy.render(xmlString, element, specification);
  }

  send(){
    if (Xonomy.warnings.length) {
      this.toastr.error("Podaci nisu ispravni/uneseni.Molimo vas proverite ih jos jednom.");
      return;
    }
    let zalba =  Xonomy.harvest();
    this.zalbaCutanjeService.createZalbaCutanje(zalba).subscribe(
      res => {
          this.toastr.success('Uspesno ste kreirali zalbu cutanje!')
          this.router.navigate(['']);
        },
      err=> {
          this.toastr.error('Neuspesno ste kreirali zalbu cutanje. Proverite podatke!')
      });
  }

  natrag(){
    this.router.navigate(['']);
  }
}
