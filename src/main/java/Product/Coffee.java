package Product;

public class Coffee extends Product {

    private String acidity;

    private String aroma;

    private String body;

    private String OriginCountry;

    private String TypeofRoast;

    private String flavor;

    // 其他特定于咖啡或冲泡机的属性可以在子类中定义

    public Coffee(String code, String description, double price, String acidity, String aroma, String OriginCountry,
                  String body, String TypeofRoast, String flavor) {
        super(code,description, price);


        this.acidity = acidity;

        this.aroma = aroma;

        this.body = body;

        this.OriginCountry = OriginCountry;

        this.TypeofRoast = TypeofRoast;

        this.flavor = flavor;

    }

    // Getter 和 Setter 方法

    public String getCode() {
        return super.getCode();

    }

    public void setCode(String code) {
        super.setCode(code);
    }

    public String getDescription() {
        return super.getDescription();
    }

    public void setDescription(String description) {
        super.setDescription(description);
    }

    public double getPrice() {
        return super.getPrice();
    }

    public void setPrice(double price) {
        super.setPrice(price);
    }

    public void getOriginCountry(String OriginCountry) {

        this.OriginCountry = OriginCountry;

    }

    public void getTypeofRoast(String TypeofRoast) {

        this.TypeofRoast = TypeofRoast;

    }

    public void getFlavor(String flavor) {

        this.flavor = flavor;

    }

    public void getAroma(String aroma) {
        this.aroma = aroma;
    }

    public void getAcidity(String acidity) {
        this.acidity = acidity;
    }

    public void getBody(String body) {
        this.body = body;
    }

    // toString 方法用于打印产品信息

    @Override

    public String toString() {

        return "Product{" +

                "code='" + super.getCode() + '\'' +

                ", description='" + super.getDescription() + '\'' +

                ", price=" + super.getPrice() +

                ", Country of origin=" + OriginCountry + ", acidity:" + acidity + "' aroma:" + aroma + ",body:" + body
                + ",OriginCountry:" + OriginCountry + ",Type of Roast:" + TypeofRoast + ",flavor:" + flavor + '}';

    }

}