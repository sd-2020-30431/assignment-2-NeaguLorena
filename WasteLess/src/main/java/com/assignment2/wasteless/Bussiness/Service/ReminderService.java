package com.assignment2.wasteless.Bussiness.Service;

import com.assignment2.wasteless.Data.Repository.GroceryListItemRepository;
import com.assignment2.wasteless.Data.Repository.GroceryListRepository;
import com.assignment2.wasteless.Presentation.Model.*;
import com.assignment2.wasteless.Presentation.Model.Goal;
import com.assignment2.wasteless.Presentation.Model.GroceryList;
import com.assignment2.wasteless.Presentation.Model.GroceryListItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReminderService {

    @Autowired
    private GroceryListRepository groceryListRepository;
    @Autowired
    private GroceryListItemRepository groceryListItemRepository;

    public String getReminder(String username, Goal goal) {
        int sum_goals = 0;
        long daysUntilExpiration;
        List<GroceryList> lists = groceryListRepository.getAllByUsername(username);
        List<GroceryListItem> items = lists
                .stream()
                .map(groceryList -> groceryListItemRepository.findAllByListId(groceryList.getListId()))
                .flatMap(List::stream)
                .collect(Collectors.toList());

        for (GroceryListItem item : items) {
            if (item.getExpirationDate() != null && item.getExpirationDate().before(new Date())) {
                daysUntilExpiration = 1;
            } else {
                daysUntilExpiration = (item.getExpirationDate().getTime() - new Date().getTime()) / (1000 * 60 * 60 * 24);
            }
            if (daysUntilExpiration == 0)
                daysUntilExpiration = 1;
            sum_goals += item.getCalorieValue() / daysUntilExpiration;
        }
        if (sum_goals > goal.getNumberOfCaloriesADay()) {
            return "Waste levels are too high!";
        } else {
            return "Goal reached!";
        }
    }


}
