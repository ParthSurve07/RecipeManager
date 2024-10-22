package ui;

import model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Recipe> recipes = new ArrayList<>();
    private static ShoppingList shoppingList = new ShoppingList();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Recipe Manager ---");
            System.out.println("1. Create Recipe");
            System.out.println("2. Add Ingredient to Last Recipe");
            System.out.println("3. Generate Shopping List");
            System.out.println("4. View Recipes");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createRecipe();
                    break;
                case 2:
                    addIngredientToLastRecipe();
                    break;
                case 3:
                    generateShoppingList();
                    break;
                case 4:
                    viewRecipes();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createRecipe() {
        System.out.print("Enter recipe name: ");
        String name = scanner.nextLine();
        System.out.print("Enter instructions: ");
        String instructions = scanner.nextLine();

        Recipe recipe = new Recipe(name, instructions);
        recipes.add(recipe);
        System.out.println("Recipe created successfully!");
    }

    private static void addIngredientToLastRecipe() {
        if (recipes.isEmpty()) {
            System.out.println("No recipes available. Please create a recipe first.");
            return;
        }

        Recipe lastRecipe = recipes.get(recipes.size() - 1);
        System.out.print("Enter ingredient name: ");
        String ingredientName = scanner.nextLine();
        System.out.print("Enter quantity: ");
        double quantity = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter unit: ");
        String unit = scanner.nextLine();

        Ingredient ingredient = new Ingredient(ingredientName, quantity, unit);
        lastRecipe.addIngredient(ingredient);
        System.out.println("Ingredient added to " + lastRecipe.getName() + ".");
    }

    private static void generateShoppingList() {
        shoppingList.generateFromRecipes(recipes);
        System.out.println(shoppingList.toString());
    }

    private static void viewRecipes() {
        if (recipes.isEmpty()) {
            System.out.println("No recipes available.");
            return;
        }

        for (Recipe recipe : recipes) {
            System.out.println(recipe.toString());
        }
    }
}
