package org.wcci.blog.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.wcci.blog.controllers.PostController;
import org.wcci.blog.models.Author;
import org.wcci.blog.models.Genre;
import org.wcci.blog.models.Hashtag;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.PostStorage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        Author testAuthor = new Author("anything");
        Hashtag testHashtag = new Hashtag("anything");
        testPost = new Post("Latest Music", "Test Description", testGenre, testAuthor);
        when(mockStorage.findPostById(1L)).thenReturn(testPost);

    }

    @Test
    public void displayPostReturnsPostTemplate() {
        String result = underTest.displayPost(1L, model);
        assertThat(result).isEqualTo("post-view");

    }
}
