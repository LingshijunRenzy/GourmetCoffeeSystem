package Product;

public class CatalogItem {

	private String  code;

	private String description;

	private double price;

	private int quantity;

	private boolean available;

	
	/**
	 * CatalogItem的构造函数
	 */
    public CatalogItem(String code, String description, double price, int quantity) {  

        this.code = code;

        this.description = description;  

        this.price = price;  
        
        this.quantity = quantity;

    }

	/**
	 * 从产品创建CatalogItem
	 *
	 * @param product 产品
	 * @param quantity 数量
	 */
	public CatalogItem(Product product, int quantity){
		this.code = product.getCode();

		this.description = product.getDescription();

		this.price = product.getPrice();
	}


	/**
	 * Returns the code of this item.
	 *
	 * @return  the code of this item.
	 */
	public String getCode() {
		return  code;
	}
	public void setCode(String code) { this.code = code; }


	/**
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
		return quantity;
	}
	public void setQuantity(int quantity) { this.quantity = quantity; }

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) { this.description = description; }

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) { this.price = price; }

//	public CatalogItem getItem(String code) {
//
//		for (Iterator<CatalogItem> i = getItemsIterator(); i.hasNext();) {
//
//			CatalogItem catalogItem = (CatalogItem) i.next();
//
//			if (catalogItem.getCode().equals(code)) {
//
//				return catalogItem;
//			}
//		}
//
//		return null;
//	}

//	private Iterator<CatalogItem> getItemsIterator() {
//
//		return items.iterator();
//	}

}
