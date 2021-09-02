import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-add-resenja-poverenik',
  templateUrl: './add-resenja-poverenik.component.html',
  styleUrls: ['./add-resenja-poverenik.component.scss']
})
export class AddResenjaPoverenikComponent implements OnInit {

  temp:string | null;

  constructor(private route:ActivatedRoute) { 
      this.temp=this.route.snapshot.paramMap.get('id');
    }

  ngOnInit(): void {
  }

}
