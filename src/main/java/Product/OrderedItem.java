package Product;

import java.util.Iterator;

/**
 * Maintains a collection of {@link CatalogItem} assigned to a borrower.
 *
 * @author A Jiayi
 * @version 1.0.0
 * @see CatalogItem
 */
public class OrderedItem {
	/* Number of ordered product.*/
	private static int quantity;

	/* The product itself*/
	private Product product;

	/**
	 * Sets the collection of {@link CatalogItem} to empty.
	 */
	public OrderedItem(String code, String description, double price, int quantity) {

        this.product = new Product(code, description, price);
		this.quantity = quantity;
	}

	public OrderedItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	/**
	 * Returns the quantity of items.
	 */
	public static int getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity of items.
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Returns the product.
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Get the price of the product.
	 */
	public double getPrice() {
		return product.getPrice();
	}

	/**
	 * Get the code of the product.
	 */
	public String getCode() {
		return product.getCode();
	}

	/**
	 * Get the description of the product.
	 */
	public String getDescription() {
		return product.getDescription();
	}

	/**
	 * Set the code of the product.
	 */
	public void setCode(String code) {
		product.setCode(code);
	}

	/**
	 * Set the description of the product.
	 */
	public void setDescription(String description) {
		product.setDescription(description);
	}

	/**
	 * Set the price of the product.
	 */
	public void setPrice(double price) {
		product.setPrice(price);
	}

	public static Iterator<OrderedItem> getItemsIterator() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
