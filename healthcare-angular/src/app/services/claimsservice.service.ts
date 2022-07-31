import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Claims } from '../models/claims';


@Injectable({
  providedIn: 'root'
})
export class ClaimsService {

  constructor(private http: HttpClient) { }

  public getClaims(): Observable<Claims[]> {
    return this.http.get<Claims[]>('http://localhost:8080/claim-app/claims');

  }
}
