package Product;

public class Customer {  
	private String  id;

	/* Name of the borrower.*/
	private String  name;

	/* Items ordered by the customer.*/
	
	private OrderedItems OrderedItems;

	private int points;  
	  
	/**
	 * Constructs a <code>Borrower</code> object.
	 * <p>
	 * The collection of the borrowed items is initially empty.
	 * </p>
	 *
	 * @param initialId  the id of the borrower.
	 * @param initialName  the name of the borrower.
	 */
	public Customer(String initialId, String initialName,int initialpoints) {

		id = initialId;
		name = initialName;
		points = initialpoints; 
		OrderedItems = new OrderedItems();
		
	}

	/**
	 * Returns the identification number of this borrower.
	 *
	 * @return  the identification number of this borrower.
	 */
	public String getId()  {

		return  id;
	}

	/**
	 * Returns the borrowed items collection.
	 *
	 * @return  a {@link BorrowedItems} object.
	 */
	public OrderedItems getOrderedItems() {

		return OrderedItems;
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
                ",ordereditems:" + OrderedItems + 
                ", points=" + points +  
                '}';  
    }

	
    
}