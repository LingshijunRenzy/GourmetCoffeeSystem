package Product;

import java.util.*;

public class Order {
	private final UUID orderID;
	private List<OrderedItem> orderItems = new ArrayList<>();
	@SuppressWarnings("unused")
	private int totalCost;


	/**
	 * Constructs an <code>Order</code> object.
	 */
	public Order() {
		//随机生成订单编号
		this.orderID = UUID.randomUUID();
	}

	/**
	 * Returns the order ID.
	 *
	 * @return  the order ID.
	 */
	public UUID getOrderID() {
		return orderID;
	}

	/**
	 * Adds a product to the order.
	 *
	 * @param product  the product to add.
	 * @param quantity the quantity of the product to add.
	 */
	public void addProduct(Product product, int quantity) {
		boolean found = false;
		for (OrderedItem p : orderItems) {
			if (p.getCode().equals(product.getCode())) {
				// 如果产品已存在，则增加数量
				p.setQuantity(p.getQuantity() + quantity);
				found = true;
				break;
			}
		}
		if (!found) {
			// 如果产品不存在，则添加新产品并设置数量
			orderItems.add(new OrderedItem(product, quantity));
		}
		calculateTotalCost();
	}

	public void removeProduct(String code) {
		orderItems.removeIf(p -> p.getCode().equals(code));
		calculateTotalCost();
	}

	private void calculateTotalCost() {

		totalCost = 0;
		for (OrderedItem p : orderItems) {
			// 假设每个产品的价格是单价乘以数量
			totalCost += p.getPrice() * p.getQuantity();
		}
	}

	public List<OrderedItem> getProducts() {
		return Collections.unmodifiableList(new ArrayList<>(orderItems));
	}

	public double getTotalCost() {
		return totalCost;
	}

	// Placeholder method to get price by code
	@SuppressWarnings("unused")
	private double getPriceByCode(String code) {
		Optional<OrderedItem> productOptional = orderItems.stream().filter(p -> p.getCode().equals(code)).findFirst();

		if (productOptional.isPresent()) {
			return productOptional.get().getPrice();
		} else {
			// 如果未找到产品，可以选择抛出异常、返回null或特定值
			throw new IllegalArgumentException("Product with code " + code + " not found in the order.");
		}
	}


	public List<OrderedItem> getOrderedItems() {
		return orderItems;
	}
}
