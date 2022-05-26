package com.acme.practicebackend1.learning.api;

import com.acme.practicebackend1.learning.domain.model.entity.Post;
import com.acme.practicebackend1.learning.domain.service.PostService;
import com.acme.practicebackend1.learning.mapping.PostMapper;
import com.acme.practicebackend1.learning.resource.CreatePostResource;
import com.acme.practicebackend1.learning.resource.PostResource;
import com.acme.practicebackend1.learning.resource.UpdatePostResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostsController {

    @Autowired
    private final PostService postService;

    private final PostMapper mapper;

    public PostsController(PostService postService, PostMapper mapper) {
        this.postService = postService;
        this.mapper = mapper;
    }


    @GetMapping
    public Page<PostResource> getAllPosts(Pageable pageable) {
        return mapper.modelListToPage(postService.getAll(), pageable);
    }

    @GetMapping("{postId}")
    public PostResource getPostById(@PathVariable Long postId) {
        return mapper.toResource(postService.getById(postId));
    }
    @PostMapping
    public PostResource createPost(@RequestBody CreatePostResource request) {
        return mapper.toResource(postService.create(mapper.toModel(request)));
    }

    @PutMapping("{postId}")
    public PostResource updatePost(@PathVariable Long postId, @RequestBody UpdatePostResource request) {
        return  mapper.toResource(postService.update(postId, mapper.toModel(request)))
                ;
    }

    @DeleteMapping("{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId) {
        return postService.delete(postId);
    }
}
