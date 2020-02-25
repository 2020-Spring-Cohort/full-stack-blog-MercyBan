package org.wcci.blog.integration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.wcci.blog.storage.GenreStorage;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


    @ExtendWith(SpringExtension.class)
    @WebMvcTest
    public class WebLayerTest {

        @Autowired
        private MockMvc mockMvc;
        @MockBean
        GenreStorage mockStorage;
        @Test
        public void postShouldBeOKAndReturnThePostViewWithTheViewModelAttribute() throws Exception {

            mockMvc.perform(get("/Genres"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(view().name("genresView"))
                    .andExpect(model().attributeExists("genres"));

        }

}
