import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  constructor(private http: HttpClient) { }

  basicSearch(search: any): Observable<any> {
    return this.http.get<any>(environment.backendSrc + "search/basicSearch", {
      params: {
        "place": search.place,
        "startDate": search.startDate.toISOString().slice(0,10),
        "endDate": search.endDate.toISOString().slice(0,10),
        "people": search.people,
      }
    });
  }

  advancedSearch(search: any): Observable<any> {
    return this.http.get<any>(environment.backendSrc + "search/advancedSearch", {
      params: {
        "place": search.place,
        "startDate": search.startDate.toISOString().slice(0,10),
        "endDate": search.endDate.toISOString().slice(0,10),
        "people": search.people,
        "type": search.type,
        "category": search.category,
        "additionalServices[]": search.additionalServices
      }
    });
  }
}
