package arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListMain {

    public static Scanner scanner = new Scanner(System.in);
    public static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {
        boolean quit = true;
        int choice = 0;
        printInstructions();
        while (quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    processArrayList();
                    break;
                case 7:
                    quit = false;
                    break;
            }
        }
    }

    private static void processArrayList() {
        ArrayList nexArrayList = new ArrayList(groceryList.getGroceryList());
    }

    private static void printInstructions() {
        System.out.println("\n Press: ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list  of grocery items.");
        System.out.println("\t 2 - To add an item to the list.");
        System.out.println("\t 3 - To modify an item in the list.");
        System.out.println("\t 4 - To remove an item from the list.");
        System.out.println("\t 5 - To search for an item in the list.");
        System.out.println("\t 6 - To quit the application.");
    }

    private static void addItem() {
        System.out.println("Please enter the grocery item: ");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    private static void modifyItem() {
        System.out.println("Please enter current item name: ");
        String currentItem = scanner.nextLine();
        System.out.println("Enter new item");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(currentItem, newItem);
    }

    public static void removeItem() {
        System.out.println("Enter item name you want to remove: ");
        String itemToDelete = scanner.nextLine();
        groceryList.removeGroceryItem(itemToDelete);
    }

    private static void searchForItem() {
        System.out.println("Enter item to search for: ");
        String searchItem = scanner.nextLine();
        if (groceryList.findItem(searchItem)) {
            System.out.println("Found " + searchItem + " in our grocery list.");
        } else {
            System.out.println(searchItem + " can not be found.");
        }
    }
}

