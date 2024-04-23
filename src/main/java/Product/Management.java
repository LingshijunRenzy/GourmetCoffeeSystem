package Product;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

/**
 * This class implements a library system.
 *
 * @version 1.1.0
 * @see Catalog
 * @see CatalogItem
 * @see aProduct
 * @see Coffee
 * @see CustomerDatabase
 * @see Customer
 * @see OrderedItem
 */

public class Management {

	private static Map<OrderedItem, Double> totalSalesPerProduct;
	private static BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	private static PrintWriter stdOut = new PrintWriter(System.out, true);
	private static PrintWriter stdErr = new PrintWriter(System.err, true);
	Scanner scanner = new Scanner(System.in);
	private static Catalog catalog;
	private static ProductDatabase productDB;
	private static CustomerDatabase customerDB;
	private OrderedItem[] orderedItem;

	private static void loadProductDB(){
		productDB = new ProductDatabase();
		productDB.addProduct(new Product("B001", "酱香拿铁", 30));
		productDB.addProduct(new Product("B002", "美式咖啡", 10));
		productDB.addProduct(new Product("B003", "茉莉拿铁", 18));
		productDB.addProduct(new Product("B004", "生椰拿铁", 18));
		productDB.addProduct(new Product("B005", "椰皇拿铁", 20));
		productDB.addProduct(new Product("B006", "丝绒拿铁", 20));
		productDB.addProduct(new Product("B007", "黑糖拿铁", 21));
		productDB.addProduct(new Product("B008", "香草拿铁", 20));
		productDB.addProduct(new Product("B009", "生酪拿铁", 23));
		productDB.addProduct(new Product("B010", "厚乳拿铁", 21));
		productDB.addProduct(new Product("B011", "巧克力拿铁", 21));
		productDB.addProduct(new Product("B012", "巧克力瑞纳冰", 22));
		productDB.addProduct(new Product("B013", "抹茶瑞纳冰", 22));
		productDB.addProduct(new Product("B014", "焦糖玛奇朵", 20));
	}
	/*
	 * Loads the information of a Catalog object.
	 */
	private static void loadCatalog() {
		catalog.addItem(new CatalogItem(productDB.getProduct("B001"), 252));
		catalog.addItem(new CatalogItem(productDB.getProduct("B002"), 252));
		catalog.addItem(new CatalogItem(productDB.getProduct("B003"), 252));
		catalog.addItem(new CatalogItem(productDB.getProduct("B004"), 252));
		catalog.addItem(new CatalogItem(productDB.getProduct("B005"), 252));
		catalog.addItem(new CatalogItem(productDB.getProduct("B006"), 252));
		catalog.addItem(new CatalogItem(productDB.getProduct("B007"), 252));
		catalog.addItem(new CatalogItem(productDB.getProduct("B008"), 252));
		catalog.addItem(new CatalogItem(productDB.getProduct("B009"), 252));
		catalog.addItem(new CatalogItem(productDB.getProduct("B010"), 252));
		catalog.addItem(new CatalogItem(productDB.getProduct("B011"), 252));
		catalog.addItem(new CatalogItem(productDB.getProduct("B012"), 252));
		catalog.addItem(new CatalogItem(productDB.getProduct("B013"), 252));
		catalog.addItem(new CatalogItem(productDB.getProduct("B014"), 252));
	}

	/*
	 * Loads a CustomerDatabase object.
	 */
	private static void loadCustomerDB(Catalog catalog) {

		customerDB = new CustomerDatabase();

		//James Addy
		customerDB.addCustomer(new Customer("ID001", "James Addy", 0));
		customerDB.getCustomer("ID001").buy(productDB.getProduct("B001"), 2);
		customerDB.getCustomer("ID001").buy(productDB.getProduct("B003"), 1);
		customerDB.getCustomer("ID001").buy(productDB.getProduct("B005"), 1);

		//John Doust
		customerDB.addCustomer(new Customer("ID002", "John Doust", 0));

		//Constance Foster
		customerDB.addCustomer(new Customer("ID003", "Constance Foster", 0));
		customerDB.getCustomer("ID003").buy(productDB.getProduct("B002"), 1);

		//Harold Gurske
		customerDB.addCustomer(new Customer("ID004", "Harold Gurske", 0));
		customerDB.getCustomer("ID004").buy(productDB.getProduct("B002"), 1);

		//Mary A. Rogers
		customerDB.addCustomer(new Customer("ID005", "Mary A. Rogers", 0));

		//Laura Novelle
		customerDB.addCustomer(new Customer("ID006", "Laura Novelle", 0));
		customerDB.getCustomer("ID006").buy(productDB.getProduct("B007"), 1);
		customerDB.getCustomer("ID006").buy(productDB.getProduct("B009"), 1);

		//David M. Prescott
		customerDB.addCustomer(new Customer("ID007", "David M. Prescott", 0));
		customerDB.getCustomer("ID007").buy(productDB.getProduct("B011"), 1);

		//Francis Matthews
		customerDB.addCustomer(new Customer("ID008", "Francis Matthews", 0));
		customerDB.getCustomer("ID008").buy(productDB.getProduct("B003"), 1);
		customerDB.getCustomer("ID008").buy(productDB.getProduct("B005"), 1);

		//Thomas Ferris
		customerDB.addCustomer(new Customer("ID009", "Thomas Ferris", 0));

		//John Johnson
		customerDB.addCustomer(new Customer("ID010", "John Johnson", 0));
		customerDB.getCustomer("ID010").buy(productDB.getProduct("B004"), 1);

	}

