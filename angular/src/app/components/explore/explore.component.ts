import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/entities/product';
import { PushCart } from 'src/app/entities/pushcart';
import { CrudServiceService } from 'src/app/services/crud-service.service';

@Component({
  selector: 'app-explore',
  templateUrl: './explore.component.html',
  styleUrls: ['./explore.component.css']
})
export class ExploreComponent implements OnInit {


  /*********************************************************************
   *  variables for manipulation
   **********************************************************************/
  searchString:string;
  errorLog:String;
  pro:Product=new Product();
  products:Product[]=[];
  search:boolean=false;

  /*********************************************************************
   *  Test variable is used for quantity selection for a product for a 
   * range of 15
   **********************************************************************/
  test:number[]=[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15];
 data:PushCart;
 result:boolean;
 showForm:boolean=false;
 showForm2:boolean=true;
 success:boolean=false;
 Name:String;
 Manufacturer:String
 Category:String;
 Description:String;
 cost:number; 


   /*********************************************************************
   * Method: constructor
   * params:
   * return:
   * Description: constructor injects the crudService
   ************************************************************************/
  constructor(private cService:CrudServiceService) { }
  
  /*********************************************************************
   *  intitially the variables are instialised to avoid any null exception
   **********************************************************************/
  pushcart:PushCart={
  
    "productName": "Rope",
    "productManufacturer": "ABC",
    "productCategory": "CAMPING",
    "productQuantity": 1,
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

  /*********************************************************************
   * Method: show()
   * params: name,manufacturer,category description and cost of product
   * return:
   * Description: This method helps in showing a complete information of 
   *               a product.
   ************************************************************************/
  show(Name,Manufacturer,Category,Description,cost){
    this.showForm=true;
    this.showForm2=false;
    this.Name=Name;
    this.Manufacturer=Manufacturer;
    this.Category=Category;
    this.Description=Description;
    this.cost=cost;

  }

  /*********************************************************************
   * Method: Click()
   * params: name,manufacturer,category description and cost of product
   * return:
   * Description: This method will post the parameters in the cart from 
   *              product inventory.
   ************************************************************************/
  click(Name,Manufacturer,Category,Description,cost)
  {
    this.pushcart.productCategory=Category;
    this.pushcart.productDescription=Description;
    this.pushcart.productManufacturer=Manufacturer;
    this.pushcart.productName=Name;
    this.pushcart.productcost=cost;

    this.cService.pushIntoCart(this.pushcart).subscribe(data=>{
      //console.log("hello");
      this.result=data;
      this.data=data;
     },error=>{
      this.errorLog=error.error;
     });
 }
 
  /*********************************************************************
   *  this method will set the quantity for a product
   **********************************************************************/
  quanChange(value){
    console.log(value);
    this.pushcart.productQuantity=value;
  }
  
  /*********************************************************************
   *  helps in display of forms
   **********************************************************************/
  form()
  {
    this.showForm=false;
    this.showForm2=true;
  }
} 
