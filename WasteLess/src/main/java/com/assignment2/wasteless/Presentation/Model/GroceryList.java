package com.assignment2.wasteless.Presentation.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity(name = "LIST")
public class GroceryList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int listId;
    private String username;
    @NotEmpty
    private String listName;

    public GroceryList() {
    }

    public GroceryList(String username, String listName) {
        this.username = username;
        this.listName = listName;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    @Override
    public String toString() {
        return "GroceryList{" +
                "listId=" + listId +
                ", userId=" + username +
                ", listName='" + listName + '\'' +
                '}';
    }
}
