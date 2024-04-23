package Product;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OrderDataBase {
    private static Map<UUID,Order> orders = new HashMap<>();


    public OrderDataBase(){}


    public static void addOrder(Order order) {
        orders.put(order.getOrderID(), order);
    }


    public static void removeOrder(UUID orderID) {
        orders.remove(orderID);
    }


    public static Order getOrder(UUID orderID) {
        return orders.get(orderID);
    }
}
