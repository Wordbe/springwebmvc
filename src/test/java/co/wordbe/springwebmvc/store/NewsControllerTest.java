package co.wordbe.springwebmvc.store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

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
        mockMvc.perform(post("/news")
                            .param("title", "무제")
                            .param("limit", "20"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("title").value("무제"))
        ;
    }

    @Test
    public void newsForm() throws Exception {
        mockMvc.perform(get("/news/form"))
                .andDo(print())
                .andExpect(view().name("/news/form"))
                .andExpect(model().attributeExists("news"))
                ;
    }
}