package com.assignment2.wasteless.Presentation.Model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.Date;

@Entity(name = "ITEM")
public class GroceryListItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int itemId;
    private int listId;
    private String name;
    @NotNull
    private int quantity;
    @NotNull
    private int calorieValue;
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date purchaseDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expirationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date consumptionDate;

    public GroceryListItem() {
    }

    public GroceryListItem(int listId, String name, int quantity, int calorieValue, Date purchaseDate, Date expirationDate, Date consumptionDate) {
        this.listId = listId;
        this.name = name;
        this.quantity = quantity;
        this.calorieValue = calorieValue;
        this.purchaseDate = purchaseDate;
        this.expirationDate = expirationDate;
        this.consumptionDate = consumptionDate;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCalorieValue() {
        return calorieValue;
    }

    public void setCalorieValue(int calorieValue) {
        this.calorieValue = calorieValue;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getConsumptionDate() {
        return consumptionDate;
    }

    public void setConsumptionDate(Date consumptionDate) {
        this.consumptionDate = consumptionDate;
    }

    @Override
    public String toString() {
        return "GroceryListItem{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", calorieValue=" + calorieValue +
                ", purchaseDate=" + purchaseDate +
                ", expirationDate=" + expirationDate +
                ", consumptionDate=" + consumptionDate +
                '}';
    }
}
