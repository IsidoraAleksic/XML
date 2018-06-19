import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { MatDialogRef } from '@angular/material';

@Component({
  selector: 'app-login-dialog',
  templateUrl: './login-dialog.component.html',
  styleUrls: ['./login-dialog.component.css']
})
export class LoginDialogComponent implements OnInit {

  model: LoginData = {};
  loading: boolean = false;
  errmsg: any;

  showPassword: boolean = false;

  constructor(
    public dialogRef: MatDialogRef<LoginDialogComponent>,
    private auth: AuthService,
  ) { }

  ngOnInit() {
  }

  onLogin() {
    this.loading = true;
    this.errmsg = undefined;
    this.auth.login(this.model as any).subscribe(x => {
      this.dialogRef.close();
    }, e => {
      this.loading = false;
      if (e.status == 400 || e.status == 404) {
        this.errmsg = e.error.message;
      }
      else {
        this.errmsg = "Unknown error occured";
        console.log(e);
      }
    })
  }

}

class LoginData {
  email?: string;
  password?: string;
}