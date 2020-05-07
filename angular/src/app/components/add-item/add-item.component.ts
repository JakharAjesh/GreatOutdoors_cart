import { Component, OnInit } from '@angular/core';
import { Product } from '../../entities/product';
import { Router } from '../../../../node_modules/@angular/router';
import { CrudServiceService } from '../../services/crud-service.service';

@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css']
})
export class AddItemComponent implements OnInit {
 product:Product=new Product();
 result:number;
 errorLog:string;

 success:boolean=false;
 name:string;
 Category:string[]=["GOLF","MOUNTAINEERING","CAMPING","INDOOR","ATHLETE","FOOTBALL"];
  constructor(private router:Router,private cService:CrudServiceService) { }

  sendProduct(){
 if(this.product.productCategory=="" || this.product.productcost==null || this.product.productDescription=="" || this.product.productManufacturer=="" || this.product.productQuantity==null || this.product.productName=="")
    { 
      
    }else{
      this.cService.addProduct(this.product).subscribe(data=>{
        this.result=data;
        this.errorLog=undefined;
        this.success=true;
      },
      error=>{
      this.errorLog=error.error;
      });
    
    //console.log(name);
    }
  }


  consoleLog(fname){
    console.log(fname) ;
  }

  ngOnInit(): void {
  }

  changeCat(value){
    this.product.productCategory=value;
  }

}
