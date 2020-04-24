package com.assignment2.wasteless;

import com.assignment2.wasteless.Data.Repository.GoalRepository;
import com.assignment2.wasteless.Data.Repository.GroceryListItemRepository;
import com.assignment2.wasteless.Data.Repository.GroceryListRepository;
import com.assignment2.wasteless.Presentation.Model.*;
import com.assignment2.wasteless.Presentation.Model.Goal;
import com.assignment2.wasteless.Presentation.Model.GroceryList;
import com.assignment2.wasteless.Presentation.Model.GroceryListItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class WastelessApplicationTests {

    @Autowired
    private GroceryListRepository groceryListRepository;
    @Autowired
    private GroceryListItemRepository groceryListItemRepository;
    @Autowired
    private GoalRepository goalRepository;

    @Test
    @DisplayName("Create List Test ")
    void createListTest() {

        GroceryList created = groceryListRepository.save(getList());

        Assertions.assertTrue(created != null);
    }


    private GroceryList getList() {

        GroceryList list = new GroceryList("user", "emergency list");

        return list;
    }

    @Test
    @DisplayName("Create Item Test ")
    void createItemTest() throws ParseException {

        GroceryListItem created = groceryListItemRepository.save(getItem());

        Assertions.assertTrue(created != null);
    }


    private GroceryListItem getItem() throws ParseException {

        Date purchaseDate = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");
        Date expirationDate = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");
        Date consumptionDate = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");

        GroceryListItem groceryListItem = new GroceryListItem(1, "rosii", 10, 5, purchaseDate, expirationDate, consumptionDate);

        return groceryListItem;
    }


    @Test
    @DisplayName("Create Goal Test ")
    void createGoalTest() throws ParseException {

        Goal created = goalRepository.save(getGoal());

        Assertions.assertTrue(created != null);
    }


    private Goal getGoal() throws ParseException {

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");

        Goal goal = new Goal("user", 10, date);

        return goal;
    }

}
