package org.wcci.blog.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.wcci.blog.models.Genre;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.repositories.AuthorRepository;
import org.wcci.blog.storage.repositories.GenreRepository;
import org.wcci.blog.storage.repositories.HashtagRepository;
import org.wcci.blog.storage.repositories.PostRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
@DirtiesContext
@DataJpaTest
public class JpaWiringTest {
    @Autowired
    private GenreRepository genreRepo;
    @Autowired
    private PostRepository postRepo;
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private AuthorRepository authorRepo;
    @Autowired
    private HashtagRepository hashtagRepo;


//    @Test
//    public void genreShouldHaveAListOfPosts() {
//        Genre testGenre = new Genre("Fashion");
//        Post testPost = new Post();
//        genreRepo.save(testGenre);
//        postRepo.save(testPost);
//
//        entityManager.flush();
//        entityManager.clear();
//        Optional<Genre> retrievedGenreOptional = genreRepo.findById(testGenre.getId());
//        Genre retrievedGenre = retrievedGenreOptional.get();
//        Post retrievedPost = postRepo.findById(testPost.getId()).get();
//
//        assertThat(retrievedGenre.getPosts()).contains(testPost);
//
//
//    }
}
