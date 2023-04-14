package com.todolist.backendspring.contoller;

import com.todolist.backendspring.dto.category.CategoryRequest;
import com.todolist.backendspring.entity.Category;
import com.todolist.backendspring.mapper.CategoryMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryMapper categoryMapper;

    @PostMapping("/new")
    public ResponseEntity<Category> createCategory(@Valid @RequestBody CategoryRequest categoryCreateRequest,
                                                   BindingResult bindingResult) {
        return ResponseEntity.ok(categoryMapper.createCategory(categoryCreateRequest, bindingResult));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable Long id) {
        categoryMapper.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id,
                                                   @Valid @RequestBody CategoryRequest categoryRequest,
                                                   BindingResult bindingResult) {
        return ResponseEntity.ok(categoryMapper.updateCategory(categoryRequest, id, bindingResult));
    }
}
