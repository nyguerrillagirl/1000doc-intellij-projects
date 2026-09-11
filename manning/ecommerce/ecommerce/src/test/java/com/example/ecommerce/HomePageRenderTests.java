package com.example.ecommerce;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class HomePageRenderTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void homePageContainsTitle() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("<title>Cake Factory")));
    }

    @Test
    void homepageRendersAllMustachePartials() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                // Header partial
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Home")))
                // Products partial
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Popular Item")))
                // Footer partial
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Copyright &copy; Cake Factory")));
    }

    /* Uncomment when I actually start to render "real" products
    @Test
    void homepageShowsAtLeastOneProduct() throws Exception {
    mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(content().string(org.hamcrest.Matchers.containsString("Chocolate Cake")));
    }

     */
}
