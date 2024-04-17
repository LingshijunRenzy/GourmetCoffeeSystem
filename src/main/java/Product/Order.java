package Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Order {
	private List<Product> products = new ArrayList<>();
	@SuppressWarnings("unused")
	private int totalCost;

	public void addProduct(Product product, int quantity) {
		boolean found = false;
		for (Product p : products) {
			if (p.getCode().equals(product.getCode())) {
				// 如果产品已存在，则增加数量
				p.setQuantity(Product.getQuantity() + quantity);
				found = true;
				break;
			}
		}
		if (!found) {
			// 如果产品不存在，则添加新产品并设置数量
			product.setQuantity(quantity);
			products.add(product);
		}
		calculateTotalCost();
	}

	public void removeProduct(String code) {
		products.removeIf(p -> p.getCode().equals(code));
		calculateTotalCost();
	}

	private void calculateTotalCost() {

		totalCost = 0;
		for (Product p : products) {
			// 假设每个产品的价格是单价乘以数量
			totalCost += p.getPrice() * p.getQuantity();
		}
	}

	public List<Product> getProducts() {
		return Collections.unmodifiableList(new ArrayList<>(products));
	}

	public double getTotalCost() {
		return totalCost;
	}

	// Placeholder method to get price by code
	@SuppressWarnings("unused")
	private double getPriceByCode(String code) {
		Optional<Product> productOptional = products.stream().filter(p -> p.getCode().equals(code)).findFirst();

		if (productOptional.isPresent()) {
			return productOptional.get().getPrice();
		} else {
			// 如果未找到产品，可以选择抛出异常、返回null或特定值
			throw new IllegalArgumentException("Product with code " + code + " not found in the order.");
		}
	}

}
