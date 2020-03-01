package org.wcci.blog.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Hashtag {

    private String hashtag;
    @Id
    @GeneratedValue
    private Long id;
    @ManyToMany(mappedBy = "hashtags")
    private Collection<Post> posts;

    public Hashtag() {

    }

    public Hashtag(String hashtag) {

        this.hashtag = hashtag;
    }

    public String getHashtag() {
        return hashtag;
    }

    public Long getId() {
        return id;
    }

    public Collection<Post> getPosts() {
        return posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hashtag)) return false;
        Hashtag hashtag1 = (Hashtag) o;
        return Objects.equals(hashtag, hashtag1.hashtag) &&
                Objects.equals(id, hashtag1.id) &&
                Objects.equals(posts, hashtag1.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hashtag, id, posts);
    }
}
