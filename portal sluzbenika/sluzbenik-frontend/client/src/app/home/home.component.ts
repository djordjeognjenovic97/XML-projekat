import { Component, OnInit } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';

declare var require: any

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  role: any;
  loggedIn:boolean|undefined;

  constructor() {
  }

  ngOnInit(): void {
    const item = localStorage.getItem('user');
    this.loggedIn =  localStorage.getItem('accessToken') ? true : false;

		if (!item) {
			this.role = undefined;
			return;
		}
    const jwt: JwtHelperService = new JwtHelperService();
    var convert = require('xml-js');
    const decodedItem =JSON.parse(convert.xml2json(item,{compact: true, ignoreComment: true}));
    const info = jwt.decodeToken(decodedItem.UserToken.accessToken._text);
    this.role=info['uloga'];
  }
}
