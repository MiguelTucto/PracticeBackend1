package com.acme.practicebackend1.learning.service;

import com.acme.practicebackend1.learning.domain.model.entity.Post;
import com.acme.practicebackend1.learning.domain.persistence.PostRepository;
import com.acme.practicebackend1.learning.domain.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
