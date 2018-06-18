import { Component, OnInit } from '@angular/core';
import { BackgroundStyleService } from '../../services/background-style.service';
import { SearchService } from '../../services/search.service';
import { SettingsService } from '../../services/settings.service';
import { MatAutocompleteSelectedEvent } from '@angular/material';

@Component({
  selector: 'app-v2-index',
  templateUrl: './v2-index.component.html',
  styleUrls: ['./v2-index.component.css']
})
export class V2IndexComponent implements OnInit {

  constructor(
    public bg: BackgroundStyleService,
    private searchService: SearchService
  ) { }

  ngOnInit() {
  }
  
  onBasicSearch(search: any) {
    this.searchService.basicSearch(search)
      .subscribe(x => {
        console.log(x);
      }, err => { console.log(err) });
  }

  onAdvancedSearch(search: any) {
    this.searchService.advancedSearch(search)
    .subscribe(x => {
      console.log(x);
    }, err => { console.log(err) });
  }

}
