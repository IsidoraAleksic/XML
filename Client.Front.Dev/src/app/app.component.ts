import { Component, OnInit } from '@angular/core';
import { DomSanitizer, SafeResourceUrl, SafeStyle } from '@angular/platform-browser';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  
  bgStyle: SafeStyle;

  constructor(
    private sanitizer: DomSanitizer
  ) { 
  }
  
  ngOnInit() {          
    this.switchBg();
  }

  private switchBg() {
    var bgs = [
      'https://i.imgur.com/o1hHhWP.jpg',
      'https://i.imgur.com/a3Jyic2.jpg',
      'https://i.imgur.com/K686gKX.jpg',
      'https://i.imgur.com/ftypKVO.jpg',
      'https://i.imgur.com/XYI9Bf8.jpg',
      'https://i.imgur.com/fZKv4Xl.jpg',
      'https://i.imgur.com/EZGBoEO.jpg',
      'https://i.imgur.com/FTxlnuS.jpg',
    ];
    var path = bgs[Math.round(Math.random() * (bgs.length - 1))];
    this.bgStyle = this.sanitizer.bypassSecurityTrustStyle('--bg:url(' + path + ')');
  } 

}
