import {Component, OnInit} from '@angular/core';
import {Grocerylistitem} from "../../model/grocerylistitem";
import {GrocerylistitemService} from "../../service/grocerylistitem.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-grocerylistitem',
  templateUrl: './grocerylistitem.component.html',
  styleUrls: ['./grocerylistitem.component.css']
})
export class GrocerylistitemComponent implements OnInit {

  items: Grocerylistitem[];
  item: Grocerylistitem = {} as Grocerylistitem;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private itemService: GrocerylistitemService) {
  }

  ngOnInit() {
    this.itemService.findAllByListId(this.route.snapshot.paramMap.get("listId")).subscribe(data => {
      this.items = data;
    })
  }

  onSubmit() {
    this.itemService.save(this.item, this.route.snapshot.paramMap.get("listId")).subscribe(result => this.items.push(result));
  }

  deleteGroceryListItem(itemId: number) {
    this.items = this.items.filter(item => item.itemId !== itemId);
    this.itemService.deleteItem(itemId).subscribe();
  }

  updateGroceryListItem(item: Grocerylistitem) {
    this.items = this.items.filter(i => i.itemId !== item.itemId);
    this.itemService.consumeItem(item).subscribe(result => this.items.push(result));
  }
}
