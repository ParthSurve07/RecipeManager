package model;

import java.util.ArrayList;

public class ShoppingList {
    private ArrayList<Ingredient> shoppingItems;

    public ShoppingList() {
        this.shoppingItems = new ArrayList<>();
    }

    public ArrayList<Ingredient> getShoppingItems() {
        return shoppingItems;
    }

    public void setShoppingItems(ArrayList<Ingredient> shoppingItems) {
        this.shoppingItems = shoppingItems;
    }

    public void addToShoppingList(Ingredient ingredient) {
        shoppingItems.add(ingredient);
    }
    public void removeFromShoppingList(Ingredient ingredient) {
        shoppingItems.remove(ingredient);
    }

    public String toString() {
        return "Shopping List: " + shoppingItems.toString();
    }
}