	/*
	 * Constructs a <code>SaleSystem</code> object. Initialize the catalog and the
	 * customer database with the values specified in the parameters.
	 */

	/*
	 * Presents the user with a menu of options and processes the selection.
	 */
	private void run() throws IOException {

		int choice = getChoice();

		while (choice != 0) {

			if (choice == 1) {
				displayCatalog();
			} else if (choice == 2) {
				displayCatalogItem();
			} else if (choice == 3) {
				displayCustomer();
			} else if (choice == 4) {
				addProductToOrder();
			} else if (choice == 5) {
				removeProductFromOrder();
			} else if (choice == 6) {
				registerSale();
			} else if (choice == 7) {
				displaySales();
			} else if (choice == 8) {
				displayOrderCountForProduct(stdIn.readLine());// 显示具有特定产品的订单数量,需要传递产品ID给commander
			} else if (choice == 9) {
				displayTotalSalesPerProduct();// 显示每个产品的总销售数量，需要commander处理

			} else if (choice == 0) {
				System.out.println("程序已退出。");
				break;
			} else {
				System.out.println("无效输入，请重新输入。");
			}

			choice = getChoice();
		}
	}

	private void addProductToOrder() {
		// TODO Auto-generated method stub

	}

	private void removeProductFromOrder() {
		// TODO Auto-generated method stub

	}

	private void registerSale() {
		// TODO Auto-generated method stub

	}

	private void displaySales() {
		if (customerDB.getNumberOfCustomers() == 0) {
			stdErr.println("The database of customers is empty");
		} else {
			for (Iterator<Customer> i = customerDB.getCustomersIterator(); i.hasNext();) {

				Customer customer = (Customer) i.next();

				stdOut.println(customer.getId() + " " + customer.getName());
			}
		}
	}

