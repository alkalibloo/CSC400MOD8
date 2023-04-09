
public class Display {

	private OrderLineItem nameArray[];
	private OrderLineItem orderArray[];
	private int size;
	private int currentSize;

	// resize the array
	private void arrayResize() {
		int size = nameArray.length * 2;
		OrderLineItem[] arr = new OrderLineItem[size];
		for (int i = 0; i < nameArray.length; i++)
			arr[i] = nameArray[i];
		nameArray = arr;

		size = orderArray.length * 2;
		arr = new OrderLineItem[size];
		for (int i = 0; i < orderArray.length; i++)
			arr[i] = orderArray[i];
		orderArray = arr;

		this.size = size;
		currentSize = 0;
	}

	// display constructor
	public Display() {
		this.size = 20;
		nameArray = new OrderLineItem[size];
		orderArray = new OrderLineItem[size];
	}

	// put order into the two arrays
	public void insertOrder(OrderLineItem item) {
		if (currentSize == size)
			arrayResize();

		nameArray[currentSize] = item;
		orderArray[currentSize] = item;

		currentSize += 1;

		OrderSorter.sort(nameArray, 0, currentSize - 1, "name");
		OrderSorter.sort(orderArray, 0, currentSize - 1, "orderNumber");
		print();
	}

	// take order out of arrays
	public void removeOrder(OrderLineItem item) {
		int i;

		for (i = 0; i < currentSize; i++) {
			if (item == nameArray[i])
				break;
		}
		for (int k = i; k < currentSize; k++) {
			nameArray[k] = nameArray[k + 1];
		}
		for (i = 0; i < currentSize; i++) {
			if (item == orderArray[i])
				break;
		}
		for (int k = i; k < currentSize; k++) {
			orderArray[k] = orderArray[k + 1];
		}
		nameArray[currentSize - 1] = null;
		orderArray[currentSize - 1] = null;
		currentSize -= 1;
		System.out.println("Removed one item from order queue.");
		print();

	}

	// print the arrays
	public void print() {
		System.out.println();
		System.out.print("Your queue of orders, sorted by name: \n");
		print(nameArray);
		System.out.println();
		System.out.print("Your queue of orders, sorted by number: \n");
		print(orderArray);
		System.out.println();
	}

	// overload print() method
	public void print(OrderLineItem[] array) {
		System.out.println("======================================");
		System.out.println("= Order Num || Last Name    || Cost  =");
		System.out.println("======================================");
		for (int i = 0; i < currentSize; i++)
			System.out.printf("= %1s         || %-10s   || %.8s  \n", array[i].getOrderNumber(), array[i].getName(),
					array[i].getOrderCost());

	}
}
