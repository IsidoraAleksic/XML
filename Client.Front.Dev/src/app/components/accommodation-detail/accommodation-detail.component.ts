import { Component, OnInit, Input } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ReviewListDialogComponent } from '../review-list-dialog/review-list-dialog.component';

@Component({
  selector: 'app-accommodation-detail',
  templateUrl: './accommodation-detail.component.html',
  styleUrls: ['./accommodation-detail.component.css']
})
export class AccommodationDetailComponent implements OnInit {

  @Input() accommodation: any;

  constructor(
    private matDialog: MatDialog
  ) { }

  ngOnInit() {
  }

  onBook() {

  }

  showReviews() {
    this.matDialog.open(ReviewListDialogComponent, {
      width: '100%',
      maxWidth: '600px',
      panelClass: 'dialog-aligner',
      data: this.accommodation
    });
  }

}
