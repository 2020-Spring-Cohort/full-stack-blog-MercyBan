package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wcci.blog.storage.GenreStorage;
import org.wcci.blog.models.Genre;

import java.util.Optional;

@Controller
public class GenreController {
    private GenreStorage genreStorage;

    public GenreController(GenreStorage genreStorage) {

        this.genreStorage = genreStorage;
    }

    @RequestMapping("/genres")
    public String displayGenres(Model model) {
        model.addAttribute("genres", genreStorage.findAllGenres());
        return "genres-view";
    }

    @GetMapping("/genres/{id}")
    public String displaySingleGenre(@PathVariable Long id, Model model) {
        Optional<Genre> retrievedGenre = genreStorage.findGenreById(id);
        model.addAttribute("genre", retrievedGenre.get());

        return "genre";

    }
    @PostMapping("/add-genre")
    public String  addGenre(@RequestParam String name) {
        genreStorage.store(new Genre(name));
        return "redirect:genres";


    }
}
