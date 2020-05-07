import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from '../../../node_modules/rxjs';
import { Product } from '../entities/product';
import { PushCart } from '../entities/pushcart';
import { GetCart } from '../entities/getcart';

@Injectable({
  providedIn: 'root'
})
export class CrudServiceService {

  constructor(private http:HttpClient) { }


  getAllProducts():Observable<any>{
    return this.http.get("http://localhost:9000/dashboard/Products");

  }

  addProduct(product:Product):Observable<any>{
    return this.http.post("http://localhost:9000/dashboard/addProduct",product,{responseType:"text"});

  }

  deleteItem(id:number):Observable<any>{
    return this.http.delete(`http://localhost:9000/dashboard/deleteProduct/${id}`);
  }

  searchProduct(search:string):Observable<any>{

    return this.http.get(`http://localhost:9000/dashboard/searchProducts/${search}`);
  }

  pushIntoCart(pushcart:PushCart):Observable<any>{
    console.log(pushcart);
    return this.http.post(`http://localhost:9000/carts`,pushcart);
  }

  updateProduct(product:Product):Observable<any>{
    console.log(product);
    return this.http.put("http://localhost:9000/dashboard/editProduct",product,{responseType:"text"});
  }
  getCartProducts():Observable<any>{
    return this.http.get("http://localhost:9000/carts");
  }
  updateCartProduct(getcart:GetCart):Observable<any>{
    
    return this.http.put("http://localhost:9000/carts",getcart,{responseType:"text"});
  }
  deleteCartProduct(id:number):Observable<any>{
    return this.http.delete(`http://localhost:9000/carts/`+id);
  }



}
