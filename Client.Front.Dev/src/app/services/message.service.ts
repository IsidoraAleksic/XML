import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  constructor(
    private http: HttpClient
  ) { }

  getAll(reservationId: number): Observable<any[]> {
    return this.http.get<any[]>(`${environment.backendSrc}message/${reservationId}`, { withCredentials: true });
  }

  send(message: any): Observable<any> {
    return this.http.post<any>(`${environment.backendSrc}message`, message, { withCredentials: true });
  }

}
