import { Component, OnInit } from '@angular/core';
import { DomSanitizer, SafeHtml } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { TemplejtService } from '../services/templejt.service';

declare var require: any

@Component({
  selector: 'app-templejt',
  templateUrl: './templejt.component.html',
  styleUrls: ['./templejt.component.scss']
})
export class TemplejtComponent implements OnInit {

  templejt:SafeHtml;
  temp:string | null;
  sta:string |null;

  constructor(
    private templejtService: TemplejtService,
    private toastr: ToastrService,
    private router: Router,
    private route:ActivatedRoute,
    private domSanitizer: DomSanitizer) {
      this.temp=this.route.snapshot.paramMap.get('id');
      this.sta=this.route.snapshot.paramMap.get('sta');
    }
  ngOnInit(): void {
      if(this.sta==="zalbanaodluku"){
        this.templejtService.getZalbanaodlukuHTML(this.temp).subscribe(
          data=>{
            console.log(data);
            var convert = require('xml-js');
            var decodedItem1 =data.split("<body>")[1];
            var decodedItem2 =decodedItem1.split("</body>")[0];
            console.log(decodedItem2);
            this.templejt = this.domSanitizer.bypassSecurityTrustHtml(data);
          },
          error=>{
            console.log(error);
            this.toastr.error("Error");
          }
        );
      }
      if(this.sta==="zalbacutanje"){
        this.templejtService.getZalbacutanjeHTML(this.temp).subscribe(
          data=>{
            console.log(data);
            this.templejt = this.domSanitizer.bypassSecurityTrustHtml(data);
          },
          error=>{
            console.log(error);
            this.toastr.error("Error");
          }
        );
      }
      if(this.sta==="resenje"){
        this.templejtService.getResenjeHTML(this.temp).subscribe(
          data=>{
            this.templejt = this.domSanitizer.bypassSecurityTrustHtml(data);
          },
          error=>{
            console.log(error);
            this.toastr.error("Error");
          }
        );
      }
  }

}
