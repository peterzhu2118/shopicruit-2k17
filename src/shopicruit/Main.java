package shopicruit;

import java.io.IOException;

/**
 * 
 * @author Peter
 *
 */
public class Main {

	public static void main(String[] args) {
		String[] url = {
				"https://shopicruit.myshopify.com/admin/orders.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6",
				"https://shopicruit.myshopify.com/admin/orders.json?page=2&access_token=c32313df0d0ef512ca64d5b336a0d7c6",
				"https://shopicruit.myshopify.com/admin/orders.json?page=3&access_token=c32313df0d0ef512ca64d5b336a0d7c6" };
		
		try {
			ReadJSON read = new ReadJSON(url);
			
			double total = read.getTotal();
			
			System.out.printf("Total price: %.2f", total);
		} catch (IOException e) {
			System.out.println("Cannot read from URL.");
		}
	}
}
