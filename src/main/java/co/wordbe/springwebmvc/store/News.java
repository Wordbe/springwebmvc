package co.wordbe.springwebmvc.store;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class News {
    private Integer id;
    private String title;
    private Integer limit;
}
