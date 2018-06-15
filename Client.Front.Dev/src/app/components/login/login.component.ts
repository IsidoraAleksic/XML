import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import { environment } from '../../../environments/environment';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  model: LoginData = {};
  loading: boolean = false;
  errmsg: any;

  constructor(
    private auth: AuthService,
    private router: Router
  ) { }

  ngOnInit() {
  }

  onLogin() {
    this.loading = true;
    this.errmsg = undefined;
    this.auth.login(this.model as any).subscribe(x => {
      this.router.navigateByUrl("");
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