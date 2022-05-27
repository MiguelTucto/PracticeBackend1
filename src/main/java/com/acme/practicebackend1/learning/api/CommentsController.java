package com.acme.practicebackend1.learning.api;

import com.acme.practicebackend1.learning.domain.service.CommentService;
import com.acme.practicebackend1.learning.mapping.CommentMapper;
import com.acme.practicebackend1.learning.resource.CommentResource;
import com.acme.practicebackend1.learning.resource.CreateCommentResource;
import com.acme.practicebackend1.learning.resource.UpdateCommentResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Posts") // Con esto colocamostodo junto con el Post
@RestController      //  pese a que es Comment
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

    @PostMapping
    public CommentResource createComment(@PathVariable Long postId, @RequestBody CreateCommentResource request) {
        return mapper.toResource(commentService.create(postId, mapper.toModel(request)));
    }

    @PutMapping("{commentId}")
    public CommentResource updateComment(@PathVariable Long postId, @PathVariable Long commentId, @RequestBody UpdateCommentResource request) {
        return mapper.toResource(commentService.update(postId, commentId, mapper.toModel(request)));
    }

    @DeleteMapping("{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable Long postId, @PathVariable Long commentId) {
        return commentService.delete(postId, commentId);
    }
}
