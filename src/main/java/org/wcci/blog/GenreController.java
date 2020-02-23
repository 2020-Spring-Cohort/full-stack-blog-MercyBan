package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GenreController {
    private GenreStorage genreStorage;

    public GenreController(GenreStorage genreStorage) {
        this.genreStorage = genreStorage;
    }

    @RequestMapping("/genres")
    public String displayGenres(Model model) {
        model.addAttribute("genres", genreStorage.findAllGenres());
        return "genresView";
    }

    @GetMapping("/genres/{genreType}")
    public String displaySingleGenre(@PathVariable String genreType, Model model) {
        Genre retrievedGenre = genreStorage.findGenreByType(genreType);
        model.addAttribute("genre", retrievedGenre);

        return "genreView";

    }
    @PostMapping("/add-genre")
    public String  addGenre(@RequestParam String location) {
        genreStorage.store(new Genre(location));
        return "redirect:genres";


    }
}
