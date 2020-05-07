import { Component, OnInit } from '@angular/core';
import { CrudServiceService } from 'src/app/services/crud-service.service';
import { GetCart } from 'src/app/entities/getcart';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

   /*********************************************************************
   *  Instance of GetCart for manupulation
   **********************************************************************/
  getcart:GetCart[];

   /*********************************************************************
   *  Boolean variables  for form manupulation
   **********************************************************************/
  result:boolean=false;
  showForm:boolean=false;
  errorLog:String;
  Id:number;

  test:number[]=[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15];

   /*********************************************************************
   * Method: constructor
   * params:
   * return:
   * Description: constructor injects the CrudService
   
   ************************************************************************/
  constructor(private cService:CrudServiceService) { }

  ngOnInit(): void {
    this.cService.getCartProducts().subscribe(data=>{
      this.getcart=data;
    });
  }

   /*********************************************************************
   * Method: deleteProduct
   * params: Product ID
   * return:
   * Description: this method call deleteCartProduct() in Service class 
   *               and deletes the particular product on the basis of 
   *               their unique id's
   ************************************************************************/
  deleteProduct(id:number){
    
    this.result=true;
    this.showForm=false;
    this.cService.deleteCartProduct(id).subscribe(data=>{
      
      
      this.errorLog=undefined;
    },error=>{
      this.errorLog=error.error;
     });
  }

  form(id:number)
  {
    this.showForm=true;
    this.Id=id;
  }
   /*********************************************************************
   * Method: getTotalPrice
   * params:
   * return: total of cart
   * Description: this method will calculate the total price of cart products 
   ************************************************************************/
  getTotalPrice(): number {
    var total = 0;
    if (this.getcart != null && this.getcart.length > 0) {      
      this.getcart.forEach(x => total += x.productcost*x.productQuantity);
    }
    
    return total;
  }  

}
