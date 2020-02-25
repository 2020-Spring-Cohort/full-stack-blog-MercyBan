package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.storage.PostStorage;
import org.wcci.blog.models.Post;


@Controller
public class PostController {

    private PostStorage postStorage;

    public PostController(PostStorage postStorage) {

        this.postStorage = postStorage;
    }

    @RequestMapping("/post/{id}")
    public String displayPost(@PathVariable Long id, Model model){
        Post retrievedPost = postStorage.findPostById(id);
        model.addAttribute("post", retrievedPost);
        return "post-view";
    }
}
