package org.wcci.blog.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.wcci.blog.models.Author;
import org.wcci.blog.models.Genre;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.repositories.PostRepository;

import java.awt.print.Book;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class PostStorageJpaImplTest {
    private PostRepository postRepo;
    private PostStorage underTest;
    private Post testPost;

    @BeforeEach
    void setUp() {
        postRepo = mock(PostRepository.class);
        underTest = new PostStorageJpaImpl(postRepo);
        Genre testGenre = new Genre("Test");
        Author testAuthor = new Author("Test");
        testPost = new Post("Test Post", "Test Description", testGenre, testAuthor);

    }
    @Test
    public void shouldFindPostById() {
        when(postRepo.findById(1L)).thenReturn(Optional.of(testPost));
        Post retrievedPost = underTest.findPostById(1L);
        assertThat(retrievedPost).isEqualTo(testPost);
    }
    @Test
    public void shouldStorePost() {
        underTest.store(testPost);
        verify(postRepo).save(testPost);
    }
}
