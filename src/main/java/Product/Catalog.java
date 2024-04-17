package Product;

import java.util.*;

public class Catalog  {
	public String acidity;

	public String aroma;

	public String body;

	public String OriginCountry;

	public String TypeofRoast;

	public String flavor;
	/* Collection of <code>Product</code> objects.*/
	private Vector<CatalogItem> items;

	/**
	 * Constructs an empty catalog.
	 */
	public Catalog() {

		items = new Vector<CatalogItem>();
	}

	/**
	 * Adds a {@link CatalogItem} object to this catalog.
	 *
	 * @param product  the {@link CatalogItem} object.
	 */
	public void addItem(CatalogItem catalogItem) {

		items.add(catalogItem);
	}

	/**
	 * Returns an iterator over the items in this catalog.
	 *
	 * return  an {@link Iterator}
	 */
	public Iterator<CatalogItem> getItemsIterator() {

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
	public CatalogItem  getItem(String code)  {

		for (Iterator<CatalogItem> i = getItemsIterator(); i.hasNext();) {

			CatalogItem catalogItem = (CatalogItem) i.next();

			if (catalogItem.getCode().equals(code)) {

				return catalogItem;
			}
		}

		return null;
	}

	/**
	 * Returns the number of items in the catalog.
	 *
	 * @return the number of {@link CatalogItem} objects in this catalog.
	 */
	public int  getNumberOfItems()  {

		return items.size();
	}

	

	/**
	 * Returns the {@link Product} object with the specified
	 * <code>code</code>.
	 *
	 * @param code  the code of an product.
	 * @return  The {@link Product} object with the specified
	 *          code. Returns <code>null</code> if the object with
	 *          the code is not found.
	 */
	public CatalogItem  getProduct(String code)  {

		for (Iterator<CatalogItem> i = getItemsIterator(); i.hasNext();) {

			CatalogItem catalogProduct =  i.next();

			if (catalogProduct.getClass().equals(code)) {

				return catalogProduct;
			}
		}

		return null;
	}

	/**
	 * Returns the number of products in the catalog.
	 *
	 * @return the number of {@link Product} objects in this catalog.
	 */
	public int  getNumberOfProducts()  {

		return items.size();
	}

	public Iterator<CatalogItem> getProductsIterator() {
		// TODO Auto-generated method stub
		return items.iterator();
	}

	
}
