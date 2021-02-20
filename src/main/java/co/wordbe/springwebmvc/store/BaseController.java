package co.wordbe.springwebmvc.store;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice(assignableTypes = {NewsController.class, RefNewsApi.class})
public class BaseController {

    @ExceptionHandler
    public String newsErrorHandler(NewsException newsException, Model model) {
        model.addAttribute("message", "news error");
        return "/news/error";
    }

    // ResponseEntity 사용하는 것을 추천 (REST API 에서 응답코드와 응답본문 명시)
//    @ExceptionHandler
//    public ResponseEntity<String> newsResponseEntityErrorHandler(NewsException newsException) {
//        return ResponseEntity.badRequest().body("error message example");
//    }

    @InitBinder
    public void initNewsBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
        webDataBinder.addValidators(new NewsValidator());
    }
}
