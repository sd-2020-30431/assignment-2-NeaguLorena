package com.assignment2.wasteless.Presentation.Controller;

import com.assignment2.wasteless.Data.Repository.GroceryListItemRepository;
import com.assignment2.wasteless.Presentation.Model.GroceryListItem;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
public class GroceryListItemController {

    private final GroceryListItemRepository groceryListItemRepository;

    public GroceryListItemController(GroceryListItemRepository groceryListItemRepository) {
        this.groceryListItemRepository = groceryListItemRepository;
    }

    @PostMapping("/groceryLists-user/{listId}")
    public GroceryListItem createGroceryListItem(@RequestBody GroceryListItem groceryListItem, @PathVariable int listId) {
        if (groceryListItem.getName() != null && groceryListItem.getExpirationDate() != null) {
            groceryListItem.setListId(listId);
            return groceryListItemRepository.save(groceryListItem);
        }
        return null;
    }

    @GetMapping("/groceryLists-user/{listId}")
    public List<GroceryListItem> getAllGroceryListItemsByListId(@PathVariable int listId) {
        return groceryListItemRepository.findAllByListId(listId);
    }

    @RequestMapping("/groceryItem-list/delete/{listId}/{itemId}")
    public void deleteGroceryListItem(@PathVariable int itemId, @PathVariable int listId) {
        groceryListItemRepository.deleteById(itemId);
    }

    @RequestMapping("/groceryItem-list/consume/{listId}/{itemId}")
    public GroceryListItem consumeGroceryListItem(@PathVariable int itemId, @PathVariable int listId) {
        GroceryListItem oldGroceryListItem = groceryListItemRepository.findItemByItemId(itemId);
        oldGroceryListItem.setConsumptionDate(new Date());
        return groceryListItemRepository.save(oldGroceryListItem);
    }
}
