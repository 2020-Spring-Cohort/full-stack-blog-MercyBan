package org.wcci.blog.storage;

import org.junit.jupiter.api.Test;
import org.wcci.blog.models.Genre;
import org.wcci.blog.storage.repositories.GenreRepository;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class GenreStorageJpaImplTest {

    @Test
    public void shouldFindAllGenres() {
        GenreRepository mockGenreRepo = mock(GenreRepository.class);
        Genre testGenre = new Genre("Test");
        GenreStorage underTest = new GenreStorageJpaImpl(mockGenreRepo);
        when(mockGenreRepo.findAll()).thenReturn(Collections.singletonList(testGenre));
        underTest.store(testGenre);
        verify(mockGenreRepo).save(testGenre);
        assertThat(underTest.findAllGenres()).contains(testGenre);
    }
    }
