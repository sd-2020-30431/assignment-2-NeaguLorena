package com.assignment2.wasteless;

import com.assignment2.wasteless.Data.Repository.GoalRepository;
import com.assignment2.wasteless.Data.Repository.GroceryListItemRepository;
import com.assignment2.wasteless.Data.Repository.GroceryListRepository;
import com.assignment2.wasteless.Data.Repository.UserRepository;
import com.assignment2.wasteless.Presentation.Model.Goal;
import com.assignment2.wasteless.Presentation.Model.GroceryList;
import com.assignment2.wasteless.Presentation.Model.GroceryListItem;
import com.assignment2.wasteless.Presentation.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@EnableJpaRepositories
public class WastelessApplication {

    @Autowired
    private GroceryListRepository groceryListRepository;
    @Autowired
    private GroceryListItemRepository groceryListItemRepository;
    @Autowired
    private GoalRepository goalRepository;
    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(WastelessApplication.class, args);
    }

    @PostConstruct
    public void initDb() throws ParseException {

        User user = new User("user", "pass");
        userRepository.save(user);

        GroceryList list = new GroceryList("user", "emergency list");
        groceryListRepository.save(list);

        Date purchaseDate = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");
        Date expirationDate = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-22");
        Date consumptionDate = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");
        GroceryListItem groceryListItem = new GroceryListItem(1, "ciocolata", 10, 5, purchaseDate, expirationDate, consumptionDate);

        Date purchaseDate2 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-20");
        Date expirationDate2 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-23");
        Date consumptionDate2 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-21");
        GroceryListItem groceryListItem2 = new GroceryListItem(1, "mere", 10, 5, purchaseDate2, expirationDate2, consumptionDate2);

        Date purchaseDate3 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-04");
        Date expirationDate3 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-05");
        GroceryListItem groceryListItem3 = new GroceryListItem(1, "castraveti", 11, 3, purchaseDate3, expirationDate3, null);

        groceryListItemRepository.save(groceryListItem);
        groceryListItemRepository.save(groceryListItem2);
        groceryListItemRepository.save(groceryListItem3);

        Goal goal = new Goal("user", 11, new Date());
        goalRepository.save(goal);


    }
}
