package com.example.projet_integration.controller;

import com.example.projet_integration.dto.CategoryRequest;
import com.example.projet_integration.dto.RegisterRequest;
import com.example.projet_integration.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;
@Data
@RestController
@CrossOrigin(origins =  "http://localhost:4200")
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {
    @Autowired
    final CategoryService categoryService ;


    @CrossOrigin(origins =  "http://localhost:4200")
    @PostMapping("/")
    public ResponseEntity<String> creat(@RequestBody CategoryRequest categoryRequest) {
      categoryService.createCategory(categoryRequest);
        return new ResponseEntity<>("saved",
                OK);
    }
    @CrossOrigin(origins =  "http://localhost:4200")
    @GetMapping("/")
    public ResponseEntity getAllCategory(){
        return ResponseEntity
                .status(OK)
                .body(categoryService.getAllCategory());
    }
    @CrossOrigin(origins =  "http://localhost:4200")
    @GetMapping("{id}")
    public ResponseEntity<CategoryRequest>getCategory(@PathVariable Long id){
        return ResponseEntity
                .status(OK)
                .body(categoryService.getCategory(id));
    }

}
