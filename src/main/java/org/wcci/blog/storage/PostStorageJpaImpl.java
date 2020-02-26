package org.wcci.blog.storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.repositories.PostRepository;

import java.awt.print.Book;

@Service
public class PostStorageJpaImpl implements PostStorage {
    private  PostRepository postRepository;

    public PostStorageJpaImpl(PostRepository postRepository) {

        this.postRepository = postRepository;
    }

    @Override
    public Post findPostById(long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public void store(Post postToStore) {
        postRepository.save(postToStore);
    }


}
