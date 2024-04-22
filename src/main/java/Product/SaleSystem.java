package Product;

import java.util.ArrayList;
import java.util.List;

interface Sellable {
    String getCode();
    String getName();
    double getPrice();
}

class Product implements Sellable {
    private String code;
    private String name;
    private double price;

    public Product(String code, String name, double price) {
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

class Order {
    private List<OrderItem> items = new ArrayList<>();

    public void addProduct(Sellable sellable, int quantity) {
        items.add(new OrderItem(sellable, quantity));
    }

    public void removeProduct(String code) {
        items.removeIf(item -> item.getProduct().getCode().equals(code));
    }

    @Override
    public String toString() {
        return "Order{" +
                "items=" + items +
                '}';
    }
}

class OrderItem {
    private Sellable product;
    private int quantity;

    public OrderItem(Sellable product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Sellable getProduct() {
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
}

public class SalesSystem {
    private List<Order> sales = new ArrayList<>();
    private Order currentOrder = new Order();

    public void displayCatalog(List<Sellable> catalog) {
        for (Sellable sellable : catalog) {
            System.out.println(sellable);
        }
    }

    public void displayProduct(Sellable sellable) {
        System.out.println(sellable);
    }

    public void displayCurrentOrder() {
        System.out.println(currentOrder);
    }

    public void addSellableToOrder(Sellable sellable, int quantity) {
        currentOrder.addProduct(sellable, quantity);
    }

    public void removeProductFromOrder(String code) {
        currentOrder.removeProduct(code);
    }

    public void registerSale() {
        sales.add(currentOrder);
        currentOrder = new Order(); // Reset current order
    }

    public void displaySales() {
        for (Order order : sales) {
            System.out.println(order);
        }
    }
}