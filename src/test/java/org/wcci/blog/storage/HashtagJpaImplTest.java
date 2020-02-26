package org.wcci.blog.storage;

import org.junit.jupiter.api.Test;
import org.wcci.blog.models.Hashtag;
import org.wcci.blog.storage.repositories.HashtagRepository;
import org.wcci.blog.storage.repositories.HashtagStorageJpaImpl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HashtagJpaImplTest {

    @Test
    public void shouldStoreHashtag(){
        HashtagRepository hashtagRepo = mock(HashtagRepository.class);
        HashtagStorage underTest = new HashtagStorageJpaImpl(hashtagRepo);
        Hashtag testHashtag = new Hashtag("billy");
        underTest.store(testHashtag);
        verify(hashtagRepo).save(testHashtag);

    }


}
