package com.example.projet_integration.service;

import com.example.projet_integration.dto.PostResponse;
import com.example.projet_integration.model.Post;
import com.example.projet_integration.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Transactional
public class PostService {
    @Autowired
    private final PostRepository postRepository ;






    //adding a single post
    public  void addPost(Post post){
        postRepository.save(post);
    }


    public List<Post>fetchPostsbypost_id (long id) {
        List<Post> ArrayOfPost = new ArrayList<>();
        ArrayOfPost = postRepository.findAllByPostId(id);
        return  ArrayOfPost ;
    }


        public List<Post> fetchPostcategory (long id){
            List<Post> ArrayOfPost = new ArrayList<>();
            ArrayOfPost =  postRepository.findAllByCategorie_id( id);
            return  ArrayOfPost ;


    }
}
