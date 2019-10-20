package linkedlist;

import java.util.*;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<>();

        placesToVisit.add("Sydney");
        placesToVisit.add("Melbourne");
        placesToVisit.add("Brisbane");
        placesToVisit.add("Perth");
        placesToVisit.add("Canberra");
        placesToVisit.add("Adelaide");
        placesToVisit.add("Darwin");

        addInOrder(placesToVisit, "Alice Springs");
//        Collections.sort(placesToVisit);
        addInOrder(placesToVisit, "Darwin");
        addInOrder(placesToVisit, "Adelaide");
        //Now list accepts city names that are included from the beginning. It has Darwin twice.
//        To deal with this issue. We should do the sort().
        printList(placesToVisit);

        visit(placesToVisit);
    }

    private static void printList(LinkedList<String> list) {
        Iterator<String> i = list.iterator();
        while (i.hasNext()) {
            System.out.println("Now visiting " + i.next());
        }
        System.out.println("==============================");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
//        Collections.sort(linkedList);
        ListIterator<String> stringListIterator = linkedList.listIterator();
        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);
            if (comparison == 0) {
                //are equal, do not add
                System.out.println(newCity + " is already included as a destination");
                return false;
            } else if (comparison > 0) {
                // new City should appear befor this one
                //Brisbane -> Adelaide
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            } else if (comparison < 0) {
                //move on next city
            }
        }

        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList<String> places) {
        Scanner scanner = new Scanner(System.in);

        boolean quit = false;
        boolean goingForward = true;

        ListIterator<String> listIterator = places.listIterator();

        if (places.isEmpty()) {
            System.out.println("No cities in the itinerary.");
            return;
        } else {
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }


    }


    private static void printMenu() {
        System.out.println("Available options: \npress");
        System.out.println("0 - to quit\n" +
                "1 - to go to next city\n" +
                "2 - to go to previous city\n" +
                "3 - to print menu\n");
    }

}
