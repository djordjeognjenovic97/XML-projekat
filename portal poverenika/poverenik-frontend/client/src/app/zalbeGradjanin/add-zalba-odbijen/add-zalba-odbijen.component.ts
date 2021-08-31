import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-zalba-odbijen',
  templateUrl: './add-zalba-odbijen.component.html',
  styleUrls: ['./add-zalba-odbijen.component.scss']
})
export class AddZalbaOdbijenComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  send(){

  }

  natrag(){
    this.router.navigate(['']);
  }

}
