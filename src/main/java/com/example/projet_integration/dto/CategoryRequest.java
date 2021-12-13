package com.example.projet_integration.dto;

import com.example.projet_integration.model.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryRequest {
    public Long id ;
    public String name ;
    private String description;

}
