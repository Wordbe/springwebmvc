package co.wordbe.springwebmvc.store;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
public class BookController {

    @GetBookMapping
    @ResponseBody
    public String bookStore() {
        return "Welcome book store";
    }

    @GetMapping("/books")
    @ResponseBody
    public String books() {
        return "books";
    }

    @GetMapping("/books/{id}")
    @ResponseBody
    public String books(@PathVariable int id) {
        return "books " + id;
    }



    @DeleteMapping("/books/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable int id) {
        return "delete book " + id;
    }
}
