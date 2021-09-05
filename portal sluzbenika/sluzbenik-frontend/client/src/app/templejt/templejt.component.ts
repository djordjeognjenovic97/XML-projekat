import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { TemplejtService } from '../services/templejt.service';

@Component({
  selector: 'app-templejt',
  templateUrl: './templejt.component.html',
  styleUrls: ['./templejt.component.scss']
})
export class TemplejtComponent implements OnInit {

  templejt: "";
  temp:string | null;
  sta:string |null;

  constructor(
    private templejtService: TemplejtService,
    private toastr: ToastrService,
    private router: Router,
    private route:ActivatedRoute) { 
      this.temp=this.route.snapshot.paramMap.get('id');
      this.sta=this.route.snapshot.paramMap.get('sta');
    }
  ngOnInit(): void {
      if(this.sta==="zahtev"){
        this.templejtService.getZahtevHTML(this.temp).subscribe(
          data=>{
            this.templejt=data;
          },
          error=>{
            console.log(error);
            this.toastr.error("Error");
          }
        );
      }
      if(this.sta==="izvestaj"){
        this.templejtService.getIzvestajHTML(this.temp).subscribe(
          data=>{
            console.log(data);
            this.templejt=data;
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
            this.templejt=data;
          },
          error=>{
            console.log(error);
            this.toastr.error("Error");
          }
        );
      }
      if(this.sta==="obavestenje"){
        this.templejtService.getObavestenjeHTML(this.temp).subscribe(
          data=>{
            this.templejt=data;
          },
          error=>{
            console.log(error);
            this.toastr.error("Error");
          }
        );
      }
  }

}
