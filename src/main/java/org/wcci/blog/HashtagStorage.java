package org.wcci.blog;

public interface HashtagStorage {

    void store(Hashtag hashtagToStore);
    Hashtag findHashtagById(Long id);
}
