package com.todolist.backendspring.service.impl;

import com.todolist.backendspring.dto.category.CategoryRequest;
import com.todolist.backendspring.entity.Category;
import com.todolist.backendspring.exception.NotFoundException;
import com.todolist.backendspring.exception.NotUniqueValueException;
import com.todolist.backendspring.repository.CategoryRepository;
import com.todolist.backendspring.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        String newCategoryTitle = category.getTitle();
        if (categoryRepository.findByTitle(newCategoryTitle).size() > 0) {
            throw new NotUniqueValueException("Such category already exists");
        }
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Category not found, not valid id", HttpStatus.NOT_FOUND));
        categoryRepository.delete(category);
    }

    @Override
    public Category updateCategory(CategoryRequest categoryRequest, Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Category not found, not valid id", HttpStatus.NOT_FOUND));
        category.setTitle(categoryRequest.getTitle());
        return category;
    }
}
