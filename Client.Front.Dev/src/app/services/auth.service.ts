import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { UserDTO } from '../models/user-dto';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  current: UserDTO;

  constructor(private http: HttpClient) { }

  login(user: any): Observable<string> {
    return this.http.post<string>(environment.backendSrc + "authenticate/login", user, { withCredentials: true }).pipe(
      tap(_ => {
        if (_ == "ok")
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
    return this.http.get<string>(environment.backendSrc + "authenticate/logout", { withCredentials: true });
  }



} 
