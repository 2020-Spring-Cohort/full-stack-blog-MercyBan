package org.wcci.blog.storage;

import org.wcci.blog.models.Genre;

import java.util.Collection;

public interface GenreStorage {

    Collection<Genre> findAllGenres();

    void store (Genre genre);


    Genre findGenreByName(String genreName);
}
