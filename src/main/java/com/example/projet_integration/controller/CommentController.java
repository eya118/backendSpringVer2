package com.example.projet_integration.controller;

import com.example.projet_integration.dto.CommentRequest;
import com.example.projet_integration.dto.PostRequest;
import com.example.projet_integration.model.Categorie;
import com.example.projet_integration.model.Comment;
import com.example.projet_integration.model.Post;
import com.example.projet_integration.model.User;
import com.example.projet_integration.repository.CategorieRepository;
import com.example.projet_integration.repository.CommentRepository;
import com.example.projet_integration.repository.PostRepository;
import com.example.projet_integration.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository ;
    @Autowired private CategorieRepository categorieRepository;


    //adding a single comment
    @PostMapping("/add")
    public ResponseEntity<Comment> addComment(@RequestBody CommentRequest commentRequest) {
        Post post = new Post();
        post.setPostId(commentRequest.getPost());
        Comment comment=new Comment();
        comment.setId(comment.getId());
        comment.setPost(post);
        //comment.setCreatedDate(comm.getCreatedDate());
        comment.setCreatedDate(Instant.now());
        comment.setText(commentRequest.getText());

        commentRepository.save(comment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    //showing all the comment by postId
    @PostMapping("/bypost")
    public List<Comment> fetchpostByuserId (@RequestBody CommentRequest commentRequest){
        Post post=new Post();
        post.setPostId(commentRequest.getPost());
        List<Comment> comments=commentRepository.getAllByPost_PostId(post.getPostId());
        return  comments ;

    }
}