	private void displayOrderCountForProduct(String code) {
		//TODO bug to be fixed
		CatalogItem product = null;
		try {
			product = readProduct();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (product != null) {
			stdOut.println("  Name: " + product.getDescription());

			if (OrderedItem.getNumberOfItems() == 0) {
				stdOut.println("  No items ordered");
			} else {
				stdOut.println("  Items Ordered:");
				for (Iterator<OrderedItem> i = (Iterator<OrderedItem>) OrderedItem.getItemsIterator(); i
						.hasNext();) {

					OrderedItem item = i.next();

					stdOut.println("    " + item.getCode() + " " + item.getDescription());
				}
			}
		} else {
			stdErr.println("There is no borrower with that id");
		}
	}

	private CatalogItem readProduct() throws IOException {
		stdOut.print("Product id> ");
		stdOut.flush();

		return this.catalog.getProduct(stdIn.readLine());
	}



	/*
	 * Displays the number of orders with a specific product.
	 */
	private void displayTotalSalesPerProduct() throws IOException {
		//TODO bug to be fixed
		// 遍历 orderedItems 中的每个 OrderedItem 对象
		for (OrderedItem orderedItem : orderedItem) {
			// 获取当前产品的ID
			OrderedItem productId = (OrderedItem) orderedItem.getCode();
			int quantity = orderedItem.getQuantity(); // 获取数量
			double pricePerUnit = orderedItem.getPrice(); // 获取单价

			// 计算当前产品的总销售额，并更新到 map 中
			double totalSalesForThisProduct = totalSalesPerProduct.getOrDefault(productId, 0.0);
			double newTotalSales = totalSalesForThisProduct + (quantity * pricePerUnit);
			totalSalesPerProduct.put(productId, newTotalSales);
		}

		// 显示每个产品的总销售额
		for (Entry<OrderedItem, Double> entry : totalSalesPerProduct.entrySet()) {
			stdOut.println("Product ID: " + entry.getKey() + ", Total Sales: $" + entry.getValue());
		}
	}

	/* Validates the user's choice. */

	private int getChoice() throws IOException {
		int input;

		do {
			try {
				stdOut.println();
				stdOut.print("[0] Quit\r\n" + "[1] Display catalog\r\n" + "[2] Display product \r\n"
						+ "[3] Display current order\r\n" + "[4] Add product to current order\r\n"
						+ "[5] Remove product from current order \r\n" + "[6] Register sale of current order\r\n"
						+ "[7] Display sales\r\n" + "[8] Display number of orders with a specific product\r\n"
						+ "[9] Display the total quantity sold for each product\r\n");

				stdOut.flush();

				input = Integer.parseInt(stdIn.readLine());

				// stdErr.println();

				if (0 <= input && 6 >= input) {
					break;
				} else {
					stdErr.println("Invalid choice:  " + input);
				}
			} catch (NumberFormatException nfe) {
				stdErr.println(nfe);
			}
		} while (true);

		return input;
	}

	/*
	 * Displays the catalog.
	 */
	private void displayCatalog() {

		int numberOfItems = this.catalog.getNumberOfProducts();

		if (numberOfItems == 0) {
			stdErr.println("The catalog is empty");
		} else {
			for (Iterator<CatalogItem> i = catalog.getProductsIterator(); i.hasNext();) {

				CatalogItem item = i.next();

				stdOut.println(
						item.getCode() + " " + item.getDescription() + " " + (item.isAvailable() ? "(A)" : "(NA)"));
			}
		}
	}

	/*
	 * Displays a catalog item.
	 */
	private void displayCatalogItem() throws IOException {

		CatalogItem item = readCatalogItem();

		if (item != null) {
			stdOut.println("Code: " + item.getCode());
			stdOut.println("Description: " + item.getDescription());
			stdOut.println("Price: " + item.getPrice());
			stdOut.println("Quantity: " + item.getQuantity());

			if (item instanceof CatalogItem) {

				stdOut.println("Description： " + item.getDescription());
				stdOut.println("Quantity:  " + item.getQuantity());
			}
			stdOut.println("  Status: " + (item.isAvailable() ? "Available" : "Not available"));
		} else {
			stdErr.println("There is no catalog item with that code");
		}
	}

	/*
	 * Displays the customer database.
	 */
	@SuppressWarnings("unused")
	private void displayCustomerDatabase() {

		if (customerDB.getNumberOfCustomers() == 0) {
			stdErr.println("The database of customers is empty");
		} else {
			for (Iterator<Customer> i = customerDB.getCustomersIterator(); i.hasNext();) {

				Customer customer = (Customer) i.next();

				stdOut.println(customer.getId() + " " + customer.getName());
			}
		}
	}

	/*
	 * Displays a customer.
	 */
	private void displayCustomer() throws IOException {

		Customer customer = readCustomer();

		if (customer != null) {

			stdOut.println("  Name: " + customer.getName());

			if (customer.getNumberOfOrders() == 0) {
				stdOut.println("  No order");
			} else {
				stdOut.println("  Orders:");
				for (Iterator<Order> i = customer.getOrdersIterator(); i.hasNext();) {

					Order order = i.next();

					stdOut.println("    " + order.getOrderID());
					//循环输出订单中的产品
					for (OrderedItem orderedItem : order.getOrderedItems()) {
						stdOut.println("      " + orderedItem.getCode() + " " + orderedItem.getDescription());
					}
				}
			}
		} else {
			stdErr.println("There is no customer with that id");
		}
	}

	/*
	 * Obtains a CatalogItem object.
	 */
	private CatalogItem readCatalogItem() throws IOException {

		stdOut.print("Catalog item code> ");
		stdOut.flush();

		return this.catalog.getItem(stdIn.readLine());
	}

	/*
	 * Obtains a Customer object.
	 */
	private Customer readCustomer() throws IOException {

		stdOut.print("Customer id> ");
		stdOut.flush();

		return this.customerDB.getCustomer((String) stdIn.readLine());
	}
	/**
	 * The main function loads the information of the library catalog and customer
	 * database and starts the managementlication.
	 *
	 * @param args String arguments. Not used.
	 * @throws IOException if there are errors in the input.
	 */
	public static void main(String[] args) throws IOException {
		totalSalesPerProduct = new HashMap<>();
		loadCatalog();
		

		@SuppressWarnings("unused")
		CustomerDatabase customerDB = load(catalog);

		Management management = new Management();

		management.run();

	}
}
