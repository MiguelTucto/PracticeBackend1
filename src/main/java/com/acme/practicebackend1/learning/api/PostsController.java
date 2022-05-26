package com.acme.practicebackend1.learning.api;

import com.acme.practicebackend1.learning.domain.model.entity.Post;
import com.acme.practicebackend1.learning.domain.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostsController {

    @Autowired
    private PostService postService;


    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAll();
    }

    @PostMapping
    public Post createPost(@Valid @RequestBody Post request) {
        return postService.create(request);
    }

    @PutMapping("{postId}")
    public Post updatePost(@PathVariable Long postId, @Valid @RequestBody Post request) {
        return  postService.update(postId, request);
    }

    @DeleteMapping("{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId) {
        return postService.delete(postId);
    }
}
