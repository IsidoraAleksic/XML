import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { MatDialogRef } from '@angular/material';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-login-dialog',
  templateUrl: './login-dialog.component.html',
  styleUrls: ['./login-dialog.component.css']
})
export class LoginDialogComponent implements OnInit {

  form: FormGroup;
  loading: boolean = false;
  errmsg: any;

  showPassword: boolean = false;

  constructor(
    private fb: FormBuilder,
    public dialogRef: MatDialogRef<LoginDialogComponent>,
    private auth: AuthService,
  ) { }

  ngOnInit() {
    this.form = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]]
    });
  }

  onLogin() {
    if (this.form.invalid) {
      Object.keys(this.form.controls).forEach(field => { // {1}
        const control = this.form.get(field);            // {2}
        control.markAsTouched({ onlySelf: true });       // {3}
      });
      return;
    }

    this.loading = true;
    this.errmsg = undefined;
    this.auth.login(this.form.value as any).subscribe(x => {
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
    });
  }

}