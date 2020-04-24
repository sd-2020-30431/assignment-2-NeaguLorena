package com.assignment2.wasteless.Presentation.Model;

import java.util.ArrayList;

public class MonthlyReport extends ReportGenerator{

    @Override
    public Report generateReport(ArrayList<GroceryListItem> groceryListItems) {
        return createReport(getGroceryItemsPurchasedLastDays(groceryListItems, 31));
    }
}
