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
import com.example.projet_integration.repository.UserRepository;
import com.example.projet_integration.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository ;
    @Autowired private CategorieRepository categorieRepository;
    @Autowired private UserRepository userRepository ;


    //adding a single comment
    @CrossOrigin(origins =  "http://localhost:4200")
    @PostMapping("/add")
    public ResponseEntity<String> addComment(@RequestBody CommentRequest commentRequest) {
        Post post = new Post();
        User user = new User() ;
        user.setUserId(userRepository.findByUsername(commentRequest.getUsername()).getUserId());
        post.setPostId(commentRequest.getPost());
        Comment comment=new Comment();
        comment.setId(comment.getId());
        comment.setPost(post);


        comment.setCreatedDate(String.valueOf(Instant.now()).substring(0,10));
        comment.setText(commentRequest.getText());
        comment.setUser(userRepository.findByUsername(commentRequest.getUsername()));
        comment.setUsername(commentRequest.getUsername());
        //userRepository.save(user);
        commentRepository.save(comment);
        return new ResponseEntity<>("\" comment added\"",OK);
    }
    //showing all the comment by postId
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/bypost")
    public List<Comment> fetchpostByuserId (@RequestBody CommentRequest commentRequest){
        Post post=new Post();
        post.setPostId(commentRequest.getPost());
        List<Comment> comments=commentRepository.getAllByPost_PostId(post.getPostId());
        return  comments ;

    }

    //showing all the comment by postId
    @CrossOrigin(origins = "http://localhost:4200" )
    @GetMapping("/bypost/{postId}")
    public List<Comment> fetchpostByuserid (@PathVariable("postId") Long postId){
       Comment post=new Comment();

        List<Comment> comments=commentRepository.getAllByPost_PostId(postId);
        return  comments ;

    }
}
