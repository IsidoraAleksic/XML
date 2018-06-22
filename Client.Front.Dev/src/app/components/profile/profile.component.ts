import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { BackgroundStyleService } from '../../services/background-style.service';
import { Router } from '@angular/router';
import { ReservationService } from '../../services/reservation.service';
import { MatDialog, MatSnackBar } from '@angular/material';
import { OptionDialogComponent, OptionDialogData } from '../option-dialog/option-dialog.component';
import { ReviewListDialogComponent } from '../review-list-dialog/review-list-dialog.component';
import { ReviewService } from '../../services/review.service';
import { RatingDialogComponent } from '../rating-dialog/rating-dialog.component';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  reservations: any[];

  constructor(
    private matDialog: MatDialog,
    private snackBar: MatSnackBar,
    private router: Router,
    public bg: BackgroundStyleService,
    public auth: AuthService,
    private reservationService: ReservationService,
    private reviewService: ReviewService
  ) { }

  ngOnInit() {
    this.reservationService.getAll().subscribe(x => {
      this.reservations = x;
    })
    this.auth.logoutEvent.subscribe((x: any) => {
      this.router.navigateByUrl("");
    })
  }

  onCancel(reservation: any) {
    this.matDialog.open(OptionDialogComponent, {
      data: {
        title: "Cancel Reservation",
        message: "Are you sure you want to cancel this reservation?",
        actions: [
          { result: true, title: "Yes" },
          { result: false, title: "No" },
        ]
      } as OptionDialogData
    }).afterClosed().subscribe(x => {
      if (x) {
        this.reservationService.cancel(reservation.id).subscribe(x => {
          this.reservations.splice(this.reservations.indexOf(reservation), 1);
        });
      }
    })
  }

  onRate(reservation: any) {
    this.matDialog.open(RatingDialogComponent, {
      data: reservation
    }).afterClosed().subscribe(x=>{
      if (x) {
        this.reviewService.rate(reservation.id, x).subscribe(x=>{
          this.snackBar.open("Thanks for rating","Np",{duration: 1400});
        }, err=>{
          if (err.status == 409)
            this.snackBar.open("Already rated","Ok",{duration: 1400});
        });
      }
      
    })
  }

  onReview(reservation: any) {
    this.matDialog.open(ReviewListDialogComponent, {
      width: '80vw',
      maxWidth: '600px',
      panelClass: 'dialog-aligner',
      data:
        {
          reservationId: reservation.id,
          id: reservation.accommodationUnit.id,
          place: reservation.accommodationUnit.place,
          canReview: true
        }
    })
  }

  showReviews(reservation: any) {
    this.matDialog.open(ReviewListDialogComponent, {
      width: '80vw',
      maxWidth: '600px',
      panelClass: 'dialog-aligner',
      data:
        {
          id: reservation.accommodationUnit.id,
          place: reservation.accommodationUnit.place,
        }
    })
  }

}
