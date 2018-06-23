import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { BackgroundStyleService } from '../../services/background-style.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  form: FormGroup;
  loading: boolean = false;
  errmsg: string;

  showPassword: boolean = false;

  constructor(
    private fb: FormBuilder,
    public bg: BackgroundStyleService,
    private auth: AuthService,
    private router: Router
  ) { }

  ngOnInit() {
    this.form = this.fb.group({
      firstName: ['', [Validators.required, Validators.minLength(2)]],
      lastName: ['', [Validators.required, Validators.minLength(2)]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(5)]]
    });
  }

  onRegister() {
    if (this.form.invalid) {
      Object.keys(this.form.controls).forEach(field => { // {1}
        const control = this.form.get(field);            // {2}
        control.markAsTouched({ onlySelf: true });       // {3}
      });
      return;
    }

    this.loading = true;
    this.errmsg = undefined;
    this.auth.register(this.form.value as any).subscribe(x => {
      this.router.navigateByUrl("");
    }, e => {
      this.loading = false;
      if (e.status == 400 || e.status == 409) {
        this.errmsg = e.error.message;
      }
      else {
        this.errmsg = "Unknown error occured";
        console.log(e);
      }
    });

  }

}