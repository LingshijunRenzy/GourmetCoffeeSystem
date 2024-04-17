package Product;

import java.util.ArrayList;
import java.util.List;

class SalesSystem {  
    private List<Order> sales = new ArrayList<>();  
    private Order currentOrder = new Order();  
  
    public void displayCatalog(List<Product> catalog) {  
        for (Product product : catalog) {  
            System.out.println(product);  
        }  
    }  
  
    public void displayProduct(Product product) {  
        System.out.println(product);  
    }  
  
    public void displayCurrentOrder() {  
        System.out.println(currentOrder);  
    }  
  
    public void addProductToOrder(Product product, int quantity) {  
        currentOrder.addProduct(product, quantity);  
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
