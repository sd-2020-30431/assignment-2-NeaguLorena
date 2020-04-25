import {Grocerylistitem} from "./grocerylistitem";

export class Report {
  nbOfItemsPurchased: number;
  nbOfCaloriesConsumed: number;
  nbOfItemsExpired: number;
  caloriesWasted: number;
  purchased: Grocerylistitem[];
  consumed: Grocerylistitem[];
  wasted: Grocerylistitem[];
}
