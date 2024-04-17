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
 * @see Product
 * @see Coffee
 * @see CustomerDatabase
 * @see Customer
 * @see OrderedItems
 */

public class Management {

    private static Map<OrderedItems, Integer> totalSalesPerProduct;  
  
	private static BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	private static PrintWriter stdOut = new PrintWriter(System.out, true);
	private static PrintWriter stdErr = new PrintWriter(System.err, true);

	private Catalog catalog;
	private CustomerDatabase customerDB;
	/**
	 * The main function loads the information of the library catalog and customer
	 * database and starts the managementlication.
	 *
	 * @param args String arguments. Not used.
	 * @throws IOException if there are errors in the input.
	 */
	public static void main(String[] args) {
		totalSalesPerProduct = new HashMap<>();  
		
		load();
		Management management = new Management();

		management.run();

	}

	/*
	 * Loads the information of a Catalog object.
	 */
	private static Catalog load() {

		Catalog catalog = new Catalog();

		catalog.addItem(new CatalogItem("B001", "Effective Java Programming", 2001, 252));
		catalog.addItem(new CatalogItem("B002", "Effective Java Programming", 2001, 252));
		catalog.addItem(new CatalogItem("B003", "Effective Java Programming", 2001, 252));
		catalog.addItem(new CatalogItem("B004", "Effective Java Programming", 2001, 252));
		catalog.addItem(new CatalogItem("B005", "Effective Java Programming", 2001, 252));
		catalog.addItem(new CatalogItem("B006", "Effective Java Programming", 2001, 252));
		catalog.addItem(new CatalogItem("B007", "Effective Java Programming", 2001, 252));
		catalog.addItem(new CatalogItem("B008", "Effective Java Programming", 2001, 252));
		catalog.addItem(new CatalogItem("B009", "Effective Java Programming", 2001, 252));
		catalog.addItem(new CatalogItem("B010", "Effective Java Programming", 2001, 252));
		catalog.addItem(new CatalogItem("B011", "Effective Java Programming", 2001, 252));
		catalog.addItem(new CatalogItem("B012", "Effective Java Programming", 2001, 252));
		catalog.addItem(new CatalogItem("B013", "Effective Java Programming", 2001, 252));
		catalog.addItem(new CatalogItem("B014", "Effective Java Programming", 2001, 252));

		return catalog;
	}

