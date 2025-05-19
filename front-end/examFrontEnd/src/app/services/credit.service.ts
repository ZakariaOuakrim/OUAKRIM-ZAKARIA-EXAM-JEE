import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { Credit } from '../model/credit.model';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CreditService {
  backendHost:string ="http://localhost:1111"
  constructor(private http:HttpClient) { }
  public getCredits():Observable<Array<Credit>>{
    return this.http.get<Array<Credit>>(this.backendHost+"/credits")
  }
}
