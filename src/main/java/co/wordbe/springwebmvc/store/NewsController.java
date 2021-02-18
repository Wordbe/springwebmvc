package co.wordbe.springwebmvc.store;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

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
    public String news(@Validated @ModelAttribute News news,
                       BindingResult bindingResult,
                       Model model) {
        if (bindingResult.hasErrors()) {
            return "/news/form";
        }

        List<News> newsList = new ArrayList<>();
        newsList.add(news);
        model.addAttribute("newsList", newsList);

        return "redirect:/news/list";
    }

    @GetMapping("/news/list")
    public String getNews(Model model) {
        // DB 에서 읽어온 데이터 (테스트용으로 일단 만듬)
        News news = new News();
        news.setTitle("wordtory");
        news.setLimit(10);

        List<News> newsList = new ArrayList<>();
        newsList.add(news);

        model.addAttribute(newsList);
        return "/news/list";
    }
}
