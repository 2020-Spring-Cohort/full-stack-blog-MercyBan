package org.wcci.blog.storage;


import org.springframework.stereotype.Service;
import org.wcci.blog.models.Genre;
import org.wcci.blog.storage.repositories.GenreRepository;

import java.util.Collection;

@Service
public class GenreStorageJpaImpl implements GenreStorage {
    private GenreRepository genreRepository;

    public GenreStorageJpaImpl(GenreRepository genreRepository) {

        this.genreRepository = genreRepository;
    }

    @Override
    public Collection<Genre> findAllGenres() {
        return (Collection<Genre>) genreRepository.findAll();
    }

    @Override
    public void store(Genre genre) {

        genreRepository.save(genre);

    }

    @Override
    public Genre findGenreByName(String genreName) {
        return genreRepository.findByType(genreName).get();
    }
}