	/*
	 * Loads a CustomerDatabase object.
	 */
	private static CustomerDatabase load(Catalog catalog) {

		CustomerDatabase customerDB = new CustomerDatabase();

		Customer customer = new Customer("ID001", "James Addy", 0);
		customerDB.addCustomer(customer);
		customer.getOrderedItems().addItem(catalog.getItem("B003"));
		customer.getOrderedItems().addItem(catalog.getItem("R001"));
		customer.getOrderedItems().addItem(catalog.getItem("B012"));

		customer = new Customer("ID002", "John Doust", 0);
		customerDB.addCustomer(customer);

		customer = new Customer("ID003", "Constance Foster", 0);
		customerDB.addCustomer(customer);
		customer.getOrderedItems().addItem(catalog.getItem("B006"));

		customer = new Customer("ID004", "Harold Gurske", 0);
		customerDB.addCustomer(customer);
		customer.getOrderedItems().addItem(catalog.getItem("B002"));

		customer = new Customer("ID005", "Mary A. Rogers", 0);
		customerDB.addCustomer(customer);

		customer = new Customer("ID006", "Laura Novelle", 0);
		customerDB.addCustomer(customer);
		customer.getOrderedItems().addItem(catalog.getItem("B007"));
		customer.getOrderedItems().addItem(catalog.getItem("B009"));

		customer = new Customer("ID007", "David M. Prescott", 0);
		customerDB.addCustomer(customer);
		customer.getOrderedItems().addItem(catalog.getItem("B011"));

		customer = new Customer("ID008", "Francis Matthews", 0);
		customerDB.addCustomer(customer);
		customer.getOrderedItems().addItem(catalog.getItem("R003"));
		customer.getOrderedItems().addItem(catalog.getItem("B005"));

		customer = new Customer("ID009", "Thomas Ferris", 0);
		customerDB.addCustomer(customer);

		customer = new Customer("ID010", "John Johnson", 0);
		customerDB.addCustomer(customer);
		customer.getOrderedItems().addItem(catalog.getItem("B004"));

		return customerDB;
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
		CatalogItem product = readProduct();

		if (product != null) {

			stdOut.println("  Name: " + product.getDescription());

			
			if (OrderedItems.getNumberOfItems() == 0) {
				stdOut.println("  No items ordered");
			} else {
				stdOut.println("  Items Ordered:");
				for (Iterator<OrderedItems> i = (Iterator<OrderedItems>) OrderedItems.getItemsIterator(); i.hasNext();) {

					OrderedItems item = i.next();

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

	private void displayTotalSalesPerProduct() throws IOException {
		// 假设totalSalesPerProduct是一个存储每个产品总销售额的Map  
	    Map<OrderedItems, Integer> totalSalesPerProduct = new HashMap<>();  
	  
	    // 遍历Vector中的每个OrderedItems对象  
	    for (OrderedItems product : OrderedItems) {  
	        // 假设每个OrderedItems对象都有一个getQuantity()方法来获取数量  
	        int quantity = OrderedItems.getQuantity(); // 需要根据实际情况来获取数量  
	        double pricePerUnit = product.getPrice(); // 假设OrderedItems类有一个getPrice方法  
	  
	        // 计算当前产品的总销售额，并更新到map中  
	        int totalSalesForThisProduct = totalSalesPerProduct.getOrDefault(product, 0);  
	        totalSalesPerProduct.put(product, totalSalesForThisProduct + (int)(quantity * pricePerUnit));  
	    }  
	  
	    // 显示每个产品的总销售额  
	    // 注意：这个循环应该在遍历Vector外部执行，以便在收集完所有产品的销售额后一次性显示  
	    for (Entry<OrderedItems, Integer> entry : totalSalesPerProduct.entrySet()) {  
	        // stdOut可能是一个PrintStream对象，用于输出到标准输出流（通常是控制台）  
	        stdOut.println("Product: " + entry.getKey() + ", Total Sales: $" + entry.getValue());  
	    }   
	}

	Scanner scanner = new Scanner(System.in);
//		boolean keepRunning = true;
//
//		while (keepRunning) {
//			clearConsole(); // 清除控制台屏幕
//			printMenu(); // 打印菜单选项
//			System.out.print("choice >");
//			String input = scanner.nextLine(); // 使用nextLine来读取整行输入
//
//			switch (input) {
//			case "1":
//				commander.displayCatalog(); // 显示产品目录
//				break;
//			case "2":
//				commander.displayProductInfo(ProductCatalog.code);
//				// 显示特定产品信息，需要传递产品ID或代码给commander
//				break;
//			case "3":
//				commander.displayCurrentOrder(); // 显示当前订单
//				break;
//			case "4":
//
////                    System.out.println("请输入要添加的产品ID:");  
//				commander.addProductToOrder(scanner.next());// 添加产品到当前订单，需要传递产品ID和数量给commander
//				break;
//			case "5":
//				commander.removeProductFromOrder(scanner.next());// 从当前订单中移除产品，需要传递产品ID给commander
//				break;
//			case "6":
//				commander.registerSale(); // 注册当前订单的销售
//				break;
//			case "7":
//				commander.displaySales(); // 显示所有销售记录
//				break;
//			case "8":
//				commander.displayOrderCountForProduct(scanner.next());// 显示具有特定产品的订单数量,需要传递产品ID给commander
//				break;
//			case "9":
//				commander.displayTotalSalesPerProduct();// 显示每个产品的总销售数量，需要commander处理
//				break;
//			case "0":
//				keepRunning = false; // 设置标志以退出循环
//				System.out.println("程序已退出。");
//				break;
//			default:
//				System.out.println("无效输入，请重新输入。");
//			}
//		}
//
//		// 关闭 Scanner
//		scanner.close();
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

				stdOut.println(item.getCode() + " " + item.getDescription() + " " + (item.isAvailable() ? "(A)" : "(NA)"));
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

			OrderedItems orderedItems = customer.getOrderedItems();

			if (OrderedItems.getNumberOfItems() == 0) {
				stdOut.println("  No items ordered");
			} else {
				stdOut.println("  Items Ordered:");
				for (Iterator<OrderedItems> i = OrderedItems.getItemsIterator(); i.hasNext();) {

					OrderedItems item = (OrderedItems) i.next();

					stdOut.println("    " + item.getCode() + " " + item.getDescription());
				}
			}
		} else {
			stdErr.println("There is no customer with that id");
		}
	}

	/*
	 * Registers the loan of a item to a customer.
	 */
//	@SuppressWarnings("unused")
//	private void checkOut() throws IOException {
//
//		CatalogItem item = readCatalogItem();
//
//		if (item == null) {
//			stdErr.println("There is no catalog item with that code");
//		} else if (item.isAvailable()) {
//
//			Customer customer = readCustomer();
//
//			if (customer == null) {
//				stdErr.println("There is no customer with that id");
//			} else {
//				customer.getOrderedItems().addItem(item);
//				stdOut.println("The item " + item.getCode() + " has been check out by " + customer.getId());
//			}
//		} else {
//			stdErr.println("The item " + item.getCode() + " is not available");
//		}
//	}

	/*
	 * Registers the return of a item.
	 */
//	@SuppressWarnings("unused")
//	private void checkIn() throws IOException {
//
//		CatalogItem item = readCatalogItem();
//
//		if (item == null) {
//			stdErr.println("There is no catalog item with that code");
//		} else if (item.isAvailable()) {
//			stdErr.println("The item " + item.getCode() + " is not ordered");
//		} else {
//
//			Customer customer = readCustomer();
//
//			if (customer == null) {
//				stdErr.println("There is no customer with that id");
//			} else {
//				if (customer.getOrderedItems().removeItem(item)) {
//					;
//					stdOut.println("The item " + item.getCode() + " has been returned");
//				} else {
//					stdErr.println("The item " + item.getCode() + " is not ordered by " + customer.getId());
//				}
//			}
//		}
//	}

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

		return this.customerDB.getCustomer((String)stdIn.readLine());
	}

//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		boolean keepRunning = true;
//
//		while (keepRunning) {
//			clearConsole(); // 清除控制台屏幕
//			printMenu(); // 打印菜单选项
//			System.out.print("choice >");
//			String input = scanner.nextLine(); // 使用nextLine来读取整行输入
//
//			switch (input) {
//			case "1":
//				commander.displayCatalog(); // 显示产品目录
//				break;
//			case "2":
//				commander.displayProductInfo(ProductCatalog.code);
//				// 显示特定产品信息，需要传递产品ID或代码给commander
//				break;
//			case "3":
//				commander.displayCurrentOrder(); // 显示当前订单
//				break;
//			case "4":
//
////                    System.out.println("请输入要添加的产品ID:");  
//				commander.addProductToOrder(scanner.next());// 添加产品到当前订单，需要传递产品ID和数量给commander
//				break;
//			case "5":
//				commander.removeProductFromOrder(scanner.next());// 从当前订单中移除产品，需要传递产品ID给commander
//				break;
//			case "6":
//				commander.registerSale(); // 注册当前订单的销售
//				break;
//			case "7":
//				commander.displaySales(); // 显示所有销售记录
//				break;
//			case "8":
//				commander.displayOrderCountForProduct(scanner.next());// 显示具有特定产品的订单数量,需要传递产品ID给commander
//				break;
//			case "9":
//				commander.displayTotalSalesPerProduct();// 显示每个产品的总销售数量，需要commander处理
//				break;
//			case "0":
//				keepRunning = false; // 设置标志以退出循环
//				System.out.println("程序已退出。");
//				break;
//			default:
//				System.out.println("无效输入，请重新输入。");
//			}
//		}
//
//		// 关闭 Scanner
//		scanner.close();
//	}
//
//	// 清除控制台屏幕的方法（平台相关）
//	private static void clearConsole() {
//		System.out.print("\033[H\033[J");
//		System.out.flush();
//	}
//
//	// 打印菜单选项的方法
//	private static void printMenu() {
//		System.out.println("[0] Quit\r\n" + "[1] Display catalog\r\n" + "[2] Display product \r\n"
//				+ "[3] Display current order\r\n" + "[4] Add product to current order\r\n"
//				+ "[5] Remove product from current order \r\n" + "[6] Register sale of current order\r\n"
//				+ "[7] Display sales\r\n" + "[8] Display number of orders with a specific product\r\n"
//				+ "[9] Display the total quantity sold for each product\r\n");
//	}
}
