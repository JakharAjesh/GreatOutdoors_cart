import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/entities/product';
import { PushCart } from 'src/app/entities/pushcart';
import { CrudServiceService } from 'src/app/services/crud-service.service';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  searchString:string;
  errorLog:String;
  products:Product[]=[];
  search:boolean=false;
  test:number[]=[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15];
 data:PushCart;
 result:boolean;
//Message wil be shown from backend
  constructor(private cService:CrudServiceService) { }
  pushcart:PushCart={
  
    "productName": "Rope",
    "productManufacturer": "ABC",
    "productCategory": "CAMPING",
    "productQuantity": 3,
    "productDescription": "This rope is specially designed for weight upto 500kg",
    "productcost": 100.0,
  };
  ngOnInit(): void {
    
    this.cService.getAllProducts().subscribe(data=>{
      this.products=data;
      this.errorLog=undefined;
    },
    error=>{
     this.errorLog=error.error;
    });

    console.log(this.products.length);

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
  searchProduct(){
    this.search=true;
    this.cService.searchProduct(this.searchString).subscribe(data=>{
     this.products=data;
     this.errorLog=undefined;
    },
   error=>{
    this.errorLog=error.error;
    this.products=[];
   });

   console.log(this.products.length);

  }
  quanChange(value){
    console.log(value);
    this.pushcart.productQuantity=value;
  }

  log(x){
    console.log(x);
  }

}

