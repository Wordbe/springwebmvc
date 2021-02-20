package co.wordbe.springwebmvc.store;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class NewsValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return News.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        News news = (News) target;
        if (news.getTitle().contains("emergency")) {
            errors.rejectValue("title", "wrongValue", "No emergency news");
        }
    }
}
