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
    private zahtevService: ZalbaCutanjeService,
    private toastr: ToastrService,
    private router: Router) { }

  ngOnInit(): void {
  }

  ngAfterViewInit() {
    let element = document.getElementById("zalbacutanje");
    let specification = this.zahtevService.ZahtevSpecification;
    let xmlString = '<?xml version="1.0" encoding="UTF-8"?><zalbacutanje xmlns="https://github.com/djordjeognjenovic97/XML-projekat/zc" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="https://github.com/djordjeognjenovic97/XML-projekat file:zalbacutanjecir.xsd" datum="" mesto="" br_predmeta=""><naslov>ŽALBA KADA ORGAN VLASTI NIJE POSTUPIO/ nije postupio u celosti/ PO ZAHTEVU TRAŽIOCA U ZAKONSKOM RADU (ĆUTANJE UPRAVE)</naslov><primalac_zalbe><naziv>Povereniku za informacije od javnog značaja i zaštitu podataka o ličnosti</naziv><adresa><mesto></mesto><ulica></ulica><br_ulice></br_ulice></adresa></primalac_zalbe><sadrzaj><naziv_organa></naziv_organa><razlog_zalbe></razlog_zalbe><datum_zahteva></datum_zahteva><podaci_o_zahtevu_i_info></podaci_o_zahtevu_i_info></sadrzaj><podnosilac_zalbe><ime></ime><prezime></prezime><adresa><mesto></mesto><ulica></ulica><br_ulice></br_ulice></adresa><drugi_kontakt_podaci></drugi_kontakt_podaci></podnosilac_zalbe></zalbacutanje>'; 
    //<organ><naziv></naziv><sediste></sediste></organ><sadrzaj><tipovi_zahteva><dostavljanje_kopije></dostavljanje_kopije></tipovi_zahteva><opis_informacije></opis_informacije></sadrzaj><trazilac_informacije><ime></ime><prezime></prezime><adresa><mesto></mesto><ulica></ulica><br_ulice></br_ulice></adresa><drugi_kontakt_podaci></drugi_kontakt_podaci></trazilac_informacije>
    Xonomy.render(xmlString, element, specification);
  }
  send(){
    if (Xonomy.warnings.length) {
      this.toastr.error("Podaci nisu ispravni/uneseni.Molimo vas proverite ih jos jednom.");
      return;
    }
    let zahtev =  Xonomy.harvest();
    this.zahtevService.createZalbaCutanje(zahtev).subscribe(
      res => {
          this.toastr.success('Uspesno ste kreirali zalbu!')
          this.router.navigate(['']);
        },
      err=> {
          this.toastr.error('Neuspesno ste kreirali zahtev. Proverite podatke!')
      });
  }

  natrag(){
    this.router.navigate(['']);
  }
}
