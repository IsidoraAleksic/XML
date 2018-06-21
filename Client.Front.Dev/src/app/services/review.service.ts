import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  constructor(
    private http: HttpClient
  ) { }

  getAll(accommodationId): Observable<any[]> {
    return this.http.get<any[]>(environment.backendSrc + "review/" + accommodationId);
  }

  review(reservationId: number, review: any): Observable<any> {
    return this.http.post<any>(`${environment.backendSrc}review/${reservationId}`, review, { withCredentials: true });
  }

  rate(reservation: string, rating: string) {
    return this.http.post<any>(`${environment.backendSrc}rating`,null, {
      params: {
        reservation: reservation,
        rating: rating
      },
      withCredentials: true
    })
  }

}
