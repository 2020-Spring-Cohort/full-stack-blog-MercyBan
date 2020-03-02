package org.wcci.blog;

import jdk.jfr.Category;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.blog.models.Author;
import org.wcci.blog.models.Genre;
import org.wcci.blog.models.Hashtag;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.AuthorStorage;
import org.wcci.blog.storage.GenreStorage;
import org.wcci.blog.storage.HashtagStorage;
import org.wcci.blog.storage.PostStorage;

import java.util.Collection;
import java.util.Collections;

@Component
public class Populator implements CommandLineRunner {
    private PostStorage postStorage;
    private GenreStorage genreStorage;
    private AuthorStorage authorStorage;
    private HashtagStorage hashtagStorage;

    public Populator(PostStorage postStorage, GenreStorage genreStorage, AuthorStorage authorStorage, HashtagStorage hashtagStorage) {
        this.postStorage = postStorage;
        this.genreStorage = genreStorage;
        this.authorStorage = authorStorage;
        this.hashtagStorage = hashtagStorage;
    }

    @Override
    public void run(String...args) {
        Author author1 = new Author("Mercy");
        Author author2 = new Author("Mikaila");
//        Author author3 = new Author("Roselyn");


        Genre genre1 = new Genre("Fashion");
        Genre genre2 = new Genre("Cooking");
//        Genre genre3 = new Genre("Travel");


        Hashtag hashtag1 = new Hashtag("HappyLife");
        Hashtag hashtag2 = new Hashtag("FeelingGood");
//        Hashtag hashtag3 = new Hashtag("Friendship");



//        Post post1 = new Post("The first post", "Post body", genre1, author1, Collections.emptyList());
//        Post post2 = new Post("The second post", "Post body", genre2, author2, Collections.emptyList());
//        postStorage.store(post1);
//        postStorage.store(post2);

        hashtagStorage.store(hashtag1);
        hashtagStorage.store(hashtag2);
//        hashtagStorage.store(hashtag3);
        genreStorage.store(genre1);
        genreStorage.store(genre2);
//        genreStorage.store(genre3);
        authorStorage.store(author1);
        authorStorage.store(author2);
//        authorStorage.store(author3);


    }

}


