import { Component, OnInit } from '@angular/core';
import { BackgroundStyleService } from '../../services/background-style.service';
import { SearchService } from '../../services/search.service';
import { SettingsService } from '../../services/settings.service';
import { MatAutocompleteSelectedEvent, MatDialog, MatSnackBar } from '@angular/material';
import { AuthService } from '../../services/auth.service';
import { LoginDialogComponent } from '../login-dialog/login-dialog.component';
import { ReservationService } from '../../services/reservation.service';

@Component({
  selector: 'app-v2-index',
  templateUrl: './v2-index.component.html',
  styleUrls: ['./v2-index.component.css']
})
export class V2IndexComponent implements OnInit {

  startDate: any;
  endDate: any;

  reverseOrder: boolean = false;

  orderBy: string = '';

  state: string = "start";
  searchResults = [];

  constructor(
    public bg: BackgroundStyleService,
    private snackBar: MatSnackBar,
    private auth: AuthService,
    private matDialog: MatDialog,
    private reservationService: ReservationService,
    private searchService: SearchService
  ) { }

  ngOnInit() {
  }

  onOrderBy(value: string) {
    if (this.orderBy == value)
      this.reverseOrder = !this.reverseOrder;
    else
      this.reverseOrder = false;

    this.orderBy = value;

    this.searchResults.sort((a, b) => {
      if (value == 'cost') {
        if (!this.reverseOrder)
          return a.price - b.price;
        else
          return b.price - a.price;
      } else if (value == 'category') {
        if (!this.reverseOrder)
          return a.category.id - b.category.id;
        else
          return b.category.id - a.category.id;
      } else if (value == 'rating') {
        if (!this.reverseOrder)
          return a.rating - b.rating;
        else
          return b.rating - a.rating;
      }
    })
  }

  onBook(accommodation: any) {
    if (!this.auth.current) {
      this.matDialog.open(LoginDialogComponent);

    }
    else {
      this.reservationService.book({
        startDate: this.startDate,
        endDate: this.endDate,
        accommodationUnit: { id: accommodation.id }
      }).subscribe(x => {
        this.snackBar.open("Reservation made", "Ok", { duration: 1400 });
      }, x => {
        this.snackBar.open("Failed to make reservation", "Ok", { duration: 1400 });
      })
    }

  }

  onBasicSearch(search: any) {
    this.startDate = search.startDate;
    this.endDate = search.endDate;
    this.state = "loading";
    this.searchService.basicSearch(search)
      .subscribe(x => {
        this.searchResults = x;
        this.setResultState();
      }, err => { console.log(err) });
  }

  onAdvancedSearch(search: any) {
    this.startDate = search.startDate;
    this.endDate = search.endDate;
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
