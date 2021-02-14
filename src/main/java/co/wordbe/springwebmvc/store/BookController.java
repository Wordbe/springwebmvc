package co.wordbe.springwebmvc.store;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {

    @GetMapping(value = "/bookstore.*")
    @ResponseBody
    public String bookStore() {
        return "Welcome book store";
    }
}
