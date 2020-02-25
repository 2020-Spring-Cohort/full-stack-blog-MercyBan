package org.wcci.blog.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity
public class Post {
    private String title;
    private String postBody;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Genre genre;
    @Id
    @GeneratedValue
    private Date publishDate;
    @ManyToMany
    private Collection<Hashtag> hashtags;

    public Post( String title, String postBody, Genre genre, Author author) {

        this.title = title;
        this.postBody = postBody;
        this.author = author;
        this.genre = genre;
    }
    public Post (){
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

}
