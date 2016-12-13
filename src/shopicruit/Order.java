package shopicruit;

/**
 * Object that represents an order. Only "total" is represented here because
 * that is all thats needed to calculate the total revenue. Add more fields in
 * here if needed.
 * 
 * @author Peter Zhu
 * 
 */
public class Order {
	private double total;

	/**
	 * Default constructor initializes all fields to their default values.
	 */
	public Order() {
		total = 0;
	}

	/**
	 * Initializes the fields to a given value.
	 * 
	 * @param t
	 *            total of the order
	 */
	public Order(double t) {
		setTotal(t);
	}

	/**
	 * Getter for the total.
	 * 
	 * @return total of the order
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * Setter for the total.
	 * 
	 * @param total
	 *            total of the order
	 */
	public void setTotal(double total) {
		this.total = total;
	}
}
