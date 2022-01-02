package com.example.projet_integration.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.Instant;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="postId")
    private Long postId;
    @Column(name="postName")
    private String postName;
    @Nullable
    @Column(name="url")
    private String url;
    @Nullable
    @Lob
    @Column(name="description")
    private String description;
    @Column(name="voteCount")
    private Integer voteCount = 0;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;
    @Column(name="createdDate")
    private Instant createdDate= Instant.now();
    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "id", referencedColumnName = "id")
    @Nullable
    private Categorie categorie;

}
