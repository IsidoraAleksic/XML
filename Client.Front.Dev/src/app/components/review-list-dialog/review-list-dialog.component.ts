import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA, MatSnackBar } from '@angular/material';
import { ReviewService } from '../../services/review.service';

@Component({
  selector: 'app-review-list-dialog',
  templateUrl: './review-list-dialog.component.html',
  styleUrls: ['./review-list-dialog.component.css']
})
export class ReviewListDialogComponent implements OnInit {

  state: string = 'loading';
  reviews: any[];
  dissTrack: string;

  constructor(
    public dialogRef: MatDialogRef<ReviewListDialogComponent>,
    private snackBar: MatSnackBar,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private reviewService: ReviewService
  ) { }

  ngOnInit() {
    this.reviewService.getAll(this.data.id).subscribe(x => {
      console.log(x);
      this.reviews = x;
      if (this.reviews.length == 0)
        this.state = 'no-results';
      else
        this.state = 'results';
    })
  }

  onReview() {
    this.reviewService.review(this.data.reservationId, {
      review: this.dissTrack,
      accommodationUnit: {
        id: this.data.id
      }
    }).subscribe(x => {
      this.dialogRef.close();
      this.snackBar.open("Your review has been submitted", "Ok", { duration: 1400 });
    })
  }

}
