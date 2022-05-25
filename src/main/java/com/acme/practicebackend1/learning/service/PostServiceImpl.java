package com.acme.practicebackend1.learning.service;

import com.acme.practicebackend1.learning.domain.model.entity.Post;
import com.acme.practicebackend1.learning.domain.persistence.PostRepository;
import com.acme.practicebackend1.learning.domain.service.PostService;
import com.acme.practicebackend1.shared.domain.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public Page<Post> getAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Post create(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post update(Long postId, Post request) {
        return postRepository.findById(postId).map(post -> {
            post.setTitle(request.getTitle());
            post.setDescription(request.getDescription());
            post.setContent(request.getContent());
            return postRepository.save(post);
        }).orElseThrow(() -> new ResourceNotFoundException("Post", postId));
    }

    @Override
    public ResponseEntity<?> delete(Long postId) {

        return postRepository.findById(postId).map(post -> {
            postRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Post", postId));
    }
}
