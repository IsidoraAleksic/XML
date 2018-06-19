import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { UserDTO } from '../models/user-dto';
import { environment } from '../../environments/environment';
import { IWebDriverOptionsCookie } from 'selenium-webdriver';
import { Subscribable } from '../events/subscribable';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  current: UserDTO;

  logoutEvent: Subscribable<any> = new Subscribable<any>();

  constructor(private http: HttpClient) {
    this.http.get<UserDTO>(environment.backendSrc + "authenticate/getUser", { withCredentials: true }).subscribe(x => {
      this.current = x;
    })
  }

  login(user: any): Observable<string> {
    return this.http.post<string>(environment.backendSrc + "authenticate/login", user, { withCredentials: true }).pipe(
      tap(_ => {
          this.http.get<UserDTO>(environment.backendSrc + "authenticate/getUser", { withCredentials: true }).subscribe(x => {
            this.current = x;
          })
      })
    );
  }

  register(user: any): Observable<string> {
    return this.http.post<string>(environment.backendSrc + "authenticate/register", user);
  }

  logout(): Observable<string> {
    if (this.current)
      return this.http.get<string>(environment.backendSrc + "authenticate/logout", { withCredentials: true }).pipe(
        tap(_ => { 
          this.logoutEvent.next(true);
          this.current = null;
         })
      );
    return null;
  }



} 
