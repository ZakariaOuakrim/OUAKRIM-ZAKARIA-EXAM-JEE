import { NewclientComponent } from './newclient/newclient.component';
import { CreditComponent } from './credit/credit.component';
import { ClientsComponent } from './clients/clients.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path :"clients", component : ClientsComponent},
  { path :"credits", component : CreditComponent},
  { path :"addClient", component : NewclientComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
