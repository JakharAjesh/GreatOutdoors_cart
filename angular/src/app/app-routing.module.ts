import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddItemComponent } from './components/add-item/add-item.component';
import { DeleteItemComponent } from './components/delete-item/delete-item.component';
import { ShowItemsComponent } from './components/show-items/show-items.component';
import { SearchComponent } from './components/search/search.component';
import { ErrorComponentComponent } from './components/error-component/error-component.component';
import { CartComponent } from './components/cart/cart.component';
import { SearchbarComponent } from './components/searchbar/searchbar.component';
import { ExploreComponent } from './components/explore/explore.component';






const routes: Routes = [
  { path: '', component: ShowItemsComponent },
  
  { path: 'addItem', component: AddItemComponent },
  { path: 'deleteItem', component: DeleteItemComponent },
  { path: 'searchProduct', component: SearchComponent },

  { path: 'showcart', component: CartComponent },
  { path: 'searchbar', component: SearchbarComponent },
  { path: 'explore', component: ExploreComponent },
  

  { path: '**', component: ErrorComponentComponent }
  
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
