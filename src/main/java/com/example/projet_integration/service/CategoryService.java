package com.example.projet_integration.service;

import com.example.projet_integration.dto.CategoryRequest;
import com.example.projet_integration.dto.RegisterRequest;
import com.example.projet_integration.exception.CategoryException;
import com.example.projet_integration.model.Categorie;
import com.example.projet_integration.repository.CategorieRepository;
import com.example.projet_integration.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Transactional
public class CategoryService {
    @Autowired
    private final CategorieRepository categorieRepository ;


    public void createCategory(CategoryRequest categoryRequest) {
        Categorie categorie = new Categorie();
        categorie.setName(categoryRequest.getName());
        categorie.setCreatedDate(Instant.now());
        categorie.setDescription(categoryRequest.getDescription());
        categorieRepository.save(categorie);
    }
    @Transactional(readOnly = true)
    public List<CategoryRequest> getAllCategory() {
        return categorieRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(toList());
    }

    private CategoryRequest mapToDto(Categorie categorie) {
       return  CategoryRequest.builder().name(categorie.getName())
               .id(categorie.getId())
               .description(categorie.getDescription())
               .build();
    }

    public CategoryRequest getCategory(Long id) {
        Categorie categorie=categorieRepository.findById(id)
                .orElseThrow(()->new CategoryException("no category found with ID - " + id));
        return CategoryRequest.builder().name(categorie.getName())
                .id(categorie.getId())
                .description(categorie.getDescription())
                .build();
    }
}
