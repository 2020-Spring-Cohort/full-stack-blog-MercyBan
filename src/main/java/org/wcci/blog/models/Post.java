package org.wcci.blog.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String postBody;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Genre genre;

    private Date publishDate;
    @ManyToMany
    private Collection<Hashtag> hashtags;
    @OneToMany
    private Collection<Author> authors;

    public Post( String title, String postBody, Genre genre, Author author) {

        this.title = title;
        this.postBody = postBody;
        this.author = author;
        this.genre = genre;
    }

    public Post( String title, String postBody, Genre genre, Author author, Collection<Hashtag> hashtags) {

        this.title = title;
        this.postBody = postBody;
        this.author = author;
        this.genre = genre;
        this.hashtags = hashtags;
    }

    public Post (){
    }

    public Collection<Author> getAuthors() {
        return authors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, postBody, author, genre);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return Objects.equals(title, post.title) &&
                Objects.equals(postBody, post.postBody) &&
                Objects.equals(author, post.author) &&
                Objects.equals(genre, post.genre);


    }

    public String getTitle() {
        return title;
    }

    public String getPostBody() {
        return postBody;
    }

    public Author getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public Collection<Hashtag> getHashtags() {
        return hashtags;
    }

    public Long getId() {
        return id;
    }
}
