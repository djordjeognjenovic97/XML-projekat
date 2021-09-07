import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ObavestenjaService } from 'src/app/services/obavestenja.service';

declare const Xonomy: any;

@Component({
  selector: 'app-add-obavestenja',
  templateUrl: './add-obavestenja.component.html',
  styleUrls: ['./add-obavestenja.component.scss']
})
export class AddObavestenjaComponent implements OnInit {

  temp:string | null;

  constructor(
    private obavestenjaService: ObavestenjaService,
    private toastr: ToastrService,
    private router: Router,
    private route:ActivatedRoute) { 
      this.temp=this.route.snapshot.paramMap.get('idZahtev');
    }

  ngOnInit(): void {
  }

  ngAfterViewInit() {
    let element = document.getElementById("obavestenje");
    let specification = this.obavestenjaService.ObavestenjeSpecification;
    let xmlString = '<?xml version="1.0" encoding="UTF-8"?><obavestenje xmlns="https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="https://github.com/djordjeognjenovic97/XML-projekat file:/C:/Users/TehnoCentar/Desktop/obavestenjecir.xsd" xmlns:pred="http://www.ftn.uns.ac.rs/rdf/examples/predicate/"><organ><naziv_organa property="pred:naziv_organa"></naziv_organa><sediste_organa></sediste_organa></organ><broj_predmeta property="pred:broj_predmeta">'+this.temp+'</broj_predmeta><datum property="pred:datum"></datum><podnosilac_zahteva email=""><ime property="pred:ime"></ime><prezime property="pred:prezime"></prezime><adresa><mesto></mesto><ulica></ulica><br_ulice></br_ulice></adresa></podnosilac_zahteva><datum_zahteva></datum_zahteva><naslov></naslov><uvid><opis_trazene_informacije></opis_trazene_informacije><datum_uvida></datum_uvida><broj_sati></broj_sati><pocetak_akcije>09:00:00.000</pocetak_akcije><kraj_akcije>20:00:00.000</kraj_akcije><adresa><mesto></mesto><ulica></ulica><br_ulice></br_ulice></adresa><broj_kancelarije></broj_kancelarije></uvid><iznos_troskova></iznos_troskova><dostavljeno></dostavljeno></obavestenje>'; 
    //<organ><naziv></naziv><sediste></sediste></organ><sadrzaj><tipovi_zahteva><dostavljanje_kopije></dostavljanje_kopije></tipovi_zahteva><opis_informacije></opis_informacije></sadrzaj><trazilac_informacije><ime></ime><prezime></prezime><adresa><mesto></mesto><ulica></ulica><br_ulice></br_ulice></adresa><drugi_kontakt_podaci></drugi_kontakt_podaci></trazilac_informacije>
    Xonomy.render(xmlString, element, specification);
  }
  send(){
    if (Xonomy.warnings.length) {
      this.toastr.error("Podaci nisu ispravni/uneseni.Molimo vas proverite ih jos jednom.");
      return;
    }
    let obavestenje =  Xonomy.harvest();
    this.obavestenjaService.createObavestenje(obavestenje).subscribe(
      res => {
          this.toastr.success('Uspesno ste kreirali obavestenje!')
          this.router.navigate(['']);
        },
      err=> {
          this.toastr.error('Neuspesno ste kreirali obavestenje. Proverite podatke!')
      });
  }

  natrag(){
    this.router.navigate(['']);
  }
}
