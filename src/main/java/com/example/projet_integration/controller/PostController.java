package com.example.projet_integration.controller;


import com.example.projet_integration.dto.PostRequest;
import com.example.projet_integration.model.Categorie;
import com.example.projet_integration.model.Post;
import com.example.projet_integration.model.User;
import com.example.projet_integration.repository.CategorieRepository;
import com.example.projet_integration.repository.PostRepository;
import com.example.projet_integration.repository.UserRepository;
import com.example.projet_integration.service.PostService;
import javafx.geometry.Pos;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/post")
public class PostController {


    @Autowired
    private PostService postService;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CategorieRepository categorieRepository;

    @Autowired
    private UserRepository userRepository;

    //adding a single post
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/add")
    public ResponseEntity<Post> addPost(@RequestBody PostRequest postRequest) {
        Post post = new Post();
        Categorie categorie = postRequest.getCategorie();
        //categorie.setId(postRequest.getCategorie());
        User user = new User();
        user=userRepository.findByUserId(postRequest.getUserId());
        //user.setUserId(postRequest.getUserId());
        post.setPostId(postRequest.getPostId());
        post.setPostName(post.getPostName());
        post.setCategorie(categorie);
        post.setDescription(post.getDescription());
        post.setCreatedDate(String.valueOf(Instant.now()).substring(0, 10));
        post.setUrl(postRequest.getUrl());
        post.setSolved_(postRequest.isSolved_());
        post.setCategorie(categorie);
        post.setUser(user);
        post.setCategorie(categorie);
        //post.setUser(user);
        postRepository.save(post);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // return a list of all the posts
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public List<Post> getAllPost() {
        List<Post> allposts = new ArrayList<>();
        List<Post> posts = postRepository.findAll();
        allposts = posts;
        return allposts;
    }

    // return a list of all the posts of a single user
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/user")
    public List<Post> fetchpostByuserId(@RequestBody PostRequest postRequest) {
        List<Post> posts = postService.fetchPostsbypost_id(postRequest.getUserId());
        return posts;

    }

    // return a list of all the posts of a single category
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/category")
    public List<Post> fetchpostBycategory(@RequestBody PostRequest postRequest) {

        List<Post> posts = postService.fetchPostcategory(postRequest.getCategorie().getId());
        return posts;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("category/{id}")
    public ResponseEntity<List<Post>> getPostsBycat(@PathVariable("id") Long id) {
        System.out.println(postService.fetchPostcategory(id));
        List<Post> posts = postService.fetchPostcategory(id);

        return status(HttpStatus.OK).body(posts);
    }

}
