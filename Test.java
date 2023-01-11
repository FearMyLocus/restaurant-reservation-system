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
		input.nextLine();

		// Check if party is too large or non-positive
		while (partySize <= 0 || partySize > 12) {
		    // Offer to make reservation for a different time
		    System.out.print("\nI'm sorry, we can't accommodate parties larger than 12 or non-positive. please enter a valid number: ");
		    partySize = input.nextInt();
		    input.nextLine();
		}
		// Check again if party is too large
		if (partySize > 12) {
		    System.out.print("\nI'm sorry, we can't accommodate parties larger than 12."
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
				System.out.print("\nGot it, we have a table available for " + partySize + " people at "
						+ reservationTime + "." + "\nPlease note that large parties may experience longer wait times. "
						+ "\nWould you still like to proceed with the reservation? (Y/N) ");
				reservationAnswer2 = input.nextLine();
				reservationAnswer2 = reservationAnswer2.toLowerCase();

				// If user confirms reservation
				if (reservationAnswer2.equals("y")) {
					// Confirmation message
					System.out.println("\nThank you, " + name + "! Your reservation for " + partySize + " people at "
							+ reservationTime + " has been confirmed.");
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

			// Declare arrays for menu items and prices
			String[] drinks = {"Water", "Soda", "Beer", "Wine", "Cocktail"};
			int[] drinkPrices = {0, 2, 5, 7, 10};

			String[] foods = {"Grilled Salmon", "Filet Mignon", "Lobster Tail", "Vegetarian Stir-Fry", "Caesar Salad"};
			int[] foodPrices = {18, 30, 40, 12, 10};
			
			
			// Offer drink menu
			System.out.println("Lets Start Off With Some Drinks");
			System.out.println("\nHere Is Our Drink Menu:");

			// Print the drink menu using a for loop
			for (int i = 0; i < drinks.length; i++) {
			    System.out.println(i + 1 + ". " + drinks[i] + " ($" + drinkPrices[i] + ")");
			}

			// Get drink selection
			System.out.print("Please Enter The Number Of Your Drink Selection..: ");
			while (!input.hasNextInt()) {
			    System.out.println("Invalid input, please enter a valid number.");
			    input.next();
			}
			drinkSelection = input.nextInt();
			input.nextLine(); // consume the remaining newline character
			while (drinkSelection < 1 || drinkSelection > drinks.length) {
			    System.out.print("\nInvalid option. \nPlease select a number between 1 and " + drinks.length + " ..: ");
			    while (!input.hasNextInt()) {
			        System.out.println("Invalid input, please enter a valid number.");
			        input.next();
			    }
			    
			    while (true) {
			        System.out.print("Please Enter The Number Of Your Food Selection: ");
			        foodSelection = input.nextInt();

			        // check if input is valid
			        if (foodSelection >= 1 && foodSelection <= foods.length) {
			            break; // exit the loop if input is valid
			        }
			        System.out.println("Invalid option. Please select a number between 1 and " + foods.length + ".");
			    }
			    
			    drinkSelection = input.nextInt();
			    input.nextLine();
			}

			// Offer food menu
			System.out.println("\nHere Are Some Of Menu Items:");

			// Print the food menu using a for loop
			for (int i = 0; i < foods.length; i++) {
			    System.out.println(i + 1 + ". " + foods[i] + " ($" + foodPrices[i] + ")");
			}

			// Get food selection
			System.out.print("Please Enter The Number Of Your Food Selection: ");
			while (!input.hasNextInt()) {
			    System.out.println("Invalid input. Please enter a valid number: ");
			    input.next();
			}
			foodSelection = input.nextInt();

			// Check if input is valid
			while (foodSelection < 1 || foodSelection > foods.length) {
			    System.out.println("Invalid option. Please select a number between 1 and " + foods.length + ":");
			    while (!input.hasNextInt()) {
			    System.out.println("Invalid input. Please enter a valid number: ");
			    input.next();
			}
			    foodSelection = input.nextInt();
			    input.nextLine();
			}
			
			
			// Calculate bill
			int totalBill = drinkPrices[drinkSelection - 1] + foodPrices[foodSelection - 1];

			// Print order summary
			System.out.println("\nHere is your order summary:");
			System.out.println("Party size: " + partySize);
			System.out.println("Drink selection: " + drinks[drinkSelection - 1]);
			System.out.println("Food selection: " + foods[foodSelection - 1]);
			System.out.println("Total bill: $" + totalBill);
			
			
			
			System.out.println("\nDo You Want To Start Over Or Quit? (S/Q)..: ");
			String choice = input.nextLine();
			if (choice.equalsIgnoreCase("s")) {
			    // Call the main method again to start over
			    main(args);
			} else if (choice.equalsIgnoreCase("q")) {
			    System.out.println("Thank You For Using Our System. Have A Good Day!");
			    System.exit(0);
			} else {
			    System.out.println("Invalid Input. Please Enter S or Q..: ");
			}

			
			
		}
		input.close();
	}
}	
