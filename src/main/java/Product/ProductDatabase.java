package Product;

import java.util.Vector;

public class ProductDatabase {
    private Vector<Product> products = new Vector<>();

    public ProductDatabase(){}

    /**
     * Adds a product to the database.
     *
     * @param product  the product to add.
     */
    public void addProduct(Product product) {
        products.add(product);
    }


    /**
     * Remove the product with the given code.
     */
    public void removeProduct(String code) {
        products.removeIf(p -> p.getCode().equals(code));
    }

    /**
     * Get the product with the given code.
     */
    public Product getProduct(String code) {
        for (Product p : products) {
            if (p.getCode().equals(code)) {
                return p;
            }
        }
        return null;
    }
}
