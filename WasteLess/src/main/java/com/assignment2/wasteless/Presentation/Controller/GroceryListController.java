package com.assignment2.wasteless.Presentation.Controller;

import com.assignment2.wasteless.Bussiness.Service.NotificationService;
import com.assignment2.wasteless.Bussiness.Service.ReminderService;
import com.assignment2.wasteless.Bussiness.Service.UserService;
import com.assignment2.wasteless.Data.Repository.GoalRepository;
import com.assignment2.wasteless.Data.Repository.GroceryListRepository;
import com.assignment2.wasteless.Presentation.Model.Goal;
import com.assignment2.wasteless.Presentation.Model.GroceryList;
import com.assignment2.wasteless.Presentation.Model.GroceryListItem;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class GroceryListController {

    private final GroceryListRepository groceryListRepository;
    private final GoalRepository goalRepository;
    private final ReminderService reminderService;
    private final NotificationService notificationService;

    public GroceryListController(GroceryListRepository groceryListRepository, GoalRepository goalRepository, ReminderService reminderService, NotificationService notificationService) {
        this.groceryListRepository = groceryListRepository;
        this.goalRepository = goalRepository;
        this.reminderService = reminderService;
        this.notificationService = notificationService;
    }

    @PostMapping("/groceryLists-user")
    public GroceryList createGroceryList(@RequestBody GroceryList groceryList) {
        String username = UserService.getLoggedUser().getUsername();
        groceryList.setUsername(UserService.getLoggedUser().getUsername());
        groceryList.setListId(groceryListRepository.getAllByUsername(username).size() + 1);
        return groceryListRepository.save(groceryList);
//        return "redirect:/groceryLists-user";
    }

    @GetMapping("/groceryLists-user")
    public List<GroceryList> getAllGroceryLists() {
//        List<Goal> goals = goalRepository.getAllByUsername(UserService.getLoggedUser().getUsername());
        List<GroceryListItem> itemsToExpire = notificationService.getItemsAboutToExpire(UserService.getLoggedUser().getUsername());
//        Goal g = goals.get(goals.size() - 1);
        String message, expirationMessage;
//        if (g != null)
//            message = reminderService.getReminder(UserService.getLoggedUser().getUsername(), g);
//        else message = "No goal set yet!";
        if (itemsToExpire.size() > 0) {
            expirationMessage = "Some items are about to expire tomorrow!";
        } else expirationMessage = "";

//        model.addAttribute("itemsToExpire", itemsToExpire);
//        model.addAttribute("expirationMessage", expirationMessage);
//        model.addAttribute("message", message);
//        model.addAttribute("goals", goals);
//        model.addAttribute("groceryLists", groceryListRepository.getAllByUsername(principal.getName()));
        return groceryListRepository.getAllByUsername(UserService.getLoggedUser().getUsername());
//        return "grocery_lists";
    }

}
