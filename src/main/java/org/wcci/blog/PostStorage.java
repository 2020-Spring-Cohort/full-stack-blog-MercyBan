package org.wcci.blog;


public interface PostStorage {
    Post findPostById(Long id);

    void store(Post postToStore);
}
