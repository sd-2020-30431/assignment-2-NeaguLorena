package com.assignment2.wasteless.Presentation.Controller;

import com.assignment2.wasteless.Bussiness.Service.NotificationService;
import com.assignment2.wasteless.Bussiness.Service.ReminderService;
import com.assignment2.wasteless.Bussiness.Service.UserService;
import com.assignment2.wasteless.Data.Repository.GoalRepository;
import com.assignment2.wasteless.Data.Repository.GroceryListRepository;
import com.assignment2.wasteless.Presentation.Model.*;
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
//        List<GroceryListItem> itemsToExpire = notificationService.getItemsAboutToExpire(UserService.getLoggedUser().getUsername());
//        if (itemsToExpire.size() > 0) {
//            expirationMessage = "Some items are about to expire tomorrow!";
//        } else expirationMessage = "";
        return groceryListRepository.getAllByUsername(UserService.getLoggedUser().getUsername());
    }

    @GetMapping("/itemsToExpire")
    public List<GroceryListItem> getItemsAboutToExpire() {
        return notificationService.getItemsAboutToExpire(UserService.getLoggedUser().getUsername());
    }

    @GetMapping("/notificationMessage")
    public String getExpirationNotification() {
        String expirationMessage;
        List<GroceryListItem> itemsToExpire = notificationService.getItemsAboutToExpire(UserService.getLoggedUser().getUsername());

        Notification notification = new Notification();
        NotificationObserver notificationObserver = new NotificationObserver();

        notification.addPropertyChangeListener(notificationObserver);
        if (itemsToExpire.size() > 0) {
            expirationMessage = "Some items are about to expire tomorrow!";
        } else expirationMessage = "";
        notification.setExpirationMessage(expirationMessage);

        return notificationObserver.getExpirationMessage();
    }
}
