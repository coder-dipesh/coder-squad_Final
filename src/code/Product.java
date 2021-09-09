package code;

public class Product {

    private String product_id;
    private String product_qty;
    private String product_name;
    private String category;
    private String price;
    private String description;

    public Product(String product_id, String product_qty, String product_name, String category, String price, String description) {
        this.product_id = product_id;
        this.product_qty = product_qty;
        this.product_name = product_name;
        this.category = category;
        this.price = price;
        this.description = description;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public String getProduct_qty() {
        return product_qty;
    }

    public void setProduct_qty(String product_qty) {
        this.product_qty = product_qty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
