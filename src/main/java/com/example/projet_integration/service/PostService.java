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

    public  void addPost(Post post){
        postRepository.save(post);
    }
    public List<Post>fetchPostsbypost_id (long id) {
        List<Post> ArrayOfPost = new ArrayList<>();
        ArrayOfPost = postRepository.findAllByPostId(id);
        for (Post post : ArrayOfPost) {
            System.out.println(" heyyyyyyy postId " +
                    post.getPostId()
                    + post.getPostName() + "post description " +
                    post.getDescription());
        }
        return  ArrayOfPost ;
    }
        public List<Post> fetchPostcategory (long id){
            List<Post> ArrayOfPost = new ArrayList<>();
            ArrayOfPost =  postRepository.findAllByCategorie_id( id);
            for (Post post :ArrayOfPost) {
                System.out.println(" heyyyyyyy postId "+
                        post.getPostId()
                        +post.getPostName()+"post description "+
                        post.getDescription() +
                        post.getCategorie().getName());
            }
            return  ArrayOfPost ;
            //return ArrayOfPost.stream().map(PostResponse::mapToDto).collect(toList());

    }
}
