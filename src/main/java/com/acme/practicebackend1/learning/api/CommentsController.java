package com.acme.practicebackend1.learning.api;

import com.acme.practicebackend1.learning.domain.service.CommentService;
import com.acme.practicebackend1.learning.mapping.CommentMapper;
import com.acme.practicebackend1.learning.resource.CommentResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/posts/{postId}/comments")
public class CommentsController {

    private final CommentService commentService;
    private final CommentMapper mapper;

    public CommentsController(CommentService commentService, CommentMapper mapper) {
        this.commentService = commentService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<CommentResource> getAllCommentsByPostId(@PathVariable Long postId, Pageable pageable){
        return mapper.modelListToPage(commentService.getAllByPostId(postId), pageable);
    }


}
