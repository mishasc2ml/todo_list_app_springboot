package com.todolist.backendspring.contoller;

import com.todolist.backendspring.dto.category.CategoryRequest;
import com.todolist.backendspring.dto.category.CategorySearchRequest;
import com.todolist.backendspring.entity.Category;
import com.todolist.backendspring.mapper.CategoryMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryMapper.getAllCategories());
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long categoryId) {
        return ResponseEntity.ok(categoryMapper.getCategoryById(categoryId));
    }

    @PostMapping("/new")
    public ResponseEntity<Category> createCategory(@Valid @RequestBody CategoryRequest category,
                                                   BindingResult bindingResult) {
        return ResponseEntity.ok(categoryMapper.createCategory(category, bindingResult));
    }

    @DeleteMapping("{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(categoryMapper.deleteCategory(categoryId));
    }

    @PatchMapping("{categoryId}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long categoryId,
                                                   @Valid @RequestBody CategoryRequest category,
                                                   BindingResult bindingResult) {
        return ResponseEntity.ok(categoryMapper.updateCategory(category, categoryId, bindingResult));
    }

    @PostMapping("/search")
    public ResponseEntity<List<Category>> findCategory(@RequestBody CategorySearchRequest filter) {
        return ResponseEntity.ok(categoryMapper.findCategoryByTitle(filter.getTitle()));
    }
}
