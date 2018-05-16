package hello;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashMap;
import java.util.Map;

@Component
@SessionScope
public class Cart {
    private Map<Integer, Integer> itemsInCart;

    public Cart() {
        itemsInCart = new HashMap<>();
    }

    public Map<Integer, Integer> getItemsInCart() {
        return itemsInCart;
    }

    public Map<Integer, Integer> removeItemFromCart(int id) {
        if(itemsInCart.containsKey(id))
            itemsInCart.remove(id);

        return itemsInCart;
    }

    public Map<Integer, Integer> addItemToCart(int id, int quantity) {
        itemsInCart.put(id, quantity);
        return itemsInCart;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "itemsInCart=" + itemsInCart +
                '}';
    }
}
