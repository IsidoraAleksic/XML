import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  model: RegisterData = {};
  loading: boolean = false;
  errmsg: string;

  constructor(
    private auth: AuthService,
    private router: Router
  ) { }

  ngOnInit() {
  }

  onRegister() {
    this.loading = true;
    this.errmsg = undefined;
    this.auth.register(this.model as any).subscribe(x => {
      this.router.navigateByUrl("login");
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

class RegisterData {
  firstName?: string;
  lastName?: string;
  email?: string;
  password?: string;
}