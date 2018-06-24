import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {


  constructor(private http: HttpClient) {
  }

  getOne(id: number): Observable<any> {
    return this.http.get<any>(`${environment.backendSrc}reserve/${id}`, { withCredentials: true })
  }

  getAll(): Observable<any[]> {
    return this.http.get<any[]>(`${environment.backendSrc}reserve`, { withCredentials: true })
  }

  book(reservation: any): Observable<any> {
    return this.http.post<any>(`${environment.backendSrc}reserve`, reservation, { withCredentials: true });
  }

  cancel(id: number): Observable<any> {
    return this.http.delete<any>(`${environment.backendSrc}reserve/${id}`,
      {
        withCredentials: true
      });
  }

}
