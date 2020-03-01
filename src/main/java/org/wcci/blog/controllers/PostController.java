package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wcci.blog.models.Author;
import org.wcci.blog.models.Genre;
import org.wcci.blog.models.Hashtag;
import org.wcci.blog.storage.PostStorage;
import org.wcci.blog.models.Post;


@Controller
public class PostController {

    private PostStorage postStorage;

    public PostController(PostStorage postStorage) {

        this.postStorage = postStorage;
    }
    @RequestMapping("/posts")
    public String displayPosts(Model model) {
       model.addAttribute("posts", postStorage.getAll());
        return "post-view";
    }

    @RequestMapping("/post/{id}")
    public String displayPost(@PathVariable Long id, Model model){
        Post retrievedPost = postStorage.findPostById(id);
        model.addAttribute("post", retrievedPost);
        return "post";
    }

    @PostMapping("/add-post")
    public String addReview(@RequestParam Genre genre, String title, String postBody, Author author, Hashtag... hashtag) {
        postStorage.store(new Post(postBody, title, genre, author));
        return "redirect:post";
    }


}
