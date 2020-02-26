package org.wcci.blog.storage;

import org.wcci.blog.models.Hashtag;

import java.util.Collection;

public interface HashtagStorage {

    void store(Hashtag hashtagToStore);

    Hashtag findHashtagById(Long id);

    Collection<Hashtag> findAllHashtags();
}
