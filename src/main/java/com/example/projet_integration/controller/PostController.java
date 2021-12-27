package com.example.projet_integration.controller;


import com.example.projet_integration.dto.PostRequest;
import com.example.projet_integration.model.Categorie;
import com.example.projet_integration.model.Post;
import com.example.projet_integration.model.User;
import com.example.projet_integration.repository.CategorieRepository;
import com.example.projet_integration.repository.PostRepository;
import com.example.projet_integration.service.PostService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

@RestController
public class PostController {
    @Autowired
    private PostService postService ;
    @Autowired
    private PostRepository postRepository ;
    @Autowired private CategorieRepository categorieRepository;
    @PostMapping("/addpost")
    public ResponseEntity<Post> addPost(@RequestBody PostRequest postRequest) {
        Post post = new Post();
        User user= new  User();
        postRepository.save(postRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);



    }
    @PostMapping("/post/user")
    public ResponseEntity<String> fetchpostByuserId (@RequestBody PostRequest postRequest){
        //Post post = new Post();
        //post.setCategorie(Long.parseLong(postRequest.getCategorie()));
      List<Post> posts=postService.fetchPostsbypost_id(Long.parseLong(postRequest.getUserId()));
        if(posts!=null){
            return new ResponseEntity<String>("Posts trouvé"+posts ,OK);


        }
        else{
            return new ResponseEntity<String>("Posts non trouvé"+posts,NOT_FOUND);
        }
            //return new ResponseEntity<>("fetchpostBycategory okey","OK");

    }
    @PostMapping("/post/category")
    public ResponseEntity<String>  fetchpostBycategory (@RequestBody PostRequest postRequest){
        //Post post = new Post();
        //post.setCategorie(Long.parseLong(postRequest.getCategorie()));
        List<Post> posts= postService.fetchPostcategory(Long.parseLong(postRequest.getCategorie()));

        //return new ResponseEntity<>("fetchpostBycategory okey","OK");
        if(posts!=null){
            return new ResponseEntity<>("Posts trouvé"+posts ,OK);


        }
        else{
            return new ResponseEntity<>("Posts non trouvé",NOT_FOUND);
        }
    }
    @GetMapping("posts/{id}")
    public ResponseEntity<List<Post>> getPostsBycat(@PathVariable("id") Long id) {
        System.out.println(postService.fetchPostcategory(id));
        List<Post> posts= postService.fetchPostcategory(id);

        return status(HttpStatus.OK).body(posts);
    }

}
