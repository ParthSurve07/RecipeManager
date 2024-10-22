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
    private JList<String> recipeList;
    private DefaultListModel<String> recipeListModel;

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
        recipeListModel = new DefaultListModel<>();
        recipeList = new JList<>(recipeListModel);
        JScrollPane scrollPane = new JScrollPane(recipeList);

        add(addIngredientButton);
        add(createRecipeButton);
        add(generateShoppingListButton);
        add(scrollPane);

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

//package ui;
//
//import javax.swing.*;
//import java.awt.*;
//import java.util.ArrayList;
//import model.*;
//
//public class RecipeManager extends JFrame {
//    private JTextField recipeNameField;
//    private JTextArea instructionsArea;
//    private JTextField ingredientNameField;
//    private JTextField ingredientQuantityField;
//    private JTextField ingredientUnitField;
//    private JButton addIngredientButton;
//    private JButton createRecipeButton;
//    private JButton generateShoppingListButton;
//    private ShoppingList shoppingList;
//    private ArrayList<Recipe> recipes;
//    private JList<String> recipeList;
//    private DefaultListModel<String> recipeListModel;
//
//    public RecipeManager() {
//        setTitle("Recipe Manager");
//        setSize(600, 500); // Increased size for better layout
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(new GridBagLayout());
//        getContentPane().setBackground(new Color(240, 240, 240)); // Background color
//
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.insets = new Insets(10, 10, 10, 10); // Padding
//
//        // Initialize components with larger dimensions
//        recipeNameField = new JTextField(30);
//        instructionsArea = new JTextArea(8, 30);
//        ingredientNameField = new JTextField(20);
//        ingredientQuantityField = new JTextField(15);
//        ingredientUnitField = new JTextField(15);
//
//        addIngredientButton = new JButton("Add Ingredient");
//        createRecipeButton = new JButton("Create Recipe");
//        generateShoppingListButton = new JButton("Generate Shopping List");
//
//        recipeListModel = new DefaultListModel<>();
//        recipeList = new JList<>(recipeListModel);
//        JScrollPane scrollPane = new JScrollPane(recipeList);
//
//        // Set font styles
//        Font font = new Font("Arial", Font.PLAIN, 14);
//        recipeNameField.setFont(font);
//        instructionsArea.setFont(font);
//        ingredientNameField.setFont(font);
//        ingredientQuantityField.setFont(font);
//        ingredientUnitField.setFont(font);
//
//        // Set button styles
//        addIngredientButton.setBackground(new Color(100, 200, 100));
//        addIngredientButton.setForeground(Color.WHITE);
//
//        createRecipeButton.setBackground(new Color(100, 150, 250));
//        createRecipeButton.setForeground(Color.WHITE);
//
//        generateShoppingListButton.setBackground(new Color(250, 150, 100));
//        generateShoppingListButton.setForeground(Color.WHITE);
//
//        // Adding components with GridBagConstraints
//        gbc.gridx = 0; gbc.gridy = 0; add(new JLabel("Recipe Name:"), gbc);
//        gbc.gridx = 1; add(recipeNameField, gbc);
//
//        gbc.gridx = 0; gbc.gridy = 1; add(new JLabel("Instructions:"), gbc);
//        gbc.gridx = 1; add(new JScrollPane(instructionsArea), gbc);
//
//        gbc.gridx = 0; gbc.gridy = 2; add(new JLabel("Ingredient Name:"), gbc);
//        gbc.gridx = 1; add(ingredientNameField, gbc);
//
//        gbc.gridx = 0; gbc.gridy = 3; add(new JLabel("Quantity:"), gbc);
//        gbc.gridx = 1; add(ingredientQuantityField, gbc);
//
//        gbc.gridx = 0; gbc.gridy = 4; add(new JLabel("Unit:"), gbc);
//        gbc.gridx = 1; add(ingredientUnitField, gbc);
//
//        gbc.gridx = 0; gbc.gridy = 5; add(addIngredientButton, gbc);
//        gbc.gridx = 1; add(createRecipeButton, gbc);
//
//        gbc.gridx = 0; gbc.gridy = 6; add(generateShoppingListButton, gbc);
//
//        // Scroll pane for the recipe list
//        scrollPane.setBorder(BorderFactory.createTitledBorder("Recipes"));
//
//        // Add the scroll pane to the layout
//        gbc.gridwidth = 2;
//        gbc.gridx = 0;
//        gbc.gridy = 7;
//        add(scrollPane, gbc);
//
//        // Initialize shopping list and recipes
//        shoppingList = new ShoppingList();
//        recipes = new ArrayList<>();
//
//        // Add action listeners
//        addIngredientButton.addActionListener(e -> addIngredient());
//        createRecipeButton.addActionListener(e -> createRecipe());
//        generateShoppingListButton.addActionListener(e -> generateShoppingList());
//    }
//
//    private void addIngredient() {
//        String name = ingredientNameField.getText();
//        double quantity;
//        try {
//            quantity = Double.parseDouble(ingredientQuantityField.getText());
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(this, "Please enter a valid quantity.");
//            return;
//        }
//        String unit = ingredientUnitField.getText();
//
//        Ingredient ingredient = new Ingredient(name, quantity, unit);
//        if (!recipes.isEmpty()) {
//            recipes.get(recipes.size() - 1).addIngredient(ingredient);
//            JOptionPane.showMessageDialog(this, "Ingredient added to the last recipe.");
//        } else {
//            JOptionPane.showMessageDialog(this, "Please create a recipe first.");
//        }
//    }
//
//    private void createRecipe() {
//        String name = recipeNameField.getText();
//        String instructions = instructionsArea.getText();
//        Recipe recipe = new Recipe(name, instructions);
//
//        recipes.add(recipe);
//        recipeListModel.addElement(name); // Add to JList model
//        JOptionPane.showMessageDialog(this, "Recipe created successfully.");
//    }
//
//    private void generateShoppingList() {
//        shoppingList.generateFromRecipes(recipes);
//        JOptionPane.showMessageDialog(this, "Shopping list generated!");
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            RecipeManager recipeManager = new RecipeManager();
//            recipeManager.setVisible(true);
//        });
//    }
//}

