package co.wordbe.springwebmvc.springmvc;

import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/message")
    public String message(@RequestBody String body) {
        return body;
    }

    @GetMapping("/jsonMessage")
    public Person jsonMessage(@RequestBody Person person) {
        return person;
    }

    @GetMapping("/xmlMessage")
    public Person xmlMessage(@RequestBody Person person) {
        return person;
    }
}
