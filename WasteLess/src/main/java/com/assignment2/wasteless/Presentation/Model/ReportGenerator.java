package com.assignment2.wasteless.Presentation.Model;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Date;

public abstract class ReportGenerator {

    public abstract Report generateReport(ArrayList<GroceryListItem> groceryListItems);

    public ArrayList<GroceryListItem> getGroceryItemsPurchasedLastDays(ArrayList<GroceryListItem> groceryListItems, int nbDays) {
        ArrayList<GroceryListItem> itemsPurchased = new ArrayList<>();
        Date date = new Date();
        Date daysAgo = new DateTime(date).minusDays(nbDays).toDate();

        for (GroceryListItem item : groceryListItems) {
            if (item.getPurchaseDate().after(daysAgo)) {
                itemsPurchased.add(item);
            }
        }
        return itemsPurchased;
    }

    public Report createReport(ArrayList<GroceryListItem> groceryListItems) {
        ArrayList<GroceryListItem> consumed = new ArrayList<>();
        ArrayList<GroceryListItem> wasted = new ArrayList<>();
        int calories = 0;
        int caloriesWasted = 0;
        Date date = new Date();

        for (GroceryListItem item : groceryListItems) {
            if (item.getExpirationDate().before(date) && item.getConsumptionDate() == null) {
                wasted.add(item);
                caloriesWasted += item.getCalorieValue();
            } else if (item.getConsumptionDate() != null) {
                consumed.add(item);
                calories += item.getCalorieValue();
            }
        }
        return new Report(groceryListItems.size(), calories, caloriesWasted, wasted.size(), groceryListItems, consumed, wasted);
    }
}
