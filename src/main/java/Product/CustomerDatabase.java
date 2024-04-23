package Product;

import java.util.Iterator;
import java.util.Vector;

/**
 * Maintains a collection of {@link Customer} objects.
 *
 * @author A Jiayi
 * @version  1.0.0
 * @see Customer
 */
public class CustomerDatabase {

	/* Collection of <code>Customer</code> objects.*/
	private Vector<Customer> customers;

	/**
	 * Constructs an empty collection of {@link Customer}
	 * objects.
	 */
	public CustomerDatabase() {

		customers = new Vector<Customer>();
	}

	/**
	 * Adds a {@link Customer} object to this collection.
	 *
	 * @param customer  the {@link Customer} object.
	 */
	public void  addCustomer(Customer customer) {

		customers.add(customer);
	}

	/**
	 * Returns an iterator over the customers in this database.
	 *
	 * return  an {@link Iterator}
	 */
	public Iterator<Customer>  getCustomersIterator() {

		return customers.iterator();
	}

	/**
	 * Returns the number of {@link Customer} objects in this collection.
	 *
	 * @return  the number of {@link Customer} objects in this collection.
	 */
	public int  getNumberOfCustomers() {

		return customers.size();
	}


	/**
	 * Returns the {@link Customer} object with the specified
	 * <code>id</code>.
	 *
	 * @param id  the id of the customer.
	 * @return  The {@link Customer} object with the specified id.
	 *          Returns <code>null</code> if the object with the
	 *          id is not found.
	 */
	public Customer getCustomer(String id) {
		
		for (Iterator<Customer> i = getCustomersIterator(); i.hasNext();) {

			Customer borrower = (Customer) i.next();

			if (borrower.getId().equals(id)) {

				return borrower;
			}
		}

		return null;
	}
}
