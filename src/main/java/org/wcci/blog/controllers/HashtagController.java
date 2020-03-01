package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wcci.blog.models.Genre;
import org.wcci.blog.models.Hashtag;
import org.wcci.blog.storage.HashtagStorage;

@Controller
    public class HashtagController {
    private HashtagStorage hashtagStorage;

    public HashtagController(HashtagStorage hashtagStorage) {

        this.hashtagStorage = hashtagStorage;
    }

    @RequestMapping("/hashtags")
    public String displayHashtag(Model model) {
        model.addAttribute("hashtags", hashtagStorage.findAllHashtags());
        return "hashtags-view";
    }

    @RequestMapping("/hashtags/{id}")
    public String displayHashtag(@PathVariable Long id, Model model) {
        Hashtag retrievedHashtag = hashtagStorage.findHashtagById(id);
        model.addAttribute("hashtag", retrievedHashtag);
        return "hashtag";
    }

    @PostMapping("/add-hashtag")
    public String addGenre(@RequestParam String hashtag) {
        hashtagStorage.store(new Hashtag(hashtag));
        return "redirect:hashtags";

    }
}

