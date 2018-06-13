import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material';

@Component({
  selector: 'app-image-carousel-dialog',
  templateUrl: './image-carousel-dialog.component.html',
  styleUrls: ['./image-carousel-dialog.component.css']
})
export class ImageCarouselDialogComponent implements OnInit {

  idx: number = 0;

  constructor(
    @Inject(MAT_DIALOG_DATA) public data: any
  ) { }

  ngOnInit() {
  }

}
