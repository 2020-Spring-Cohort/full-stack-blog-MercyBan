package org.wcci.blog.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.wcci.blog.storage.repositories.AuthorRepository;
import org.wcci.blog.storage.repositories.GenreRepository;
import org.wcci.blog.storage.repositories.PostRepository;

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

}
