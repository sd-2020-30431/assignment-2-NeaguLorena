import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {Grocerylist} from "../../model/grocerylist";
import {GrocerylistService} from "../../service/grocerylist.service";

@Component({
  selector: 'app-grocerylist',
  templateUrl: './grocerylist.component.html',
  styleUrls: ['./grocerylist.component.css']
})
export class GrocerylistComponent implements OnInit {

  grocerylists : Grocerylist[];
  grocerylist : Grocerylist;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private grocerylistService : GrocerylistService) {
    this.grocerylist = new Grocerylist();
  }

  ngOnInit() {
    this.grocerylistService.findAll().subscribe(data => {
      this.grocerylists = data;
    })
  }

  onSubmit() {
    this.grocerylistService.save(this.grocerylist).subscribe(result => this.grocerylists.push(result));
  }
}
