package com.todolist.backendspring.mapper;

import com.todolist.backendspring.dto.category.CategoryRequest;
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

    public Category createCategory(CategoryRequest category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        }
        Category newCategory = commonMapper.convertToEntity(category, Category.class);
        return categoryService.createCategory(newCategory);
    }

    public Category updateCategory(CategoryRequest category, Long categoryId, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        }
        return categoryService.updateCategory(commonMapper.convertToEntity(category, Category.class), categoryId);
    }

    public String deleteCategory(Long categoryId) {
        return categoryService.deleteCategory(categoryId);
    }

    public List<Category> findCategoryByTitle(String title) {
        return categoryService.findCategoriesByTitle(title);
    }
}
