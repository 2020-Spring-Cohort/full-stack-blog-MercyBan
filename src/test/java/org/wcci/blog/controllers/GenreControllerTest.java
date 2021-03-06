package org.wcci.blog.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.wcci.blog.models.Genre;
import org.wcci.blog.storage.AuthorStorage;
import org.wcci.blog.storage.GenreStorage;
import org.wcci.blog.storage.PostStorage;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

public class GenreControllerTest {

    private MockMvc mockMvc;
    private GenreController underTest;
    private GenreStorage genreStorage;
    private Model mockModel;
    private PostStorage postStorage;
    private AuthorStorage authorStorage;


    @BeforeEach
    public void setUp() {
        mockModel = mock(Model.class);
        genreStorage = mock(GenreStorage.class);
        underTest = new GenreController(genreStorage);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
    }

    @Test
    public void shouldReturnViewNamedGenreViewWhenDisplaySingleGenreIsCalled() {
        String viewName = underTest.displaySingleGenre(1L, mockModel);
        assertThat(viewName).isEqualTo("genre");
    }

    @Test
    public void shouldGoToIndividualEndPoint() throws Exception {
        Genre testGenre = new Genre("TEST");
        when(genreStorage.findGenreByName("TEST")).thenReturn(testGenre);
        mockMvc.perform(get("/genres/TEST"))
                .andExpect(status().isOk())
                .andExpect(view().name("genre-view"))
                .andExpect(model().attributeExists("genre"))
                .andExpect(model().attribute("genre", testGenre));
    }

    @Test
    public void genresEndPointDisplaysAllGenres() throws Exception {
        Genre testGenre = new Genre("Test");

        List<Genre> genreCollection = Collections.singletonList(testGenre);
        when(genreStorage.findAllGenres()).thenReturn(genreCollection);
        mockMvc.perform(get("/genres"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("genres-view"))
                .andExpect(model().attributeExists("genres"))
                .andExpect(model().attribute("genres", genreCollection));
    }

    @Test
    public void addGenreShouldRedirectToGenresEndPoint() {
        String result = underTest.addGenre("Test");
        assertThat(result).isEqualTo("redirect:genres");
    }

    @Test
    public void addGenreShouldStoreANewGenre() {
        underTest.addGenre("Test");
        verify(genreStorage).store(new Genre("Test"));
    }

    @Test
    public void addGenreEndpointShouldAddNewGenre() throws Exception {
        mockMvc.perform(post("/add-genre")
                .param("name", "Test"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        verify(genreStorage).store(new Genre("Test"));


    }
}





