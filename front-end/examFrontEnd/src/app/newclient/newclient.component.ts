import { Client } from './../model/client.model';
import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { ClientServiceService } from './../services/client-service.service';

import { FormBuilder, Validators } from '@angular/forms';
import { Router } from 'express';
@Component({
  selector: 'app-newclient',
  templateUrl: './newclient.component.html',
  styleUrl: './newclient.component.css'

})
export class NewclientComponent implements OnInit{

  
  newCustomerFormGroup! : FormGroup;
  constructor(private fb : FormBuilder, private customerService:ClientServiceService, private router:Router) { }
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  handleSaveCustomer() {
    let customer:Client=this.newCustomerFormGroup.value;
      this.customerService.saveCustomer(customer).subscribe({
        next : data=>{
          alert("Customer has been successfully saved!");
          //this.newCustomerFormGroup.reset();
        },
        error : err => {
          console.log(err);
        }
      });
  }
}
