package com.acme.practicebackend1.learning.domain.persistence;

import com.acme.practicebackend1.learning.domain.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
