package co.wordbe.springwebmvc.store;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
public class BookPostPutController {

    @PostMapping(value = "/books")
    @ResponseBody
    public String createBook() {
        return "create book";
    }

    @PutMapping(value = "/books")
    @ResponseBody
    public String putBook() {
        return "put book";
    }
}
