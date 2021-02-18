package co.wordbe.springwebmvc.store;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NewsController {

    @GetMapping("/news/form")
    public String newsForm(Model model) {
        News news = new News();
        news.setLimit(10);
        model.addAttribute("news", news);
        return "/news/form";
    }

    @PostMapping("/news")
    @ResponseBody
    public News news(@RequestParam String title,
                     @RequestParam Integer limit) {
        News news = new News();
        news.setTitle(title);
        news.setLimit(limit);
        return news;
    }
}
