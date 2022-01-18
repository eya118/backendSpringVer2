package com.example.projet_integration.dto;

import com.example.projet_integration.model.Categorie;
import com.example.projet_integration.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.Instant;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;


@Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class PostResponse {

    private Long postId;
    private String postName;

    private String url;

    private String description;
    private Integer voteCount = 0;

    private User user;
    private Instant createdDate;
    public   boolean solved_;

    //private Categorie categorie;
    }


