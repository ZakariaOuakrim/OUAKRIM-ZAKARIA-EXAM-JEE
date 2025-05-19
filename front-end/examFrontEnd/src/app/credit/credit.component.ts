import { CreditService } from './../services/credit.service';
import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import { Credit } from '../model/credit.model';
import { Observable } from 'rxjs';
import {FormBuilder, FormGroup} from "@angular/forms";


@Component({
  selector: 'app-credit',
  templateUrl: './credit.component.html',
  styleUrl: './credit.component.css'
})
export class CreditComponent implements OnInit{
  credits! : Observable<Array<Credit>>;
  errorMessage!: string;
  searchFormGroup : FormGroup | undefined;
  constructor(private creditService : CreditService, private fb : FormBuilder, private router : Router) { }


  ngOnInit(): void {
    this.credits=this.creditService.getCredits();
    this.searchFormGroup=this.fb.group({
      keyword : this.fb.control("")
    });
  }
  handleSearchCredits() {
    throw new Error('Method not implemented.');
    }



}
