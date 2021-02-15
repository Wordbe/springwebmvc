package co.wordbe.springwebmvc.store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class BookControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void bookStoreTest() throws Exception {
        mockMvc.perform(get("/book"))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }

    @Test
    public void getBooks() throws Exception {
        mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
        ;
    }

    @Test
    public void getBooksWithId() throws Exception {
        mockMvc.perform(get("/books/1"))
                .andExpect(status().isOk());
        mockMvc.perform(get("/books/2"))
                .andExpect(status().isOk());
        mockMvc.perform(get("/books/3"))
                .andExpect(status().isOk());
    }

    @Test
    public void createBook() throws Exception {
        mockMvc.perform(post("/books")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteBook() throws Exception {
        mockMvc.perform(delete("/books/1"))
                .andExpect(status().isOk());
        mockMvc.perform(delete("/books/2"))
                .andExpect(status().isOk());
        mockMvc.perform(delete("/books/3"))
                .andExpect(status().isOk());
    }

    @Test
    public void putBook() throws Exception {
        mockMvc.perform(put("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}