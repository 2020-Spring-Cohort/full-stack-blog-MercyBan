package org.wcci.blog.storage;


import org.wcci.blog.models.Post;

public interface PostStorage {
    Post findPostById(Long id);

    Post findPostById(long id);

    void store(Post postToStore);
}
