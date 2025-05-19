import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from '../model/client.model';

@Injectable({
  providedIn: 'root'
})
export class ClientServiceService {

  backendHost:string ="http://localhost:1111"
  constructor(private http:HttpClient) { }
  
  public getClients():Observable<Array<Client>>{
    return this.http.get<Array<Client>>(this.backendHost+"/clients")
  }
  public saveCustomer(customer: Client):Observable<Client>{
    return this.http.post<Client>(this.backendHost+"/customers",customer);
  }
  
}
