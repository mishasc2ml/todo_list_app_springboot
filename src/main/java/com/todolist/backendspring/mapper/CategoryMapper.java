package com.todolist.backendspring.mapper;

import com.todolist.backendspring.dto.category.CategoryRequest;
import com.todolist.backendspring.dto.category.CategorySearchRequest;
import com.todolist.backendspring.entity.Category;
import com.todolist.backendspring.exception.InputFieldException;
import com.todolist.backendspring.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoryMapper {

    private final CategoryService categoryService;
    private final CommonMapper commonMapper;

    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    public Category getCategoryById(Long categoryId) {
        return categoryService.getCategoryById(categoryId);
    }

    public Category createCategory(CategoryRequest categoryCreateRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        }
        Category newCategory = commonMapper.convertToEntity(categoryCreateRequest, Category.class);
        return categoryService.createCategory(newCategory);
    }

    public Category updateCategory(CategoryRequest categoryRequest, Long categoryId, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        }
        return categoryService.updateCategory(commonMapper.convertToEntity(categoryRequest, Category.class), categoryId);
    }

    public String deleteCategory(Long categoryId) {
        return categoryService.deleteCategory(categoryId);
    }

    public List<Category> findCategoryByTitle(CategorySearchRequest categorySearchRequest) {
        return categoryService.findByTitle(categorySearchRequest.getTitle());
    }
}
