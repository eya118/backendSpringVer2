package com.example.projet_integration.controller;

import com.example.projet_integration.dto.CategoryRequest;
import com.example.projet_integration.dto.RegisterRequest;
import com.example.projet_integration.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {
    @Autowired
    final CategoryService categoryService ;



    @PostMapping("/")
    public ResponseEntity<String> creat(@RequestBody CategoryRequest categoryRequest) {
      categoryService.createCategory(categoryRequest);
        return new ResponseEntity<>("saved",
                OK);
    }
    @GetMapping("/")
    public ResponseEntity getAllCategory(){
        return ResponseEntity
                .status(OK)
                .body(categoryService.getAllCategory());
    }
    @GetMapping("{id}")
    public ResponseEntity<CategoryRequest>getCategory(@PathVariable Long id){
        return ResponseEntity
                .status(OK)
                .body(categoryService.getCategory(id));
    }

}
