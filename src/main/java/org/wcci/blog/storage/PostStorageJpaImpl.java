package org.wcci.blog.storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.repositories.PostRepository;

import java.awt.print.Book;
import java.util.Collection;

@Service
public class PostStorageJpaImpl implements PostStorage {
    private  PostRepository postRepository;

    public PostStorageJpaImpl(PostRepository postRepository) {

        this.postRepository = postRepository;
    }

    @Override
    public Post findPostById(Long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public Post findPostById(long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public void store(Post postToStore) {
        postRepository.save(postToStore);
    }

    @Override
    public Collection<Post> getAll() {
        return (Collection<Post>) postRepository.findAll();
    }


}
