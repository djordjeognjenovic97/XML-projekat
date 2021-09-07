import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ResenjeService } from 'src/app/services/resenje.service';

declare const Xonomy: any;

@Component({
  selector: 'app-add-resenja-poverenik',
  templateUrl: './add-resenja-poverenik.component.html',
  styleUrls: ['./add-resenja-poverenik.component.scss']
})
export class AddResenjaPoverenikComponent implements OnInit {

  temp:string | null;

  constructor(private route:ActivatedRoute,private resenjeService: ResenjeService,
    private toastr: ToastrService,
    private router: Router) {
      this.temp=this.route.snapshot.paramMap.get('id');
    }

  ngOnInit(): void {
  }

  ngAfterViewInit() {
    let element = document.getElementById("resenje");
    let specification = this.resenjeService.ResenjeSpecification;
    let xmlString = '<?xml version="1.0" encoding="UTF-8"?><resenje xmlns="https://github.com/djordjeognjenovic97/XML-projekat/resenja" xmlns:pred="http://www.ftn.uns.ac.rs/rdf/examples/predicate/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="https://github.com/djordjeognjenovic97/XML-projekat/resenja file:/C:/Users/Win10/Documents/GitHub/XML-projekat/portal%20poverenika/poverenik/src/main/resources/resenja.xsd" email_gradjanina="" id="' + this.temp +'"><datum property="pred:datum"></datum><broj_resenja property="pred:broj_resenja"></broj_resenja><status></status><gradjanin property="pred:gradjanin"></gradjanin><datum_podnosenja></datum_podnosenja><optuzeni><naziv_optuzenog property="pred:naziv_optuzenog"></naziv_optuzenog><sediste_optuzenog></sediste_optuzenog></optuzeni><opis_zalbe><razlog></razlog><na_osnovu></na_osnovu><zakon><clan></clan><stav></stav><tacka></tacka><naziv_zakona></naziv_zakona><naziv_sluzbenog_glasnika></naziv_sluzbenog_glasnika><broj_slg></broj_slg></zakon></opis_zalbe><resenje_zalbe><rok_trajanja_mora_izvrsi_resenje></rok_trajanja_mora_izvrsi_resenje><dokument_koji_se_trazi></dokument_koji_se_trazi><rok_trajanja_provera></rok_trajanja_provera></resenje_zalbe><obrazlozenja_zalbe><datum_izjasnjenja></datum_izjasnjenja><datum_trazenja_informacija></datum_trazenja_informacija><datum_odgovora></datum_odgovora><razlozi_odluke><pasus></pasus><pasus></pasus></razlozi_odluke></obrazlozenja_zalbe><poverenik><ime property="pred:ime"></ime><prezime property="pred:prezime"></prezime></poverenik></resenje>';
    //<organ><naziv></naziv><sediste></sediste></organ><sadrzaj><tipovi_zahteva><dostavljanje_kopije></dostavljanje_kopije></tipovi_zahteva><opis_informacije></opis_informacije></sadrzaj><trazilac_informacije><ime></ime><prezime></prezime><adresa><mesto></mesto><ulica></ulica><br_ulice></br_ulice></adresa><drugi_kontakt_podaci></drugi_kontakt_podaci></trazilac_informacije>
    Xonomy.render(xmlString, element, specification);
  }

  send(){
    if (Xonomy.warnings.length) {
      this.toastr.error("Podaci nisu ispravni/uneseni.Molimo vas proverite ih jos jednom.");
      return;
    }
    let resenje =  Xonomy.harvest();
    this.resenjeService.createResenje(resenje).subscribe(
      res => {
          this.toastr.success('Uspesno ste kreirali resenje!');
          this.router.navigate(['']);
        },
      err=> {
          this.toastr.error('Neuspesno ste kreirali resenje. Proverite podatke i molimo Vas popunite sva polja!');
          console.log(err);
          console.log("nesto");
      });
  }

  natrag(){
    this.router.navigate(['']);
  }

}
