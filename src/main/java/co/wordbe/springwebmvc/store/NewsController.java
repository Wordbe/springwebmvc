package co.wordbe.springwebmvc.store;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("news")
public class NewsController {

    @GetMapping("/news/form/title")
    public String newsFormTitle(Model model) {
        model.addAttribute("news", new News());
        return "/news/form-title";
    }

    @PostMapping("/news/form/title")
    public String newsFormTitleSubmit(@Validated @ModelAttribute News news,
                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/news/form-title";
        }
        return "redirect:/news/form/limit";
    }

    @GetMapping("/news/form/limit")
    public String newsFormLimit(@ModelAttribute News news, Model model) {
        model.addAttribute("news", news);
        return "/news/form-limit";
    }

    @PostMapping("/news/form/limit")
    public String newsFormLimitSubmit(@Validated @ModelAttribute News news,
                                      BindingResult bindingResult,
                                      RedirectAttributes attributes) {
        if (bindingResult.hasErrors()) {
            return "/news/form-limit";
        }
        attributes.addFlashAttribute("myRedirectedNews", news);

        return "redirect:/news/list";
    }

    @GetMapping("/news/list")
    public String getNews(Model model,
                          @SessionAttribute LocalDateTime visitTime) {
        System.out.println("visitTime: " + visitTime);

        News myRedirectedNews = (News) model.asMap().get("myRedirectedNews");

        List<News> newsList = new ArrayList<>();
        newsList.add(myRedirectedNews);

        model.addAttribute(newsList);
        return "/news/list";
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
}
