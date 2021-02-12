package co.wordbe.springwebmvc.springmvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MvcController {

//    @GetMapping("/mvc/{name}")
//    public String mvc(@PathVariable("name") Person person) {
//        return "mvc, " + person.getName();
//    }

//    @GetMapping("/mvc")
//    public String mvc(@RequestParam("name") Person person) {
//        return "mvc, " + person.getName();
//    }

    @GetMapping("/mvc")
    public String mvc(@RequestParam("id") Person person) {
        return "mvc, " + person.getId();
    }
}
