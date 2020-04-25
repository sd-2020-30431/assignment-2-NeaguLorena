import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Grocerylist} from "../../model/grocerylist";
import {GrocerylistService} from "../../service/grocerylist.service";
import {Goal} from "../../model/goal";
import {GoalService} from "../../service/goal.service";
import {Grocerylistitem} from "../../model/grocerylistitem";
import {NotificationService} from "../../service/notification.service";

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
  reminder: String;
  itemsToExpire: Grocerylistitem[];
  notification: String;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private grocerylistService: GrocerylistService,
              private goalService: GoalService,
              private notificationService: NotificationService) {
    this.grocerylist = new Grocerylist();
    this.goal = new Goal();
    this.reminder = "";
    this.notification = "";
  }

  ngOnInit() {
    this.grocerylistService.findAll().subscribe(data => {
      this.grocerylists = data;
    });
    this.goalService.findAll().subscribe(data => {
      this.goals = data;
    });
    this.goalService.getReminder().subscribe(data => {
      this.reminder = data
    });
    this.getReminderForWasteLevels();
    this.notificationService.getExpirationNotification().subscribe(data => {
      this.notification = data;
    });
    this.getNotificationForItemExpiration();
    this.notificationService.getItemsAboutToExpire().subscribe(data => {
      this.itemsToExpire = data;
    })
  }

  onSubmit() {
    this.grocerylistService.save(this.grocerylist).subscribe(result => this.grocerylists.push(result));
  }

  submitGoal() {
    this.goalService.save(this.goal).subscribe(result => this.goals.push(result));
    this.getReminderForWasteLevels();
  }

  getReminderForWasteLevels() {
    this.goalService.getReminder().subscribe(result => this.reminder = result);
  }

  getNotificationForItemExpiration() {
    this.notificationService.getExpirationNotification().subscribe(result => this.notification = result);
  }

}
