import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SettingsService {

  additionalServices: any[];  
  accommodationTypes: any[];
  accommodationCategories: any[];
  
  constructor(
    private http: HttpClient
  ) {
    this.http.get<any>(environment.backendSrc+"search").subscribe(x=>{
      this.accommodationTypes = x.accommodationTypes;
      this.accommodationCategories = x.accommodationCategories;
      this.additionalServices = x.additionalServices;
    })
  }
}
