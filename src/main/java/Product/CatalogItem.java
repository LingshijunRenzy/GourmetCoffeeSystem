package Product;

import java.util.*;

public class CatalogItem {

	/* Code of the item. */
	public static String  code;

    public static String description;  

    public static double price;

    public static int quantity;  
    
    public boolean available;

	

    public CatalogItem(String code, String description, double price, int quantity) {  

        Product.code = code;  

        this.description = description;  

        this.price = price;  
        
        Product.quantity = quantity;

    }  

	/**
	 * Returns the code of this item.
	 *
	 * @return  the code of this item.
	 */
	public String getCode() {

		return  code;
	}

	
	
	/**
	 * Returns <code>true</code> if the item is available.
	 *
	 * @return  <code>true</code> if the item is available;
	 *          <code>false</code> otherwise.
	 */
	public boolean isAvailable() {

		return available;
	}
	
	/**
	 * Sets the value of instance variable <code>available</code>.
	 *
	 * @param newValue  the new value.
	 */
	public void setAvailable(boolean newValue) {

		available = newValue;
	}

	/**
	 * Returns <code>true</code> if the code of this catalog item is
	 * equal to the code of the argument
	 *
	 * @param object  object with which this catalog item is compared.
	 * @return  <code>true</code> if the code of this catalog item is
	 *          equal to the code of the argument; <code>false</code>
	 *          otherwise.
	 */
	public boolean equals(Object object) {

		return object instanceof CatalogItem
		       && getCode().equals(((CatalogItem) object).getCode());
	}

	/**
	 * Returns the string representation of this catalog item.
	 *
	 * @return  the string representation of this catalog item.
	 */
	public String toString() {

		return  getCode() + "_" + getDescription() + "_" + getPrice()+ "_" + getQuantity()
		        + "_" + isAvailable();
	}

	public int getQuantity() {
		// TODO Auto-generated method stub
		return quantity;
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	public static CatalogItem getItem(String code) {

		for (Iterator<CatalogItem> i = getItemsIterator(); i.hasNext();) {

			CatalogItem catalogItem = (CatalogItem) i.next();

			if (catalogItem.getCode().equals(code)) {

				return catalogItem;
			}
		}

		return null;
	}

	public static Iterator<CatalogItem> getItemsIterator() {

		return items.iterator();
	}
}