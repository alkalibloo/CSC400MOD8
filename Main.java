import java.util.Scanner;

public class Main {

	public static Scanner scnr = new Scanner(System.in);

	// main menu
	public static void menu() {
		System.out.println("Welcome to the order keeper program.");
		System.out.println("Please select one of the following options.\n");
		System.out.println("1. Add an order to the order list");
		System.out.println("2. Remove an order from the order list");
		System.out.println("3. Quit");
	}

	// getting input from user
	public static int input() {
		int choice = 0;

		while (true) {
			System.out.print("\nEnter choice: ");
			try {
				choice = Integer.parseInt(scnr.nextLine());
				if (choice >= 1 && choice <= 3)
					break;
				System.out.println("Input out of range.  Try again.");
			} catch (Exception e) {
				System.out.println("Invalid input.  Try again.");
			}
		}
		return choice;
	}

	// get order details from user
	public static OrderLineItem inputCustomer() {

		String name;
		int number;
		double cost;

		// get order number
		System.out.print("What is the # of this order?");
		number = Integer.parseInt(scnr.nextLine());

		// get last name
		System.out.print("What is the last name associated with this order?");
		name = scnr.nextLine();

		// get order cost
		System.out.print("What is the total cost of this order?");
		cost = Double.parseDouble(scnr.nextLine());

		// create order and return to calling code
		OrderLineItem item = new OrderLineItem(name, number, cost);
		return item;

	}

	// run the program
	public static void execute(Order order, Display display) {

		int choice = 0;

		while (true) { // program loop

			menu(); // run menu

			choice = input(); // get user menu choice

			// if statements determine action based on choice
			if (choice == 1) { // Adding an order

				OrderLineItem cust = inputCustomer(); // get new order info
				order.addOrder(cust, display); // add order to queue and sort into display arrays

			} else if (choice == 2) {
				order.removeOrder(display); // remove order from queue
			} else {
				break; // end
			}
		}
	}

	// main() method
	public static void main(String[] args) {

		Order order = new Order(); // create the queue
		Display display = new Display(); // create the display
		execute(order, display); // run all
	}

}