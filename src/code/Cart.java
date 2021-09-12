package code;

public class Cart {

    // Variable
    public String product_id,product_qty;
    public  String product_name;
    public  String category,description;
    public String price;

    // Constructor
    public Cart(String product_id, String product_qty, String product_name, String category, String description, String price) {
        this.product_id = product_id;
        this.product_qty = product_qty;
        this.product_name = product_name;
        this.category = category;
        this.description = description;
        this.price = price;
    }


    // GETTERS and SETTERS for variables

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_qty() {
        return product_qty;
    }

    public void setProduct_qty(String product_qty) {
        this.product_qty = product_qty;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
