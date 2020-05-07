import { Component, OnInit } from '@angular/core';
import { CrudServiceService } from '../../services/crud-service.service';
import { Product } from '../../entities/product';


@Component({
  selector: 'app-delete-item',
  templateUrl: './delete-item.component.html',
  styleUrls: ['./delete-item.component.css']
})
export class DeleteItemComponent implements OnInit {
  products:Product[]=[];
  result:boolean;
  errorLog:String;
  constructor(private cService:CrudServiceService) { }

  deleteProduct(id:number){
    this.cService.deleteItem(id).subscribe(data=>{
      this.result=data;
      this.errorLog=undefined;
    },error=>{
      this.errorLog=error.error;
     });
  }


  ngOnInit(): void {
    this.cService.getAllProducts().subscribe(data=>{
      this.products=data;
    });
  }

}
