package org.wcci.blog.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.wcci.blog.controllers.PostController;
import org.wcci.blog.models.Author;
import org.wcci.blog.models.Genre;
import org.wcci.blog.models.Hashtag;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.PostStorage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

public class PostControllerTest {
    private PostController underTest;
    private Model model;
    private PostStorage mockStorage;
    private Post testPost;

    @BeforeEach
    void setUp() {
        mockStorage = mock(PostStorage.class);
        underTest = new PostController(mockStorage);
        model = mock(Model.class);
        Genre testGenre = new Genre("Music");
        Author testAuthor = new Author("Test");
        Hashtag testHashtag = new Hashtag("Test");
        testPost = new Post("Latest Music", "Test Description", testGenre, testAuthor);
        when(mockStorage.findPostById(1L)).thenReturn(testPost);

    }

    @Test
    public void displayPostReturnsPostTemplate() {
        String result = underTest.displayPost(1L, model);
        assertThat(result).isEqualTo("post-view");

    }
    @Test
    public void displayPostInteractsWithDependenciesCorrectly() {

        underTest.displayPost(1L, model);
        verify(mockStorage).findPostById(1L);
        verify(model).addAttribute("post", testPost);
    }
//    @Test
//    public void displayPostMappingIsCorrect() throws Exception {
//        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
//        mockMvc.perform(MockMvcRequestBuilders.get("/posts/1"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("post-view"))
//                .andExpect(model().attributeExists("post"))
//                .andExpect(model().attribute("book", testPost));
//    }
}
