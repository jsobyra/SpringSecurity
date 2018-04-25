package hello;

import org.springframework.web.bind.annotation.*;

import java.util.logging.LogManager;
import java.util.logging.Logger;


@RestController
public class ApiController {
    private static Logger logger = Logger.getLogger(ApiController.class.toString());

    @RequestMapping("/home")
    public String root() {
        logger.info("homeLogger");
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index() {
        logger.info("indexLogger");
        return "index";
    }

    @RequestMapping("/user/index")
    public String userIndex() {
        return "user/index";
    }

    @RequestMapping(path = "/login")
    public String login() {
        logger.info("DUPA");
        return "login";
    }
}
