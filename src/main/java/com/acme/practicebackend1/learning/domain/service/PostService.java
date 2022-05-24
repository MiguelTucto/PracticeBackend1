package com.acme.practicebackend1.learning.domain.service;

import com.acme.practicebackend1.learning.domain.model.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
    List<Post> getAll();
    Page<Post> getAll(Pageable pageable);
}
