package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ApiControllerRest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Resource
    private Cart cart;


    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/items")
    public String postItems(@RequestBody List<Item> items) {
        for(Item item : items) {
            itemRepository.saveAndFlush(item);
        }
        return "items";
    }

    @GetMapping("/cart")
    public String getCart() {
        return cart.toString();
    }

    @GetMapping("/items")
    public String getItems() {
        return itemRepository.findAll().toString();
    }

    @PostMapping("/cart")
    public String addToCart(@RequestBody CartItem cartItem) {
        cart.addItemToCart(cartItem.getId(), cartItem.getQuantity());
        return cart.toString();
    }

    @PostMapping(/cart/remove)

    @PostMapping(path = "/register")
    public HttpStatus register(@RequestBody AuthReq authReq) {
        if(userRepository.findByUsername(authReq.getUser()) == null) {
            User user = new User(authReq.getUser(), BCrypt.hashpw(authReq.getPassword(),BCrypt.gensalt()));
            userRepository.saveAndFlush(user);
            return HttpStatus.OK;
        }
        else return HttpStatus.CONFLICT;
    }

    @GetMapping(path = "/login/session")
    public String getSession() {
        return new UserSession(RequestContextHolder.currentRequestAttributes().getSessionId()).toString();
    }
}
