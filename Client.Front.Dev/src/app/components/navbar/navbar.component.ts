import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { MatDialog } from '@angular/material';
import { LoginDialogComponent } from '../login-dialog/login-dialog.component';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(
    public matDialog: MatDialog,
    public auth: AuthService
  ) { }

  ngOnInit() {
  }

  onLogin() {
    this.matDialog.open(LoginDialogComponent);
  }

  onLogout() {
    this.auth.logout().subscribe();
  }  

}
