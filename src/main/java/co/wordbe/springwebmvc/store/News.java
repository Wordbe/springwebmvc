package co.wordbe.springwebmvc.store;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter @Setter
public class News {

    private Integer id;

    @NotBlank
    private String title;

    @Min(0)
    private Integer limit;
}
