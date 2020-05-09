import { Component, OnInit,OnChanges } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit,OnChanges {

  userName : any;
  constructor() { }

  ngOnInit() {
  	
  }

  ngOnChanges() {
  	console.log(this.userName);
  	this.userName = sessionStorage.getItem("userName");
  }
  
}
