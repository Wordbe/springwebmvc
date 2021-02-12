package co.wordbe.springwebmvc.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping("/events")
    @ResponseBody
    public String events(Model model) {
        model.addAttribute("events", eventService.getEvents());
        return "events";
    }

    @GetMapping("/sample")
    public String sample() {
        return "/home/sample";
    }
}
