package com.assignment2.wasteless.Presentation.Model;

import java.util.ArrayList;

public class Report {

    private int nbOfItemsPurchased;
    private int nbOfCaloriesConsumed;
    private int nbOfItemsExpired;
    private int caloriesWasted;
    private ArrayList<GroceryListItem> purchased;
    private ArrayList<GroceryListItem> consumed;
    private ArrayList<GroceryListItem> wasted;

    public Report(int nbOfItemsPurchased, int nbOfCaloriesConsumed, int nbOfItemsExpired, int caloriesWasted, ArrayList<GroceryListItem> purchased, ArrayList<GroceryListItem> consumed, ArrayList<GroceryListItem> wasted) {
        this.nbOfItemsPurchased = nbOfItemsPurchased;
        this.nbOfCaloriesConsumed = nbOfCaloriesConsumed;
        this.nbOfItemsExpired = nbOfItemsExpired;
        this.caloriesWasted = caloriesWasted;
        this.purchased = purchased;
        this.consumed = consumed;
        this.wasted = wasted;
    }

    public int getCaloriesWasted() {
        return caloriesWasted;
    }

    public void setCaloriesWasted(int caloriesWasted) {
        this.caloriesWasted = caloriesWasted;
    }

    public int getNbOfItemsPurchased() {
        return nbOfItemsPurchased;
    }

    public void setNbOfItemsPurchased(int nbOfItemsPurchased) {
        this.nbOfItemsPurchased = nbOfItemsPurchased;
    }

    public int getNbOfCaloriesConsumed() {
        return nbOfCaloriesConsumed;
    }

    public void setNbOfCaloriesConsumed(int nbOfCaloriesConsumed) {
        this.nbOfCaloriesConsumed = nbOfCaloriesConsumed;
    }

    public int getNbOfItemsExpired() {
        return nbOfItemsExpired;
    }

    public void setNbOfItemsExpired(int nbOfItemsExpired) {
        this.nbOfItemsExpired = nbOfItemsExpired;
    }

    public ArrayList<GroceryListItem> getPurchased() {
        return purchased;
    }

    public void setPurchased(ArrayList<GroceryListItem> purchased) {
        this.purchased = purchased;
    }

    public ArrayList<GroceryListItem> getConsumed() {
        return consumed;
    }

    public void setConsumed(ArrayList<GroceryListItem> consumed) {
        this.consumed = consumed;
    }

    public ArrayList<GroceryListItem> getWasted() {
        return wasted;
    }

    public void setWasted(ArrayList<GroceryListItem> wasted) {
        this.wasted = wasted;
    }

    @Override
    public String toString() {
        return "Report{" +
                "nbOfItemsPurchased=" + nbOfItemsPurchased +
                ", nbOfCaloriesConsumed=" + nbOfCaloriesConsumed +
                ", nbOfItemsExpired=" + nbOfItemsExpired +
                ", caloriesWasted=" + caloriesWasted +
                ", purchased=" + purchased +
                ", consumed=" + consumed +
                ", wasted=" + wasted +
                '}';
    }
}
