package mongo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class MongoController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}