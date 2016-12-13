package shopicruit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 
 * 
 * @author Peter Zhu
 * 
 */
public class ReadJSON {
	private List<Order> orders;

	/**
	 * Reads JSON file from online from the list of URLs. Creates the list of
	 * orders.
	 * 
	 * @param urlList
	 *            list of URLs to read JSON objects
	 * @throws IOException
	 *             if an exception occurs when reading the JSON file
	 */
	public ReadJSON(String[] urlList) throws IOException {
		orders = new ArrayList<>();

		for (String url : urlList) {
			// Try-with-resources so streams are automatically closed.
			try (InputStream stream = new URL(url).openStream();
					BufferedReader input = new BufferedReader(
							new InputStreamReader(stream,
									Charset.forName("UTF-8")))) {
				StringBuilder jsonText = new StringBuilder();

				String line;

				// Read all the lines from the JSON file.
				while ((line = input.readLine()) != null) {
					jsonText.append(line);
				}

				// Parse the JSON file.
				JSONObject json = new JSONObject(jsonText.toString());

				JSONArray jarray = json.getJSONArray("orders");

				// Add all the objects created from the JSON file into the
				// array.
				orders.addAll(getOrders(jarray));
			}
		}
	}
	
	public double getTotal() {
		double total = 0;
		
		for (Order o : orders) {
			total += o.getTotal();
		}
		
		return total;
	}

	/**
	 * Converts to Order objects from a JSON array.
	 * 
	 * @param jsonArray
	 *            the JSON array to convert
	 * @return the list of converted Order objects
	 */
	private static List<Order> getOrders(JSONArray jsonArray) {
		List<Order> currentOrders = new ArrayList<>();

		// Loop through every element in the JSONArray.
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject order = jsonArray.getJSONObject(i);

			Order o = new Order(order.getDouble("total_price"));

			currentOrders.add(o);
		}

		return currentOrders;
	}
}
