package ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import model.*;

public class RecipeManager extends JFrame {
    private JTextField recipeNameField;
    private JTextArea instructionsArea;
    private JTextField ingredientNameField;
    private JTextField ingredientQuantityField;
    private JTextField ingredientUnitField;
    private JButton addIngredientButton;
    private JButton createRecipeButton;
    private JButton generateShoppingListButton;
    private ShoppingList shoppingList;
    private ArrayList<Recipe> recipes;

    public RecipeManager() {
        setTitle("Recipe Manager");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        recipeNameField = new JTextField(20);
        instructionsArea = new JTextArea(5, 20);
        ingredientNameField = new JTextField(15);
        ingredientQuantityField = new JTextField(10);
        ingredientUnitField = new JTextField(10);

        add(new JLabel("Recipe name:"));
        add(recipeNameField);
        add(new JLabel("Instructions:"));
        add(new JScrollPane(instructionsArea));
        add(new JLabel("Ingredient name:"));
        add(ingredientNameField);
        add(new JLabel("Quantity:"));
        add(ingredientQuantityField);
        add(new JLabel("Unit:"));
        add(ingredientUnitField);

        addIngredientButton = new JButton("Add ingredient");
        createRecipeButton = new JButton("Create recipe");
        generateShoppingListButton = new JButton("Generate shopping list");

        add(addIngredientButton);
        add(createRecipeButton);
        add(generateShoppingListButton);

        shoppingList = new ShoppingList();
        recipes = new ArrayList<>();

        addIngredientButton.addActionListener(e -> addIngredient());
        createRecipeButton.addActionListener(e -> createRecipe());
        generateShoppingListButton.addActionListener(e -> genarateShoppingList());
    }

    private void addIngredient() {
        String name = ingredientNameField.getText();
        double quantity = Double.parseDouble(ingredientQuantityField.getText());
        String unit = ingredientUnitField.getText();

        Ingredient ingredient = new Ingredient(name, quantity, unit);
        if(!recipes.isEmpty()) {
            recipes.get(recipes.size() - 1).addIngredient(ingredient);
            JOptionPane.showMessageDialog(this, "Ingredient added to the last recipe.");
        } else {
            JOptionPane.showMessageDialog(this, "Please create a recipe first.");
        }
    }

    private void createRecipe() {
        String name = recipeNameField.getText();
        String instructions = instructionsArea.getText();
        Recipe recipe = new Recipe(name, instructions);

        recipes.add(recipe);
        JOptionPane.showMessageDialog(this, "Recipe created successfully.");
    }

    private void genarateShoppingList() {
        shoppingList.generateFromRecipes(recipes);
        JOptionPane.showMessageDialog(this, "Shopping list generated!");
    }

    public static void main(String[] args) {
        RecipeManager recipeManager = new RecipeManager();
        recipeManager.setVisible(true);
    }
}