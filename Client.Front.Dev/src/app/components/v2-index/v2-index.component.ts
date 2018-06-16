import { Component, OnInit } from '@angular/core';
import { BackgroundStyleService } from '../../services/background-style.service';

@Component({
  selector: 'app-v2-index',
  templateUrl: './v2-index.component.html',
  styleUrls: ['./v2-index.component.css']
})
export class V2IndexComponent implements OnInit {

  constructor(
    public bg:BackgroundStyleService
  ) { }

  ngOnInit() {
  }

}
