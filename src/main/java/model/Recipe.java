package model;

import java.util.ArrayList;

public class Recipe {
    private String recipeName;
    private ArrayList<Ingredient> ingredients;
    private String instructions;

    public Recipe(String recipeName, String instructions) {
        this.recipeName = recipeName;
        this.instructions = instructions;
        this.ingredients = new ArrayList<>();
    }

    public String getRecipeName() {
        return recipeName;
    }
    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }
    public String getInstructions() {
        return instructions;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    public void setInstructions() {
        this.instructions = instructions;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }
    public void removeIngredient(Ingredient ingredient) {
        ingredients.remove(ingredient);
    }

    public String toString() {
        return "Recipe: " + recipeName + "\nIngredients: " + ingredients.toString() + "\nInstructions: " + instructions;
    }
}
