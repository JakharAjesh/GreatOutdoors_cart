import { Component, OnInit } from '@angular/core';
import { CrudServiceService } from '../../services/crud-service.service';
import { Product } from '../../entities/product';

@Component({
  selector: 'app-show-items',
  templateUrl: './show-items.component.html',
  styleUrls: ['./show-items.component.css']
})
export class ShowItemsComponent implements OnInit {
  pro:Product=new Product();
  products:Product[]=[];
  result:number;
  
  errorLog:String;
  showForm:boolean=false;
  success:boolean=false;
  Category:string[]=["GOLF","MOUNTAINEERING","CAMPING","INDOOR","ATHLETE","FOOTBALL"];

  constructor(private cService:CrudServiceService) {

   }



  ngOnInit(): void {
      this.cService.getAllProducts().subscribe(data=>{
        this.products=data;
        this.errorLog=undefined;
      },
      error=>{
       this.errorLog=error.error;
      });
   
   
  }

  sendProduct(){

    if(this.pro.productCategory=="" || this.pro.productcost==null || this.pro.productDescription=="" || this.pro.productManufacturer=="" || this.pro.productQuantity==null || this.pro.productName=="")
    { 
     
    }else{
      this.cService.updateProduct(this.pro).subscribe(data=>{
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


  changeCat(value){
    this.pro.productCategory=value;
  } 

  displayForm(i){
    this.showForm=true;
    //console.log(i);
    this.pro.productid=i;
  }

}
