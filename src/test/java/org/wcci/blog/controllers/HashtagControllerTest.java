package org.wcci.blog.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.wcci.blog.models.Genre;
import org.wcci.blog.models.Hashtag;
import org.wcci.blog.storage.HashtagStorage;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

public class HashtagControllerTest {
        private HashtagController underTest;
        private Model model;
        private HashtagStorage mockStorage;
        private Hashtag testHashtag;


        @BeforeEach
        void setUp() {
                mockStorage = mock(HashtagStorage.class);
                underTest = new HashtagController(mockStorage);
                model = mock(Model.class);
                Genre testGenre = new Genre("Test");
                testHashtag = new Hashtag("Testo");
                when(mockStorage.findHashtagById(1L)).thenReturn(testHashtag);
        }
        @Test
        public void displayHashtagReturnsHashtagTemplate(){
                String result = underTest.displayHashtag(1L, model);
                assertThat(result).isEqualTo("hashtags-view");

        }
        @Test
        public void displayHashtagInteractsWithDependenciesCorrectly(){
                underTest.displayHashtag(1L,model);
                verify(mockStorage).findHashtagById(1L);
                verify(model).addAttribute("hashtag", testHashtag);
        }
        @Test
        public void displayPostMappingIsCorrect() throws Exception {
                MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
                List<Hashtag> mockHashtag = Collections.singletonList(testHashtag);
                when(mockStorage.findAllHashtags()).thenReturn(mockHashtag);
                mockMvc.perform(MockMvcRequestBuilders.get("/hashtags/"))
                        .andExpect(status().isOk())
                        .andExpect(view().name("hashtags-view"))
                        .andExpect(model().attributeExists("hashtags"))
                        .andExpect(model().attribute("hashtags", mockHashtag));
        }

}

