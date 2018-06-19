import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

@Component({
  selector: 'app-option-dialog',
  templateUrl: './option-dialog.component.html',
  styleUrls: ['./option-dialog.component.css']
})
export class OptionDialogComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<OptionDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: OptionDialogData,
  ) { }

  ngOnInit() {
  }

}

export class OptionDialogData {
  title?: string;
  message?: string;
  actions?: OptionDialogAction[];
}

export class OptionDialogAction {
  title: string;
  result: any;
}
