package arraylist;

import java.util.ArrayList;

public class GroceryList {

    private ArrayList groceryList = new ArrayList();

    public void addGroceryItem(String item) {
        groceryList.add(item);
    }

    public ArrayList getGroceryList() {
        return groceryList;
    }

    public void printGroceryList() {
        System.out.println("You have " + groceryList.size() + " items in your grocery list");
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + groceryList.get(i));
        }
    }

    public void modifyGroceryItem(String currentItem, String newItem) {
        int position = findIndexOfItem(currentItem);
        if (position >= 0) {
            groceryList.set(position, newItem);
        }
    }

    private void modifyGroceryItem(int position, String newItem) {
        groceryList.set(position, newItem);
        System.out.println("Grocery item " + (position + 1) + " has been modified.");
    }

    public void removeGroceryItem(String item) {
        int position = findIndexOfItem(item);
        if (position >= 0) {
            removeGroceryItem(position);
        }
    }

    private void removeGroceryItem(int position) {
        groceryList.remove(position);
        System.out.println("Item number " + (position + 1) + " has been removed");
    }

    private int findIndexOfItem(String searchItem) {
        return groceryList.indexOf(searchItem);
    }

    public boolean findItem(String searchItem) {
        int position = findIndexOfItem(searchItem);
        return position >= 0;
    }


}
