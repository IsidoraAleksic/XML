import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

  advanced: boolean = false;
  search: any = {};
  selectedType: string;
  selectedService: string;

  constructor(
    public auth: AuthService
  ) { }

  ngOnInit() {
  }

  onSearch() {
    console.log(this.search);
  }

}
