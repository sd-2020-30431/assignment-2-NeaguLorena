package com.assignment2.wasteless.Data.Repository;

import com.assignment2.wasteless.Factory.ReportFactoryProducer;
import com.assignment2.wasteless.Presentation.Model.*;
import com.assignment2.wasteless.Presentation.Model.GroceryList;
import com.assignment2.wasteless.Presentation.Model.GroceryListItem;
import com.assignment2.wasteless.Presentation.Model.Report;
import com.assignment2.wasteless.Presentation.Model.ReportType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ReportGeneratorRepository {

    @Autowired
    private GroceryListRepository groceryListRepository;
    @Autowired
    private GroceryListItemRepository groceryListItemRepository;

    public Report getReport(ReportType reportType, String username) {

        List<GroceryList> lists = groceryListRepository.getAllByUsername(username);
        List<GroceryListItem> items = lists
                .stream()
                .map(groceryList -> groceryListItemRepository.findAllByListId(groceryList.getListId()))
                .flatMap(List::stream)
                .collect(Collectors.toList());

        return new ReportFactoryProducer().getFactory(reportType).getReport(reportType).generateReport((ArrayList<GroceryListItem>) items);
    }
}
