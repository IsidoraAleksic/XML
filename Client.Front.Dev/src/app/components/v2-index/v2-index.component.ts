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

  state: string = "results";
  searchResults = [{
    id: 1,
    price: 1000,
    place: "Place",
    description: "Description",
    additionalServices: []
  },{
    price: 1000,
    place: "Place",
    description: "Description",
    additionalServices: []
  },{
    price: 1000,
    place: "Place",
    description: "Description",
    additionalServices: []
  },{
    price: 1000,
    place: "Place",
    description: "Description",
    additionalServices: []
  },{
    price: 1000,
    place: "Place",
    description: "Description",
    additionalServices: []
  }];

  constructor(
    public bg: BackgroundStyleService,
    private searchService: SearchService
  ) { }

  ngOnInit() {
  }
  
  onBasicSearch(search: any) {
    this.state = "loading";
    this.searchService.basicSearch(search)
      .subscribe(x => {
        this.searchResults = x;
        this.setResultState();
      }, err => { console.log(err) });
  }

  onAdvancedSearch(search: any) {
    this.state = "loading";
    this.searchService.advancedSearch(search)
    .subscribe(x => {
      this.searchResults = x;
      this.setResultState();
    }, err => { console.log(err) });
  }

  private setResultState() {
    if (this.searchResults.length == 0)
      this.state = "no-results";
    else
      this.state = "results";
  }

}
