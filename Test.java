package RestaurantReservationSystem;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test {
	public static boolean checkPartySize(int partySize) {
		return partySize > 0 && partySize <= 12;
	}
	public static void main(String[] args) {
		try {
            String os = System.getProperty("os.name").toLowerCase();
            Process p;
            if (os.contains("win")) {
                p = Runtime.getRuntime().exec("python.exe /path/to/ascii_art.py");
            } else if (os.contains("mac") || os.contains("linux")) {
                p = Runtime.getRuntime().exec("python /path/to/ascii_art.py");
            } else {
                System.out.println("Unsupported operating system.");
                return;
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String output;
            while ((output = in.readLine()) != null) {
                System.out.println(output);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		// Declare variables for storing user input
		String name = "", seatingChoice, reservationAnswer1 = "", reservationAnswer2, reservationTime;
		int partySize, drinkSelection, foodSelection;
		double totalBill = 0;

		Scanner input = new Scanner(System.in);

		// Declare arrays for menu items and prices
		String[] drinks = { "Water", "Soda", "Beer", "Wine", "Cocktail" };
		int[] drinkPrices = { 0, 2, 5, 7, 10 };
		String[] foods = { "Grilled Salmon", "Filet Mignon", "Lobster Tail", "Vegetarian Stir-Fry",
		"Caesar Salad" };
		int[] foodPrices = { 18, 30, 40, 12, 10 };

		// Welcome message
		System.out.println("\n\n...Welcome to The Grill & Bar!");

		// Get users name
		System.out.print("Hello, what's your name?..: ");
		while (name.isEmpty()) {
			try {
				name = input.nextLine();
			} catch (NoSuchElementException | IllegalStateException e) {
				System.out.println("Error occurred while getting your name. Please try again.");
			}
		}

		// Get number of people in party
		while (true) {
			try {
				System.out.print("\nHow many people are in your party?..: ");
				partySize = Integer.parseInt(input.nextLine());
				if (partySize > 0 && partySize <= 12) {
					break;
				} else {
					System.out.println("Invalid input, please enter a valid number between 1 and 12.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input, please enter a valid number between 1 and 12.");
			}
		}

		// Check if party is too large or non-positive
		if (!checkPartySize(partySize)) {
			System.out.println("I'm sorry, we can't accommodate parties larger than 12 or non-positive. please enter a valid number: ");
		}

		if (partySize > 12) {
			System.out.print("\nI'm sorry, we can't accommodate parties larger than 12."
					+ "\nWould you like to make a reservation for a different time? (Y/N)..: ");

			reservationAnswer1 = input.nextLine();
			reservationAnswer1 = reservationAnswer1.toLowerCase();
		}

		// If user wants to make a reservation
		if (reservationAnswer1.equalsIgnoreCase("y")) {
			// Get desired reservation time
			System.out.print("\nGreat, let me check our availability. "
					+ "\nWhat time would you like to make a reservation for?..: ");
			try {
				reservationTime = input.nextLine();
			} catch (Exception e) {
				System.out.println("Error Occurred While Getting Your Reservation Time. Please try again."
						+ "\nPlease Enter Your Reservation Time..: ");
				reservationTime = input.nextLine();
			}
			// Confirm reservation
			System.out.print("\nGot it, we have a table available for " + partySize + " people at "
					+ reservationTime + "." + "\nPlease note that "
					+ "large parties may experience longer wait times. "
					+ "\nWould you still like to proceed with the reservation? (Y/N) ");
			try {
				reservationAnswer2 = input.nextLine();
			} catch (Exception e) {
				System.out.println("Error Occurred While Getting Your Reservation Confirmation. Please try again."
						+ "\nPlease Enter Your Reservation Confirmation (Y/N)..: ");
				reservationAnswer2 = input.nextLine();
			}
			// If user confirms reservation
			if (reservationAnswer2.equalsIgnoreCase("y")) {
				// Confirmation message
				System.out.println("\nThank you, " + name + "! Your reservation for " + partySize + " people at "
						+ reservationTime + " has been confirmed.");
			} else {
				// If user declines reservation
				System.out.println("\nWe Understand, we Hope You Have A Good Day.");
			}
		}

		// If user does not want to make a reservation
		if (reservationAnswer1.equalsIgnoreCase("n")) {
			System.out.println("\nUnderstandable, we hope you have a good time.");
		}

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

		//drink menu
		System.out.println("\nLets Start Off With Some Drinks\nHere Is Our Drink Menu:");
		//loop through the drinks array and print out each drink with its corresponding price
		for (int i = 0; i < drinks.length; i++) {
			System.out.println((i+1) + "." + drinks[i] + " ($" + drinkPrices[i] + ")");
		}
		//prompt user to select a drink
		System.out.print("Please Enter The Number Of Your Drink Selection..: ");
		drinkSelection = input.nextInt();
		input.nextLine();
		//validate user input to ensure it is within the range of the menu options
		while (drinkSelection < 1 || drinkSelection > 5) {
			System.out.print("Invalid option.\nPlease select a number between 1 and 5 ..: ");
			drinkSelection = input.nextInt();
			input.nextLine();
		}
		//add the price of the selected drink to the total bill
		totalBill += drinkPrices[drinkSelection - 1];


		// Food menu
		System.out.println("\nHow About Food, Here Is Our Food Menu");
		// loop through the food array, print the food options and prices
		for (int i = 0; i < foods.length; i++) {
			System.out.println((i+1) + "." + foods[i] + " ($" + foodPrices[i] + ")");
		}
		// prompt user to select food option
		System.out.print("Please Enter The Number Of Your Food Selection..: ");
		foodSelection = input.nextInt();
		input.nextLine();
		// validate user input
		while (foodSelection < 1 || foodSelection > 5) {
			System.out.print("Invalid option.\nPlease select a number between 1 and 5 ..: ");
			foodSelection = input.nextInt();
			input.nextLine();
		}
		// add price of selected food to total bill
		totalBill += foodPrices[foodSelection - 1];


		// Check if input is valid
		while (foodSelection < 1 || foodSelection > 5) {
			System.out.print("Invalid option. Please select a number between 1 and 5..: ");
			while (!input.hasNextInt()) {
				System.out.println("Invalid input. Please enter a valid number: ");
				input.next();
			}
			foodSelection = input.nextInt();
			input.nextLine();
		}

		// Print order summary
		System.out.println("\nHere is your order summary:");
		System.out.println("Party size: " + partySize);
		System.out.println("Drink selection: " + drinks[drinkSelection - 1]);
		System.out.println("Food selection: " + foods[foodSelection - 1]);
		System.out.println("Total bill: $" + totalBill);

		System.out.print("\nDo You Want To Start Over Or Quit? (S/Q)..: ");
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
		input.close();
	}		
}