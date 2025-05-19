import { CreditService } from './../credit.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import {Router} from "@angular/router";
import { Credit } from '../model/credit.model';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-credit',
  templateUrl: './credit.component.html',
  styleUrl: './credit.component.css'
})
export class CreditComponent implements OnInit{
  constructor(private creditService : CreditService, private fb : FormBuilder, private router : Router) { }
  credits! : Observable<Array<Credit>>;


  ngOnInit(): void {
    this.credits=this.creditService.();
  }



}
