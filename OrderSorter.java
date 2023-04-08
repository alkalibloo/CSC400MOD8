// A quick sort algorithm
public class OrderSorter {

	// partitioning
	public static int partition(OrderLineItem array[], int left, int right, String type) {

		OrderLineItem pivot = array[right];
		int i = (left - 1);

		for (int j = left; j < right; j++) {

			// sort by orderNumber
			if (type.equals("orderNumber")) {

				if (array[j].getOrderNumber() <= pivot.getOrderNumber()) {
					i++;

					OrderLineItem temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}

				// sort by name
			} else if (type.equals("name")) {
				if (array[j].getName().compareTo(pivot.getName()) <= 0) {
					i++;

					OrderLineItem temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}

		OrderLineItem temp = array[i + 1];
		array[i + 1] = array[right];
		array[right] = temp;

		return i + 1;
	}

	// quick sort by type
	public static void sort(OrderLineItem array[], int left, int right, String type) {
		if (left < right) {

			int part = partition(array, left, right, type);

			sort(array, left, part - 1, type);
			sort(array, part + 1, right, type);
		}
	}
}
