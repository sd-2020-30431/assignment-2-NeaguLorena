package com.assignment2.wasteless.Data.Repository;

import com.assignment2.wasteless.Presentation.Model.GroceryList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroceryListRepository extends JpaRepository<GroceryList, Integer> {
    List<GroceryList> getAllByUsername(String username);
}
