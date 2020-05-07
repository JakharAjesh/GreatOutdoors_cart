import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule }   from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { AddItemComponent } from './components/add-item/add-item.component';
import { DeleteItemComponent } from './components/delete-item/delete-item.component';
import { ShowItemsComponent } from './components/show-items/show-items.component';
import {CrudServiceService} from './services/crud-service.service';
import { SearchComponent } from './components/search/search.component';
import { ErrorComponentComponent } from './components/error-component/error-component.component';
import { CartComponent } from './components/cart/cart.component';
import { SearchbarComponent } from './components/searchbar/searchbar.component';
import { ExploreComponent } from './components/explore/explore.component';









@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AddItemComponent,
    DeleteItemComponent,
    ShowItemsComponent,
    SearchComponent,
    ErrorComponentComponent,
    CartComponent,
    SearchbarComponent,
    ExploreComponent,
    
  
    
    

   

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule

  ],
  providers: [CrudServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
