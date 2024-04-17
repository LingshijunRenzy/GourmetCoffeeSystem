package Product;

import java.util.Iterator;
import java.util.Vector;

/**
 * Maintains a collection of {@link CatalogItems} assigned to a borrower.
 *
 * @author A Jiayi
 * @version  1.0.0
 * @see CatalogItem
 */
public class OrderedItems {


	/* Catalog items assigned to a borrower.*/
	private static Vector<OrderedItems> items;

	/**
	 * Sets the collection of {@link CatalogItems} to empty.
	 */
	public OrderedItems() {

		items = new Vector<OrderedItems>();
	}

	/**
	 * Adds a {@link CatalogItem} object to this collection and
	 * sets the {@link CatalogItem} object as not available.
	 *
	 * @param item  the {@link CatalogItem} object.
	 */
	public void  addItem(CatalogItem catalogItem) {

		items.add(catalogItem);
		catalogItem.setAvailable(false);
	}

	/**
	 * Removes a {@link CatalogItem} object from this collection
	 * and sets the {@link CatalogItem} object as available.
	 *
	 * @param item  the {@link CatalogItem} object.
	 */
	public boolean  removeItem(CatalogItem catalogItem) {

		if (items.removeElement(catalogItem)){;
			catalogItem.setAvailable(true);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns an iterator over the borrowed items in this collection.
	 *
	 * return  an {@link Iterator}
	 */
	public static Iterator<OrderedItems> getItemsIterator() {

		return items.iterator();
	}

	/**
	 * Returns the {@link CatalogItem} object with the specified
	 * <code>code</code>.
	 *
	 * @param code  the code of an item.
	 * @return  The {@link CatalogItem} object with the specified
	 *          code. Returns <code>null</code> if the object with
	 *          the code is not found.
	 */
	public static OrderedItems getItem(String code) {

		for (Iterator<OrderedItems> i = getItemsIterator(); i.hasNext();) {

			OrderedItems orderedItem = i.next();

			if (i.next().getCode().equals(code)) {

				return orderedItem;
			}
		}

		return null;
	}
	public String getCode() {

		return  CatalogItem.code;
	}
	/**
	 * Returns the number of borrowed items.
	 *
	 * @return  the number of borrowed items.
	 */
	public static int  getQuantity() {

		return items.size();
	}

	public double getPrice() {
			return CatalogItem.price;
	}

	public String getDescription() {
		return CatalogItem.description;
		}

	public static int getNumberOfItems() {
		return items.size();
	}

	

