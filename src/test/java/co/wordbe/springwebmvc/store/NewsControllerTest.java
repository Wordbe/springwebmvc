package co.wordbe.springwebmvc.store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class NewsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getNews() throws Exception {
        mockMvc.perform(get("/news/1;title=today"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("title").value("today"))
                ;
    }

    @Test
    public void postNews() throws Exception {
        ResultActions result = mockMvc.perform(post("/news")
                .param("title", "blue")
                .param("limit", "-10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().hasErrors());

        ModelAndView mav = result.andReturn().getModelAndView();
        Map<String, Object> model = mav.getModel();
        System.out.println(model.size());
    }

    @Test
    public void newsForm() throws Exception {
        MockHttpServletRequest request = mockMvc.perform(get("/news/form"))
                .andDo(print())
                .andExpect(view().name("/news/form"))
                .andExpect(model().attributeExists("news"))
                .andExpect(request().sessionAttribute("news", notNullValue()))
                .andReturn().getRequest();
        Object news = request.getSession().getAttribute("news");
        System.out.println(news);
    }
}