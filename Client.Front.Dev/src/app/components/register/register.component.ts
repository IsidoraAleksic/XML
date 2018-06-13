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
  nok: boolean = false;
  exists: boolean = false;

  constructor(
    private auth: AuthService,
    private router: Router
  ) { }

  ngOnInit() {
  }

  onRegister() {
    this.loading = true;
    this.nok = false;
    this.exists = false;
    this.auth.register(this.model as any).subscribe(x => {
      if (x == "ok")
        this.router.navigateByUrl("");
      else if (x == "nok")
        this.nok = true;
      else if (x == "exists")
        this.exists = true;
    });
  }

}

class RegisterData {
  firstName?: string;
  lastName?: string;
  email?: string;
  password?: string;
}