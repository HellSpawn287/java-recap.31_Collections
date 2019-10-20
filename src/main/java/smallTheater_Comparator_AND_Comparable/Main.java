package smallTheater_Comparator_AND_Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
//    public static void main(String[] args) {
//        smallTheater_Comparator_AND_Comparable.Theater theater = new smallTheater_Comparator_AND_Comparable.Theater("Olimpian", 8, 12);
//////       Binary Search
//////        theater.getSeats();
////        if (theater.reserveSeat("H11")){
////            System.out.println("Please pay");
////        } else {
////            System.out.println("Sorry, this seat is taken");
////        }
//
//        List<smallTheater_Comparator_AND_Comparable.Theater.Seat> seatsCopy = new ArrayList<>(theater.seats);
//        printList(seatsCopy);
//
//        seatsCopy.get(1).reserve();
//        if (theater.reserveSeat("A02")) {
//            System.out.println("Please pay");
//        } else {
//            System.out.println("Sorry, this seat is taken");
//        }
//
//        Collections.reverse(seatsCopy);
//        System.out.println("\n \nCollections.reverse()" +
//                "\nPrinting seatCopy :");
//        printList(seatsCopy);
//        System.out.println("Last element of list is: " + seatsCopy.get(seatsCopy.size() - 1).getSeatNumber());
//        System.out.println("Printing theater.seats :");
//        printList(theater.seats);
//        System.out.println("Last element of list is: " + theater.seats.get(theater.seats.size() - 1).getSeatNumber());
//
//        Collections.shuffle(seatsCopy);
//        System.out.println("\n \nCollections.shuffle()" +
//                "\nPrinting seatCopy :");
//        printList(seatsCopy);
//        System.out.println("Last element of list is: " + seatsCopy.get(seatsCopy.size() - 1).getSeatNumber());
//        System.out.println("Printing theater.seats :");
//        printList(theater.seats);
//        System.out.println("Last element of list is: " + theater.seats.get(theater.seats.size() - 1).getSeatNumber());
//
//        smallTheater_Comparator_AND_Comparable.Theater.Seat minSeat = Collections.min(seatsCopy);
//        smallTheater_Comparator_AND_Comparable.Theater.Seat maxSeat = Collections.max(seatsCopy);
//
//        System.out.println("Min seat number is: " + minSeat.getSeatNumber());
//        System.out.println("Max seat number is: " + maxSeat.getSeatNumber());
//        System.out.println("Last element of list is: " + seatsCopy.get(seatsCopy.size() - 1).getSeatNumber());
//
//        sortList(seatsCopy);
//        System.out.println("\nPrinting sorted seatCopy :");
//        printList(seatsCopy);
//        Collections.co
//
//    }

    public static void printList(List<Theater.Seat> list) {
        for (Theater.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber());
        }
        System.out.println("\n =====================================");
    }

    public static void printListWithPrice(List<Theater.Seat> list) {
        for (Theater.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber() + ": $" + seat.getPrice() + ", ");
        }
        System.out.println("\n =====================================");
    }

    public static void sortList(List<? extends Theater.Seat> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {


        Theater theater = new Theater("Olimpian", 8, 12);

        if (theater.reserveSeat("D12")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, this seat is taken");
        }

        if (theater.reserveSeat("D12")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, this seat is taken");
        }

        if (theater.reserveSeat("B13")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, this seat is taken");
        }

        List<Theater.Seat> reverseSeats = new ArrayList<>(theater.getSeats());
        Collections.reverse(reverseSeats);
        printList(reverseSeats);

        List<Theater.Seat> priceSeats = new ArrayList<>(theater.getSeats());
        priceSeats.add(theater.new Seat("B00", 13.00));
        priceSeats.add(theater.new Seat("A00", 13.50));
        Collections.sort(priceSeats, Theater.PRICE_ORDER);
        printListWithPrice(priceSeats);
    }
}
