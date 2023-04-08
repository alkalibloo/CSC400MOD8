import java.util.LinkedList;
import java.util.Queue;

public class OrderLineItem {

	// class variables
	private String lastName;
	private int orderNumber;
	private double orderCost;

	// Constuctor for OrderLineItems
	public OrderLineItem(String last, int num, double cost) {
		super();
		this.lastName = last;
		this.orderNumber = num;
		this.orderCost = cost;
	}

	// Setters
	public void setName(String name) {
		this.lastName = name;
	}

	public void setOrderNumber(int num) {
		this.orderNumber = num;
	}

	public void setOrderCost(double totalCost) {
		this.orderCost = totalCost;
	}

	// Getters
	public String getName() {
		return lastName;
	}

	public double getOrderCost() {
		return orderCost;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	// toString() for printing
	public String toString() {
		return orderNumber + " , " + lastName + " , " + orderCost;
	}

}
