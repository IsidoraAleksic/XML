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

  onBook(accommodation: any) {
    if (!this.auth.current) {
      this.matDialog.open(LoginDialogComponent);

    }
    else {
      this.reservationService.book({
        startDate: this.startDate,
        endDate: this.endDate,
        accommodationUnit: {id: accommodation.id}      
      }).subscribe(x=>{
        this.snackBar.open("Reservation made", "Ok", { duration: 1400 });
      }, x=>{
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
