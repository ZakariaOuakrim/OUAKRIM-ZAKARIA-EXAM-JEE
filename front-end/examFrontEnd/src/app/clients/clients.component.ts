import { ClientServiceService } from './../services/client-service.service';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from '../model/client.model';
import {FormBuilder, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";



@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrl: './clients.component.css'
})
export class ClientsComponent implements OnInit {

  clients! : Observable<Array<Client>>;
  errorMessage!: string;
  searchFormGroup : FormGroup | undefined;
  constructor(private clientService : ClientServiceService, private fb : FormBuilder, private router : Router) { }

  ngOnInit(): void {
    this.clients=this.clientService.getClients();
    this.searchFormGroup=this.fb.group({
      keyword : this.fb.control("")
    });
  }

  handleSearchClients() {
    throw new Error('Method not implemented.');
    }


}
