package hello;

public class CartItem {
    private int id;
    private int quantity;

    public CartItem() {}

    public CartItem(int id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
