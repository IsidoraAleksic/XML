import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  model: LoginData = {};
  loading: boolean = false;
  nok: boolean = false;

  constructor(
    private auth: AuthService,
    private router: Router
  ) { }

  ngOnInit() {
  }

  onLogin() {    
    this.loading = true;
    this.nok = false;
    this.auth.login(this.model as any).subscribe(x=>{
      if ( x == "ok")
        this.router.navigateByUrl("");
      else if (x == "nok")
        this.nok = true;
    })
  }

}

class LoginData {
  email?: string;
  password?: string;
}