package com.acme.practicebackend1.learning.domain.service;

import com.acme.practicebackend1.learning.domain.model.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> getAll();
    Page<Post> getAll(Pageable pageable);
    Post create(Post post);
    Post update(Long postId, Post request);
    ResponseEntity<?> delete(Long postId);
}
