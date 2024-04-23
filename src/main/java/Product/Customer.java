package Product;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.Vector;

public class Customer {
	private String  id;
	private String  name;
	private int points;

	private Vector<Order> orders = new Vector<Order>();



	/**
	 * Constructs a <code>Customer</code> object.<p>
	 * The collection of the borrowed items is initially empty.</p>
	 *
	 * @param id  the id of the customer.
	 * @param name  the name of the customer.
	 * @param points the points of the customer.
	 */
	public Customer(String id, String name, int points) {
		this.id = id;
		this.name = name;
		this.points = points;
	}



	/**
	 * Returns the identification number of this customer.
	 *
	 * @return  the identification number of this customer.
	 */
	public String getId()  {
		return  id;
	}



	/**
	 * Returns <code>true</code> if the id of this borrower is
	 * equal to the id of the argument.
	 *
	 * @param object  object with which this borrower is compared.
	 * @return  <code>true</code> if the id of this borrower is
	 *          equal to the id of the argument; <code>false</code>
	 *          otherwise.
	 */
	public boolean equals(Object object) {

		return object instanceof Customer
		       && getId().equals(((Customer) object).getId());
	}

    
    
  
    public String getName() {  
        return name;  
    }  
  
    public int getPoints() {  
        return points;  
    }  
  
    public void addPoints(int pointsToAdd) {  
        this.points += pointsToAdd;  
    }  
  
    public void deductPoints(int pointsToDeduct) {  
        if (pointsToDeduct <= points) {  
            this.points -= pointsToDeduct;  
        } else {  
            System.out.println("Insufficient points for deduction.");  
        }  
    }  



    @Override  
    public String toString() {  
        return "Customer{" +  
                "name='" + name +
                ", points=" + points +  
                '}';  
    }



	public void addOrder(Order order) {
		orders.add(order);
	}

	public void removeOrder(UUID orderID) {
		orders.removeIf(o -> o.getOrderID().equals(orderID));
	}

	public Order getOrder(UUID orderID) {
		for (Order o : orders) {
			if (o.getOrderID().equals(orderID)) {
				return o;
			}
		}
		return null;
	}

	public int getNumberOfOrders() {
		return orders.size();
	}

	public Iterator<Order> getOrdersIterator() {
		return orders.iterator();
	}


	/**
	 * Buys a product and create a new order.
	 *
	 * @param product  the product to buy.
	 * @param quantity the quantity of the product to buy.
	 */
	public void buy(Product product, int quantity) {
		Order order = new Order();
		order.addProduct(product, quantity);
		addOrder(order);
		OrderDataBase.addOrder(order);
	}


	/**
	 * Buys a list of products and create a new order.
	 * The number of products and quantities must be the same.
	 * @param products
	 * @param quantities
	 */
	public void buy(List<Product> products, List<Integer> quantities) {
		if(products.size() != quantities.size()) {
			throw new IllegalArgumentException("The number of products and quantities must be the same.");
		}
		Order order = new Order();
		for (int i = 0; i < products.size(); i++) {
			order.addProduct(products.get(i), quantities.get(i));
		}
		addOrder(order);
		OrderDataBase.addOrder(order);
	}
}
