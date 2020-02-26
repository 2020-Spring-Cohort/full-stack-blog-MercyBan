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

//    @Test
//    public void shouldRetrieveSingleGenreByLocation() {
//        GenreRepository mockCampusRepo = mock(GenreRepository.class);
//        Genre testGenre = new Genre("Test Town");
//        Genre testGenre2 = new Genre("Testville");
//        GenreStorage underTest = new GenreStorageJpaImpl(mockCampusRepo);
//        underTest.store(testCampus1);
//        underTest.store(testCampus2);
//        Optional<Campus> testCampus1Optional = Optional.of(testCampus1);
//        when(mockCampusRepo.findByLocation("Test Town")).thenReturn(testCampus1Optional);
//
//        Optional<Campus> testCampus2Optional = Optional.of(testCampus2);
//        when(mockCampusRepo.findByLocation("Testville")).thenReturn(testCampus2Optional);
//
//        Campus retrievedCampus1 = underTest.findCampusByLocation("Test Town");
//        Campus retrievedCampus2 = underTest.findCampusByLocation("Testville");
//        assertThat(retrievedCampus1).isEqualTo(testCampus1);
//        assertThat(retrievedCampus2).isEqualTo(testCampus2);
    }
