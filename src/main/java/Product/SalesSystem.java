package Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

interface Sellable {
    String getCode();
    String getName();
    double getPrice();
}

class aProduct implements Sellable {
    private String code;
    private String name;
    private double price;

    public aProduct(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

class aOrder {
    private List<OrderItem> items = new ArrayList<>();

    public void addProduct(String string, int string2,String string3) {
        items.add(new OrderItem(string, string2, string3));
    }

    public void removeProduct(String code) {
        items.removeIf(item -> item.getProduct().getClass().equals(code));
    }

    @Override
    public String toString() {
        return "Order{" +
                "items=" + items +
                '}';
    }
}

class OrderItem  extends Product{
    private static double price;
	private static String description;
	private String product;
    private int quantity;

    public OrderItem(String string, int string2,String code) {
    	super(code, description, price);
        this.product = string;
        this.quantity = string2;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }

	public static Iterator<OrderedItem> getItemsIterator(List<OrderedItem> items) {  
        // 检查传入的items是否为null  
        if (items != null) {  
            // 返回items的迭代器  
            return items.iterator();  
        } else {  
            // 如果items为null，可以抛出一个异常或者返回一个空的迭代器  
            // 这里为了简单起见，返回一个空的迭代器  
            return new ArrayList<OrderedItem>().iterator();  
        }  
    }
}

public class SalesSystem {
    private List<aOrder> sales = new ArrayList<>();
    private aOrder currentAOrder = new aOrder();

    public void displayCatalog(List<String> catalog) {
        for (String sellable : catalog) {
            System.out.println(sellable);
        }
    }

    public void displayProduct(Sellable sellable) {
        System.out.println(sellable);
    }

    public void displayCurrentOrder() {
        System.out.println(currentAOrder);
    }

    public void addSellableToOrder(String string, int string2,String string3) {
        currentAOrder.addProduct(string, string2, string3);
    }

    public void removeProductFromOrder(String code) {
        currentAOrder.removeProduct(code);
    }

    public void registerSale() {
        sales.add(currentAOrder);
        currentAOrder = new aOrder(); // Reset current order
    }

    public void displaySales() {
        for (aOrder aOrder : sales) {
            System.out.println(aOrder);
        }
    }
}
