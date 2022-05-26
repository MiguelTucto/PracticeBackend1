package com.acme.practicebackend1.learning.service;

import com.acme.practicebackend1.learning.domain.model.entity.Post;
import com.acme.practicebackend1.learning.domain.persistence.PostRepository;
import com.acme.practicebackend1.learning.domain.service.PostService;
import com.acme.practicebackend1.shared.domain.exception.ResourceNotFoundException;
import com.acme.practicebackend1.shared.domain.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;
@Service
public class PostServiceImpl implements PostService {


    private final PostRepository postRepository;

    private static final String ENTITY = "Post";

    private final Validator validator;

    public PostServiceImpl(PostRepository postRepository, Validator validator) {
        this.postRepository = postRepository;
        this.validator = validator;
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public Page<Post> getAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Post getById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, postId));
    }

    @Override
    public Post create(Post request) {
        Set<ConstraintViolation<Post>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return postRepository.save(request);
    }

    @Override
    public Post update(Long postId, Post request) {
        Set<ConstraintViolation<Post>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return postRepository.findById(postId).map(post ->
                postRepository.save(
                        post.withTitle(request.getTitle())
                            .withDescription(request.getDescription())
                            .withContent(request.getContent())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, postId));
    }

    @Override
    public ResponseEntity<?> delete(Long postId) {

        return postRepository.findById(postId).map(post -> {
            postRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, postId));
    }
}
