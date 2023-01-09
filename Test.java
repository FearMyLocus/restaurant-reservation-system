package RestaurantReservationSystem;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        // Declare variables for storing user input
        String name, seatingChoice, reservationAnswer1, reservationAnswer2, reservationTime;
        int partySize, drinkSelection, foodSelection;
        
        Scanner input = new Scanner(System.in);

        // Welcome message
        System.out.println("Welcome to The Grill & Bar!");

        // Get user's name
        System.out.print("Hello, what's your name?..: ");
        name = input.nextLine();

        // Get number of people in party
        System.out.print("\nHi " + name + ", how many people are in your party?..: ");
        partySize = input.nextInt();
        input.nextLine(); // consume the remaining newline character

        // Check if party is too large
        if (partySize > 12) {
            // Offer to make reservation for a different time
            System.out.print("\nI'm sorry, we can't accommodate parties larger than 12. "
                    + "\nWould you like to make a reservation for a different time? (Y/N)..: ");
            reservationAnswer1 = input.nextLine();
            reservationAnswer1 = reservationAnswer1.toLowerCase();

            // If user wants to make a reservation
            if (reservationAnswer1.equals("y")) {
                // Get desired reservation time
                System.out.print("\nGreat, let me check our availability. "
                        + "\nWhat time would you like to make a reservation for?..: ");
                reservationTime = input.nextLine();
                // Confirm reservation
                System.out.print("\nGot it, we have a table available for " + partySize + " people at " + reservationTime + "."
                        + "\nPlease note that large parties may experience longer wait times. "
                        + "\nWould you still like to proceed with the reservation? (Y/N) ");
                reservationAnswer2 = input.nextLine();
                reservationAnswer2 = reservationAnswer2.toLowerCase();

                // If user confirms reservation
                if (reservationAnswer2.equals("y")) {
                    // Confirmation message
                    System.out.println("\nThank you, " + name + "! Your reservation for " + partySize + " people at " + reservationTime + " has been confirmed.");
                } else {
                    // If user declines reservation
                    System.out.println("\nWe Understand, we Hope You Have A Good Day.");
                }
            } else {
                // If user does not want to make a reservation
                System.out.println("\nUnderstandable, we hope you have a good time.");
            }
        } else {
            // If party is small enough
            // Ask about seating preference
            System.out.print("\nGreat, we have a table available for " + partySize + " people."
                    + "\nWould you like to sit indoors or outdoors? (I/O)..: ");
            seatingChoice = input.nextLine();
            
            // Assign seating
            if (seatingChoice.equals("i")) {
                // If user wants indoor seating
                System.out.println("\nPerfect, we'll seat you indoors.");
            } else if (seatingChoice.equals("o")) {
                // If user wants outdoor seating
                System.out.println("\nPerfect, we'll seat you outdoors.");
            } else {
                // If user enters invalid seating preference
                System.out.println("\nInvalid option. We'll seat you indoors.");
            }
            
            // Offer drink menu
            System.out.println("Lets Start Off With Some Drinks");
            System.out.println("\nHere Is Our Drink Menu:\n"
                    + "1. Water ($0)\n"
                    + "2. Soda ($2)\n"
                    + "3. Beer ($5)\n"
                    + "4. Wine ($7)\n"
                    + "5. Cocktail ($10)\n");
            // Get drink selection
            System.out.print("Please Enter The Number Of Your Drink Selection..: ");
            drinkSelection = input.nextInt();
            input.nextLine(); // consume the remaining newline character
            
            // Offer food menu
            System.out.println("\nHere Are Some Of Menu Items:\n"
                    + "1. Grilled Salmon ($18)\n"
                    + "2. Filet Mignon ($30)\n"
                    + "3. Lobster Tail ($40)\n"
                    + "4. Vegetarian Stir-Fry ($12)\n"
                    + "5. Caesar Salad ($10)\n");
            // Get food selection
            System.out.print("Please Enter The Number Of Your Food Selection: ");
            foodSelection = input.nextInt();
            
            // Print order summary
            System.out.println("\nHere is your order summary:");
            System.out.println("Party size: " + partySize);
            System.out.println("Drink selection: " + drinkSelection);
            System.out.println("Food selection: " + foodSelection);
        }
        input.close();
    }
}
            		
