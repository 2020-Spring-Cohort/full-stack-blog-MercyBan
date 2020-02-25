package org.wcci.blog.storage;

import org.wcci.blog.models.Hashtag;

public interface HashtagStorage {

    void store(Hashtag hashtagToStore);
    Hashtag findHashtagById(Long id);
}
