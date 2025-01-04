import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ItemService } from '../../services/item-service';
import { Item } from '../../entities/item';

@Component({
  selector: 'fishApp-item',
  imports: [CommonModule],
  templateUrl: './item.component.html',
  styleUrl: './item.component.scss'
})
export class ItemComponent implements OnInit{
  item : Item = {
    itemName: 'fish1',
    stockAvailable: 30,
    listPrice: 200,
    discount: 0.2
  }

  displayItemName!: string;
  displayStockAvailable!: number;
  displayListPrice!: number;
  displayDiscount!: number;

  itemList!: Item[];

  constructor(private itemService: ItemService) {}
  ngOnInit() : void {
    this.displayItemName = this.item.itemName;
    this.displayStockAvailable = this.item.stockAvailable;
    this.displayListPrice = this.item.listPrice;
    this.displayDiscount = this.item.discount;
    
  }
  addItem() : void{
    this.itemService.postItem(this.item).subscribe(
      response => {
        console.log('Item is saved successfully!');
      },
      error => {
        console.log('Error in saving item!');
      }
    );
  } 
}
