package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;

@Controller
public class ApiController {

    @GetMapping("/home")
    public String home() {
        RequestContextHolder.currentRequestAttributes().getSessionId();
        return "home";
    }

    @GetMapping("/")
    public String welcome() {
        System.out.println(RequestContextHolder.currentRequestAttributes().getSessionId());
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
