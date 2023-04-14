package com.todolist.backendspring.service;

import com.todolist.backendspring.dto.category.CategoryRequest;
import com.todolist.backendspring.entity.Category;

public interface CategoryService {

    Category createCategory(Category category);

    void deleteCategory(Long id);

    Category updateCategory(CategoryRequest categoryRequest, Long id);
}
