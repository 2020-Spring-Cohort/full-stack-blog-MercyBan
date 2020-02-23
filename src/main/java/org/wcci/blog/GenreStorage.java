package org.wcci.blog;

import java.util.Collection;

public interface GenreStorage {

    public Collection<Genre> findAllGenres();

    public void store (Genre genre);


    public Genre findGenreByType(String genreType);
}
