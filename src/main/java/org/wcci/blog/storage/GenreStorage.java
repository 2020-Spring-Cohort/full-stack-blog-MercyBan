package org.wcci.blog.storage;

import org.wcci.blog.models.Genre;

import java.util.Collection;

public interface GenreStorage {

    public Collection<Genre> findAllGenres();

    public void store (Genre genre);


    public Genre findGenreByType(String genreType);
}
