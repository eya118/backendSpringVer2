package com.example.projet_integration.controller;


import com.example.projet_integration.dto.PostRequest;
import com.example.projet_integration.model.Categorie;
import com.example.projet_integration.model.Post;
import com.example.projet_integration.model.User;
import com.example.projet_integration.repository.CategorieRepository;
import com.example.projet_integration.repository.PostRepository;
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
@RequestMapping("/post")
public class PostController {



    @Autowired
    private PostService postService ;
    @Autowired
    private PostRepository postRepository ;
    @Autowired private CategorieRepository categorieRepository;


    //adding a single post
    @PostMapping("/add")
    public ResponseEntity<Post> addPost(@RequestBody PostRequest postRequest) {
        Post post = new Post();
        Categorie categorie=new Categorie();
        categorie.setId(postRequest.getCategorie());
        User user= new  User();
        user.setUserId(postRequest.getUserId());
        post.setPostId(postRequest.getPostId());
        post.setPostName(post.getPostName());
       post.setCategorie(categorie);
       post.setDescription(post.getDescription());
       post.setCreatedDate(Instant.now());
       post.setUrl(postRequest.getUrl());
       //post.setUser(user);
        postRepository.save(post);
       return new ResponseEntity<>(HttpStatus.CREATED);
    }
    // return a list of all the posts
    @GetMapping("/all")
    public List<Post> getAllPost(){
        List<Post> allposts=new ArrayList<>();
        List<Post> posts= postRepository.findAll();
        allposts=posts ;
        return  allposts ;
    }
    // return a list of all the posts of a single user
    @PostMapping("/user")
    public List<Post> fetchpostByuserId (@RequestBody PostRequest postRequest){
      List<Post> posts=postService.fetchPostsbypost_id(postRequest.getUserId());
      return  posts ;

    }
    // return a list of all the posts of a single category
    @PostMapping("/category")
    public  List<Post> fetchpostBycategory (@RequestBody PostRequest postRequest){

        List<Post> posts= postService.fetchPostcategory(postRequest.getCategorie());
        return  posts ;
    }
    @GetMapping("category/{id}")
    public ResponseEntity<List<Post>> getPostsBycat(@PathVariable("id") Long id) {
        System.out.println(postService.fetchPostcategory(id));
        List<Post> posts= postService.fetchPostcategory(id);

        return status(HttpStatus.OK).body(posts);
    }

}
