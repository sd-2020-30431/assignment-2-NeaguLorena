package com.assignment2.wasteless.Bussiness.Service;

import com.assignment2.wasteless.Data.Repository.GroceryListItemRepository;
import com.assignment2.wasteless.Data.Repository.GroceryListRepository;
import com.assignment2.wasteless.Presentation.Model.GroceryList;
import com.assignment2.wasteless.Presentation.Model.GroceryListItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    @Autowired
    GroceryListRepository groceryListRepository;
    @Autowired
    GroceryListItemRepository groceryListItemRepository;

    public List<GroceryListItem> getItemsAboutToExpire(String username) {
        List<GroceryListItem> itemsToExpire = new ArrayList<>();
        List<GroceryList> lists = groceryListRepository.getAllByUsername(username);
        List<GroceryListItem> items = lists
                .stream()
                .map(groceryList -> groceryListItemRepository.findAllByListId(groceryList.getListId()))
                .flatMap(List::stream)
                .collect(Collectors.toList());

        for (GroceryListItem item : items) {
            if (item.getConsumptionDate() == null && item.getExpirationDate() != null && item.getExpirationDate().after(new Date())) {
                long daysUntilExpiration = (item.getExpirationDate().getTime() - new Date().getTime()) / (1000 * 60 * 60 * 24);
                if (daysUntilExpiration == 0) {
                    itemsToExpire.add(item);
                }

            }
        }
        return itemsToExpire;
    }
}
