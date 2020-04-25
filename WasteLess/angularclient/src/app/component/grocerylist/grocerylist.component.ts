import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Grocerylist} from "../../model/grocerylist";
import {GrocerylistService} from "../../service/grocerylist.service";
import {Goal} from "../../model/goal";
import {GoalService} from "../../service/goal.service";

@Component({
  selector: 'app-grocerylist',
  templateUrl: './grocerylist.component.html',
  styleUrls: ['./grocerylist.component.css']
})
export class GrocerylistComponent implements OnInit {

  grocerylists: Grocerylist[];
  grocerylist: Grocerylist;
  goals: Goal[];
  goal: Goal;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private grocerylistService: GrocerylistService,
              private goalService : GoalService) {
    this.grocerylist = new Grocerylist();
    this.goal = new Goal();
  }

  ngOnInit() {
    this.grocerylistService.findAll().subscribe(data => {
      this.grocerylists = data;
    });
    this.goalService.findAll().subscribe(data => {
      this.goals = data;
    });
  }

  onSubmit() {
    this.grocerylistService.save(this.grocerylist).subscribe(result => this.grocerylists.push(result));
  }

  submitGoal(){
    this.goalService.save(this.goal).subscribe(result => this.goals.push(result));
  }
}
