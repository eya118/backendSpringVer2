package com.example.projet_integration.repository;

import com.example.projet_integration.model.Categorie;
import com.example.projet_integration.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> getAllByPost_PostId(Long id);

}
