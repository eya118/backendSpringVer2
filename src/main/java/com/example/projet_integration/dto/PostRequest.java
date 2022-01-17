package com.example.projet_integration.dto;


    import com.example.projet_integration.model.Categorie;
    import com.example.projet_integration.model.User;
    import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

    import java.time.Instant;

@Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public class PostRequest {

        private Categorie categorie; //
        private Long userId ;
    private String postName;
    private Long postId;
    private String url;

    private String description;
    private Integer voteCount = 0;
    private boolean solved_;


    private Instant createdDate;

    }


