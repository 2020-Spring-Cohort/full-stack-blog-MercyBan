package org.wcci.blog.storage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.models.Hashtag;

public interface HashtagRepository extends CrudRepository<Hashtag, Long> {

}
