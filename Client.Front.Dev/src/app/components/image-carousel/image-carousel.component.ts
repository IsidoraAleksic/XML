import { Component, OnInit, Input } from '@angular/core';
import { MatDialog } from '@angular/material';
import { ImageCarouselDialogComponent } from './image-carousel-dialog/image-carousel-dialog.component';

@Component({
  selector: 'app-image-carousel',
  templateUrl: './image-carousel.component.html',
  styleUrls: ['./image-carousel.component.css']
})
export class ImageCarouselComponent implements OnInit {

  @Input() srcs: string[];
  @Input() title: string;
  idx: number = 0;

  constructor(
    private matDialog: MatDialog
  ) { }

  ngOnInit() {
  }

  onOpen() {
    this.matDialog.open(ImageCarouselDialogComponent, {
      maxWidth: "none",
      width: "95%",
      height: "95%",
      data: this
    })
  }

}
