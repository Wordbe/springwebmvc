package co.wordbe.springwebmvc.store;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NewsController {

    @GetMapping("/news/{id}")
    @ResponseBody
    public News news(@PathVariable Integer id, @MatrixVariable String title) {
        News news = new News();
        news.setId(id);
        news.setTitle(title);
        return news;
    }
}
