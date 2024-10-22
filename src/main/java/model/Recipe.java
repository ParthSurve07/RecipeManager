package model;

import java.util.ArrayList;

public class Recipe {
    private String name; // Field to store the recipe name
    private String instructions; // Field to store cooking instructions
    private ArrayList<Ingredient> ingredients; // List to hold ingredients

    public Recipe(String name, String instructions) {
        this.name = name;
        this.instructions = instructions;
        this.ingredients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getInstructions() {
        return instructions;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Recipe: " + name + "\nInstructions: " + instructions + "\nIngredients: " + ingredients.toString();
    }
}
