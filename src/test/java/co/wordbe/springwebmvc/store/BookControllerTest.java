package co.wordbe.springwebmvc.store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class BookControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void bookStoreTest() throws Exception {
        mockMvc.perform(get("/bookstore"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(handler().handlerType(BookController.class))
                .andExpect(handler().methodName("bookStore"))
        ;
    }
}