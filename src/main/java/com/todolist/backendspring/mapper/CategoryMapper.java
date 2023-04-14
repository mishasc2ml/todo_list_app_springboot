package com.todolist.backendspring.mapper;

import com.todolist.backendspring.dto.category.CategoryRequest;
import com.todolist.backendspring.entity.Category;
import com.todolist.backendspring.exception.InputFieldException;
import com.todolist.backendspring.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
@RequiredArgsConstructor
public class CategoryMapper {

    private final CommonMapper commonMapper;
    private final CategoryService categoryService;

    public Category createCategory(CategoryRequest categoryCreateRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        }
        Category newCategory = commonMapper.convertToEntity(categoryCreateRequest, Category.class);
        return categoryService.createCategory(newCategory);
    }

    public Category updateCategory(CategoryRequest categoryRequest, Long id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        }
        return categoryService.updateCategory(categoryRequest, id);
    }

    public void deleteCategory(Long id) {
        categoryService.deleteCategory(id);
    }
}
