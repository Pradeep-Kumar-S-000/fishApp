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
  itemList!: Item[];

  constructor(private itemService: ItemService) {}
  ngOnInit(): void {
    this.getAllItems(); 
  }

  addItem(): void{
    // this.itemService.postItem(this.item).subscribe(
    //   response => {
    //     console.log('Item is saved successfully!');
    //   },
    //   error => {
    //     console.log('Error in saving item!');
    //   }
    // );
  } 

  getAllItems(): void {
    this.itemService.getAllItems().subscribe(
      response => {
        this.itemList = response;
        console.log(response);
      },
      error => {
        console.log('Error in fetching all the items');
      }
    );
  }
}
