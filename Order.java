import java.util.LinkedList;
import java.util.Queue;

public class Order {

	// queue to hold all the orders
	private Queue<OrderLineItem> queue;

	// order queue constructor
	public Order() {
		queue = new LinkedList<OrderLineItem>();
	}

	// add order to queue
	public void addOrder(OrderLineItem lineItem, Display dis) {
		queue.add(lineItem);
		dis.insertOrder(lineItem);
	}

	// delete order from queue
	public OrderLineItem removeOrder(Display dis) {

		if (queue.isEmpty())
			return null;

		OrderLineItem order = queue.remove();
		dis.removeOrder(order);

		return order;
	}
}