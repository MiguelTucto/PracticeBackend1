package com.acme.practicebackend1.learning.api;

import com.acme.practicebackend1.learning.domain.model.entity.Post;
import com.acme.practicebackend1.learning.domain.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PostsController {

    @Autowired
    private PostService postService;


    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.getAll();
    }
}
