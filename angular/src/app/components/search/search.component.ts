import { Component, OnInit } from '@angular/core';
import { CrudServiceService } from '../../services/crud-service.service';
import { Product } from '../../entities/product';
import { PushCart } from 'src/app/entities/pushcart';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
 searchString:string;
 
 errorLog:String;
 products:Product[]=[];

 pushcart:PushCart={
  
  "productName": "Rope",
  "productManufacturer": "ABC",
  "productCategory": "CAMPING",
  "productQuantity": 3,
  "productDescription": "This rope is specially designed for weight upto 500kg",
  "productcost": 100.0,
};

 test:number[]=[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15];
 data:PushCart;
 result:boolean;
  constructor(private cService:CrudServiceService) { }

  ngOnInit(): void {
  }
  click(Name,Manufacturer,Category,Description,cost)
  {
    this.pushcart.productCategory=Category;
    this.pushcart.productDescription=Description;
    this.pushcart.productManufacturer=Manufacturer;
    this.pushcart.productName=Name;
    this.pushcart.productcost=cost;

    this.cService.pushIntoCart(this.pushcart).subscribe(data=>{
      this.result=data;
      this.data=data;
     },error=>{
      this.errorLog=error.error;
     });
 }
  quanChange(value){
    console.log(value);
    this.pushcart.productQuantity=value;
  }
  searchProduct(){
   this.cService.searchProduct(this.searchString).subscribe(data=>{
    this.products=data;
    this.errorLog=undefined;
   },
  error=>{
   this.errorLog=error.error;
   this.products=[];
  });

   console.log(this.products);
  }

  log(x){
    console.log(x);
  }
}
