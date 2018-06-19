import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { SettingsService } from '../../services/settings.service';

@Component({
  selector: 'app-search-form',
  templateUrl: './search-form.component.html',
  styleUrls: ['./search-form.component.css']
})
export class SearchFormComponent implements OnInit {

  advanced: boolean;
  search: any = {
    type: 1,
    category: 1
  };

  @Output() basicSearch = new EventEmitter<any>();
  @Output() advancedSearch = new EventEmitter<any>();

  constructor(
    public settings: SettingsService
  ) { }

  ngOnInit() {
  }

  onSearch() {
    if (this.advanced) {
      this.advancedSearch.emit(this.search);
    }
    else {
      this.basicSearch.emit(this.search);
    }
  }

}