package Product;

public class Product {
    public static String code;

    public String description;

    public double price;

    public int quantity;

    // 其他特定于咖啡或冲泡机的属性可以在子类中定义

    public Product(String code, String description, double price) {

        Product.code = code;

        this.description = description;

        this.price = price;

    }



    // Getter 和 Setter 方法

    public String getCode() {

        return code;

    }



    public void setCode(String code) {

        Product.code = code;

    }



    public String getDescription() {

        return description;

    }

    public void setDescription(String description) {

        this.description = description;

    }



    public double getPrice() {

        return price;

    }



    public void setPrice(double price) {

        this.price = price;

    }

    // toString 方法用于打印产品信息

    @Override

    public String toString() {

        return "Product{" +

                "code='" + code + '\'' +

                ", description='" + description + '\'' +

                ", price=" + price +

                ", quantity=" + quantity +

                '}';

    }



    public void setQuantity(int quantity) {
        // 可以在这里添加一些业务逻辑，比如检查数量是否合法
        this.quantity = quantity;
    }



    public int getQuantity() 
        return this.quantity;
    }
}
