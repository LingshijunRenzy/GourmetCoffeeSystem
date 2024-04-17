package Product;

import java.util.Iterator;
import java.util.Vector;

/**
 * Maintains a collection of {@link CatalogItems} assigned to a borrower.
 *
 * @author A Jiayi
 * @version 1.0.0
 * @see CatalogItem
 */
public class OrderedItems extends CatalogItem {

	/* Catalog items assigned to a borrower. */
	private static Vector<OrderedItems> items = new Vector<OrderedItems>(); // 初始化静态成员变量

	/**
	 * Sets the collection of {@link CatalogItems} to empty.
	 */
	public OrderedItems() {

		super(code, description, price, quantity); // 调用父类构造函数（如果有的话）
		items.add(this); // 将当前实例添加到静态集合中
	}

	/**
	 * Adds a {@link CatalogItem} object to this collection and sets the
	 * {@link CatalogItem} object as not available.
	 *
	 * @param item the {@link CatalogItem} object.
	 */
	public void addItem(OrderedItems catalogItem) {

		items.add(catalogItem);
	}

	/**
	 * Removes a {@link CatalogItem} object from this collection and sets the
	 * {@link CatalogItem} object as available.
	 *
	 * @param item the {@link CatalogItem} object.
	 */
	public boolean removeItem(CatalogItem catalogItem) {

		if (items.removeElement(catalogItem)) {
			;
			catalogItem.setAvailable(true);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns an iterator over the borrowed items in this collection.
	 *
	 * return an {@link Iterator}
	 */
	public Iterator<OrderedItems> getItemsIterator() {

		return items.iterator();
	}

	/**
	 * Returns the {@link CatalogItem} object with the specified <code>code</code>.
	 *
	 * @param code the code of an item.
	 * @return The {@link CatalogItem} object with the specified code. Returns
	 *         <code>null</code> if the object with the code is not found.
	 */
	public OrderedItems getItem(String code) {  
	    Iterator<OrderedItems> i = getItemsIterator(); // 假设这个方法返回正确的Iterator类型  
	    while (i.hasNext()) { // 使用while循环代替for循环  
	        OrderedItems orderedItem = i.next(); // 只调用一次i.next()  
	        if (orderedItem.getCode().equals(code)) { // 使用之前获取的orderedItem进行比较  
	            return orderedItem;  
	        }  
	    }  
	    return null;  
	}

	public String getCode() {

		return CatalogItem.code;
	}

	/**
	 * Returns the number of borrowed items.
	 *
	 * @return the number of borrowed items.
	 */
	public int getQuantity() {

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
}
