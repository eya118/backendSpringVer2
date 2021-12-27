package com.example.projet_integration.repository;


import com.example.projet_integration.dto.PostRequest;
import com.example.projet_integration.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    Post findPostsByCategorieId(long id);
    List<Post> findAllByPostId(long id);
    List<Post> findAllByCategorie_id(long id);
    Post save(PostRequest p) ;
   //ArrayList<Post>  findPostsByUsername (String username) ;
    //Post deletePostByPostId(long postId);
}
