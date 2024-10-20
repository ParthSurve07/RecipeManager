package ui;

import model.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Ingredient flour = new Ingredient("Flour", 200, "grams");
        Ingredient sugar = new Ingredient("Sugar", 100, "grams");
        Ingredient milk = new Ingredient("Milk", 500, "ml");

        Recipe pancakeRecipe = new Recipe("Pancake", "Mix all ingredients and cook on a hot griddle.");
        pancakeRecipe.addIngredient(flour);
        pancakeRecipe.addIngredient(sugar);
        pancakeRecipe.addIngredient(milk);

        System.out.println(pancakeRecipe.toString());

        ShoppingList shoppingList = new ShoppingList();

        ArrayList<Recipe> recipes = new ArrayList<>();
        recipes.add(pancakeRecipe);

        shoppingList.generateFromRecipes(recipes);

        System.out.println(shoppingList.toString());
    }
}
