import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { ReviewService } from '../../services/review.service';

@Component({
  selector: 'app-rating-dialog',
  templateUrl: './rating-dialog.component.html',
  styleUrls: ['./rating-dialog.component.css']
})
export class RatingDialogComponent implements OnInit {

  rating: number = 1;

  constructor(
    public dialogRef: MatDialogRef<RatingDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private reviewService: ReviewService
  ) { }

  ngOnInit() {
  }

  onRate() {
    this.dialogRef.close(this.rating);
  }

}
